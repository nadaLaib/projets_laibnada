import hungrieImgSrc from  '../scripts/assets/images/hungry.png';
import Mobile from './mobile';
import Game from './game';
import Greedy from './greedy';

export default class Hungrie{

    cibleX;
    cibleY;

    /**
     * Constructeur de Hungrie
     */
    constructor(canvas) {

        this.image = this.#createImage(hungrieImgSrc);

        // Place un hungrie au hasard à une position x et y au hasard dans le canvas       
        const x = Math.random()*(canvas.width-this.image.width); 
        const y = Math.random()*(canvas.height-this.image.height);

        this.x=x;
        this.y=y;

        this.points=0;
    }

    /**
     * Ajoute un point à l'hungrie
     */
    ajoutePoint(){
        this.points++;
    }

     /* crée l'objet Image à utiliser pour dessiner un hungrie */
    #createImage(imageSource) {
        const newImg = new Image();
        newImg.src = imageSource;
        return newImg;
    }

    /**
     * Renvoie la largeur de l'image
     */
    get width() {
        return this.image.width;
    }

    /**
     * Renvoie la hauteur de l'image
     */
    get height() {
        return this.image.height;
    }

    
    /**
     * Si il y'a des fruits alors la cible du hungrie sera un des fruits choisis au hasard
     * Lorsqu'il n'ya plus de fruits alors greedy devient la cible du hungrie.
     * @param {Fruit[]} fruits liste de fruits
     * @param {Greedy} greedy le greedy
     * @returns 
     */
    cible(fruits,greedy){
        if(fruits.length>0 && this.cibleX && this.cibleY) {
            let fruitCible= null;
            for(let i= 0; i<fruits.length; i++){ // Verifie si parmis tout les fruits le hungrie à déjà une cible
                const fruit= fruits[i] ;
                if (fruit.x === this.cibleX && fruit.y === this.cibleY) { // Verifie si le fruit est une cible présente donc si il n'a pas était mangé
                    fruitCible = fruit;
                    break; 
                }
            }
            if(fruitCible){ // si le hungrie à déjà une cible alors on sort de la fonction
                return; 
            }
        }
        if(fruits.length >0){ // si des fruits sont présent
            const fruit_choisi = fruits[Math.floor(Math.random()*fruits.length)]; // la cible devient un fruit tiré au hasard
            this.cibleX=fruit_choisi.x;
            this.cibleY=fruit_choisi.y;
        }
        else{// sinon si aucun fruit n'est present la cible est greedy
            this.cibleX= greedy.x;
            this.cibleY=greedy.y;
        }
    }

   
    /**
     * déplacement du hungrie vers sa cible
     * @param {HTMLCanvasElement} canvas 
     */
    moveHungrie(canvas) {

        // calcule les différences horizontale et verticale entre la position du hungrie et sa cible
        const diff_horizontale = this.cibleX - this.x;
        const diff_verticale = this.cibleY - this.y;
    
        // calcule la distance entre la position du hungrie et sa cible
        const dist = Math.sqrt(diff_horizontale * diff_horizontale + diff_verticale * diff_verticale);
    
        // calcule les pas de déplacement horizontale et verticale du hungrie et de sa cible
        const pas_de_deplacement_horizontale = diff_horizontale / dist;
        const pas_de_deplacement_verticale = diff_verticale / dist;
    
        let new_position_x = this.x + pas_de_deplacement_horizontale; // calcule la nouvelle position horizontale du hungrie
    
        //verifie si la nouvelle position horizontale ne depasse pas les limites du canvas
        if ((new_position_x < 0) || ((new_position_x + this.width) >= canvas.width)) {
            this.cibleX = this.x;
        }
    
        let new_position_y = this.y + pas_de_deplacement_verticale; // calcule la nouvelle position verticale du hungrie
    
        //verifie si la nouvelle position verticale ne depasse pas les limites du canvas
        if ((new_position_y < 0) || ((new_position_y + this.height) >= canvas.height)) {
            this.cibleY = this.y;
        }
    
        // Met a jour les coordonnées du hungrie
        this.x += pas_de_deplacement_horizontale;
        this.y += pas_de_deplacement_verticale;
    }
    

     /* draw this actor mobile, using the given drawing 2d context */
     draw(context) {
        context.drawImage(this.image,this.x,this.y);
      }

    
      /**
       * Renvoie un boolean qui indique si il y'a eu une collision entre le hungrie et le parametre.
       * @param {Greedy} greedy 
       * @returns True si il y'a eu une collision sinon false
       */
      collisionWith(greedy){

        const A1_x = this.x;
        const A1_y = this.y;
        const A1prime_x = greedy.x;
        const A1prime_y = greedy.y;
    
        const P1_x = Math.max(A1_x,A1prime_x);
        const P1_y = Math.max(A1_y,A1prime_y);
    
        const A2_x = this.x + this.width;
        const A2_y = this.y + this.height;
        const A2prime_x = greedy.x + greedy.width;
        const A2prime_y = greedy.y + greedy.height;
    
        const P2_x = Math.min(A2_x, A2prime_x);
        const P2_y = Math.min(A2_y, A2prime_y);
    
        if (P1_x < P2_x && P1_y < P2_y){ // il y'a collision
            
          return true;
        }
        else {
          return false;
        }
       
    }
}