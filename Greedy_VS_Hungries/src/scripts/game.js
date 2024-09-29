import Greedy from "./greedy";
import KeyManager from "./keyManager";
import Fruit from "./fruit";
import Hungrie from "./hungrie";
import Mobile from "./mobile";

export default class Game {

   #canvas;
   
   /** 
    * Constructeur de la classe Game
    */
   constructor(canvas) {
      this.#canvas = canvas;
      this.context = canvas.getContext("2d");
      this.greedy= new Greedy(this.canvas.width/2,this.canvas.height/2);// place le greedy au centre
      this.hungries = [];
      this.requeteAnim = null;
      this.keyManager = new KeyManager();
      this.fruits=[];
      this.fruitStart=null;
      this.greedy_max_score=0;
      this.choixCouleur();// rempli le fond du canvas d'une couleur en fonction du choix de l'utilisateur
   }



   /**
    * Extension ajouté
    * Affiche le plus grand score que greedy à fait.
    */
   affichage_du_plus_grand_score(){
    if (parseInt(score.innerHTML)> this.greedy_max_score){ // si l'ancien score est plus grand que le score actuel 
        this.greedy_max_score=parseInt(score.innerHTML); // alors le remplacer
        const score_max= document.getElementById("score_max");
        score_max.innerHTML = `🏆SCORE MAXIMAL : ${this.greedy_max_score}`; // et l'afficher 
    }
   }

   /**
    * Extension ajouté
    * Demande à l'utilisateur de choisir un fond de couleur dans le quel il jouera.
    * Si la saisie est incorrect, un message apparait et l'utilisateur peut re-saisir son choix.
    */
   choixCouleur() {
    const choix_couleur = { // Les choix parmis lesquels choisir.
        bleu : "rgb(73, 160, 237)",
        jaune: "rgb(244, 244, 113)",
        vert: "rgb(89, 224, 89)",
        violet:"rgb(197, 91, 197)",
        marron : "rgb(169, 72, 24)",
        orange:"rgb(254, 126, 41)",
        rose : "rgb(255, 155, 171)",
        rouge : "rgb(245, 65, 65)",
    };
    

    const couleur = prompt("Quelle couleur préférez vous pour cette aventure fruitée ?\n\n Décidez entre : Jaune🍌 - Vert🥝 - Rouge🍓 - Violet🍇 - Marron🥥 - Orange🥭 - Bleu💦 - Rose🌸 \n\n");

    // si la saisie fait partie des choix
    if (couleur && choix_couleur.hasOwnProperty(couleur.toLowerCase())) { // le choix est insensible à la casse.
        this.fond_choisi(choix_couleur[couleur.toLowerCase()]); 
    }
    
    else { 
        alert("Oups, saisie invalide.\n\n Veuillez faire un choix parmis les couleurs proposés.");
        this.choixCouleur(); // redemander a l'utilisateur d'entrer son choix
    }

    }
    /** 
     * Extension ajouté
     * Change le fond en fonction de la couleur choisi
     * @param {string} background Le fond en fonction de la couleur choisi
     */
    fond_choisi(background) {
        const playfield = document.getElementById("playfield");
        playfield.style.backgroundColor =`${background}` ;
    }


   /** donne accès au canvas correspondant à la zone de jeu */
   get canvas() {
      return this.#canvas;
   }

   /**
    * Lance et Stop le jeu
    */
   startAndStop(){
      const button = document.getElementById("stopAndStartGame");
      if (this.requeteAnim){
        button.innerHTML="Jouer"
        cancelAnimationFrame(this.requeteAnim);
        this.requeteAnim=null;
        clearTimeout(this.fruitStart);
        
      }
  
      else{
        button.innerHTML="Stop"
        this.animate(); // Lance l'animation
        this.fruitApparition(); // Fait apparaitre les fruits
        this.hungries.forEach(h=>{
            h.cible(this.fruits,this.greedy);  // Indique a chaque hungrie sa cible à manger.
        });
    }
   }

   /**
    * Fait apparaitre un hungrie quand aucun hungrie est présent dans le canvas.
    * @param {Hungrie} hungrie 
    */
   hungrie_apparition(hungrie) {
    if (this.hungries.length === 0) { // si aucun hungrie est present
        const hungrie = new Hungrie(this.canvas);
        this.hungries.push(hungrie); // ajouter un hungrie
    }
    }


    /**
     * Extension ajouter
     * Recommence la partie: reinitialise le jeu et redonne des vies a greedy.
     */
    recommencer(){
        this.affichage_du_plus_grand_score();
        const lifesContainer = document.getElementById('lifes');
        lifesContainer.innerHTML = ` 
            <img src="images/greedy64.png" alt="" id="life-1" />
            <img src="images/greedy64.png" alt="" id="life-2" />
            <img src="images/greedy64.png" alt="" id="life-3" />
        `; // Redonne des vies à greedy
        
        this.fruits = []; // Reinitialise à 0 le tableau de fruits
        this.hungries = []; // Reinitialise le tableau de hungries
        let score = document.getElementById("score");
        score.innerHTML=0; // remet le score du greedy à 0
        this.greedy.x=this.canvas.width/2;
        this.greedy.y=this.canvas.height/2;
        const ctxt = this.canvas.getContext("2d");
        ctxt.clearRect(0, 0, this.canvas.width, this.canvas.height); // efface le canvas
        this.keyManager.reset(); // Reinitialise les touches de deplacement

        this.startAndStop(); // Redemarre le jeu
    }
    
    
    /**
     * Lance la partie, anime le jeu.
     * @returns Rien (permet d'évité le relancement de la partie quand greedy n'a plus de vie)
     */
    animate(){
        const ctxt = this.canvas.getContext("2d");
        ctxt.clearRect(0, 0, this.canvas.width, this.canvas.height);
        this.greedy.handleMoveKeys(this.keyManager);
        this.greedy.move(this.canvas); // déplace le greedy
        this.greedy.draw(ctxt); // dessine le greedy

        // Augmente de 100 le score du greedy lorsqu'il à une collision avec un fruit
        this.fruits.forEach(f=>{
            if (f.collisionWith(this.greedy)){
            
                let score = document.getElementById("score");
                score.innerHTML=parseInt(score.innerHTML)+100;

            }
        });

        // Supprime les fruits qui ont été en collision avec greedy
        this.fruits = this.fruits.filter(fruit => fruit.collisionWith(this.greedy)==false);

        this.hungrie_apparition(); // Quand il n'y a plus de hungrie un hungrie apparait.

        // Ajoute un point a un hungrie lorsqu'il rentre en collision avec un fruit et supprime ce fruit.
        this.hungries.forEach(h=>{
            this.fruits.forEach(f=>{

                if(f.collisionWith(h)){
                    this.fruits = this.fruits.filter(fruit =>fruit.collisionWith(h)==false);
                    h.points=h.points+1;
                    if (h.points>0 && h.points%7 ==0  ){ // Tout les 7 fruits mangés par un même hungrie fait un apparaitre un nouveau hungrie 
                        const hungrie = new Hungrie(this.canvas);
                        this.hungries.push(hungrie);
                       
                    }
                }
            });
        });
        
        this.fruits.forEach(f=>f.draw(ctxt)); // Dessine les fruits présents qui donc n'ont eu 0 collision.

        // Gere le deplacement de chaque hungrie en fonction de la cible qui lui est attribué.
        this.hungries.forEach(h=>{
            h.cible(this.fruits, this.greedy);
            h.moveHungrie(this.canvas);
            h.draw(ctxt);

        });

        // Supprime une vie de greedy lorsqu'il rentre en collision avec un hungrie et supprime ce hungrie.
        this.hungries.forEach(h=>{
            if (h.collisionWith(this.greedy)){
                const i=this.hungries.indexOf(h); // prend l'index du hungrie qui a eu une collision
                this.hungries.splice(i,1); // supprime ce hungrie
                const vies_greedy= document.querySelectorAll('#lifes img'); // prend la liste des img dans l'id #lifes qui équivaut aux vies du greedy
                if (vies_greedy.length>0){
                    vies_greedy[0].remove(); // supprime une image donc une vie du greedy.
                }
            }
            
        });

        const vies_greedy= document.querySelectorAll('#lifes img'); // récupere la liste des images qui correspondent aux vies du greedy
        if (vies_greedy.length == 0){ // si cette liste est vide donc si greedy n'a plus de vies
            alert("Perdu. Mais pas de panique 💪\n\n Cliquez sur OK pour plonger dans une nouvelle partie et montrer à ces hungries qui est le vrai champion de la gourmandise ! 🏆 ");
            cancelAnimationFrame(this.requeteAnim); // Arrete l'animation
            this.recommencer(); // recommence le jeu
            return; // evite le relancement de la partie quand greedy n'a plus de vie car sinon il y'aura une boucle infini sur l'affichage de la fenetre.
        }

        this.requeteAnim = requestAnimationFrame(() => this.animate());   
    }
    
    /**
     * Toutes les secondes un fruit apparait, et après 8 secondes il disparait.
     */
    fruitApparition() {
        const FruitQuiApparait = ()=>{

            const fruit = new Fruit(this.canvas, this.context);
            this.fruits.push(fruit);
            
            this.fruitStart = setTimeout(()=> {

                this.fruits = this.fruits.filter(f => f !== fruit);

            }, 8000);

            this.fruitStart=setTimeout(FruitQuiApparait, 1000); 
        };

        FruitQuiApparait();
    }


    /**
     * Gere l'appuie sur les touches du clavier
     * @param {*} event 
     */
    keyDownActionHandler(event) {
        switch (event.key) {
            case "ArrowLeft":
            case "Left":
                this.keyManager.leftPressed(); // Indique que la touche gauche est appuyé
                break;
            case "ArrowRight":
            case "Right":
                this.keyManager.rightPressed(); // Indique que la touche droite est appuyé
                break;
            case "ArrowDown":
            case "Down":
                this.keyManager.downPressed(); // Indique que la touche bas est appuyé
                break;
            case "ArrowUp":
            case "Up":
                this.keyManager.upPressed(); // Indique que la touche haut est appuyé
                break;
            
            default: return;
        }
        event.preventDefault();
    }


    /**
    * Gere le relachement des touches du clavier
    * @param {*} event 
    */
    keyUpActionHandler(event) {
        switch (event.key) {
            case "ArrowLeft":
            case "Left":
                this.keyManager.leftReleased(); // Indique que la touche gauche est relaché
                break;
            case "ArrowRight":
            case "Right":
                this.keyManager.rightReleased(); // Indique que la touche droite est relaché
                break;
            case "ArrowDown":
            case "Down":
                this.keyManager.downReleased(); // Indique que la touche bas est relaché
                break;
            case "ArrowUp":
            case "Up":
                this.keyManager.upReleased(); // Indique que la touche haut est relaché
                break;
            default: return;
        }
        event.preventDefault();
    }







        
    
    }



