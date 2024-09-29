 
package zombiegame;

import java.util.*;

import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;
import zombiegame.SpecialRoom.*;
import zombiegame.SpecialStreet.Sewer;
import zombiegame.SpecialZombie.*;


/**
 * La classe Town représente une ville dans le jeu zombie.
 * Elle génère un plateau de jeu avec des pièces, des rues, une pharmacie, un hôtel et des égouts.
 * Les dimensions du plateau sont définies par l'utilisateur.
 */

public class Town {

    // Largeur du plateau
    private int width;
    // Hauteur du plateau
    private int height;
    // Tableau représentant le plateau de jeu de 2 dimensions
    public Area[][] board;
    // Liste de Survivants
    protected ArrayList<Survivor> survivors;
    // Liste de zombies
    protected ArrayList<Zombie> zombies;
    // Initialiser la liste des rôles
    

    /**
     * Constructeur de la classe Town.
     * Initialise une nouvelle ville en demandant à l'utilisateur les dimensions du plateau.
     * Remplit le plateau avec des pieces, des rues, une pharmacie, un hôtel et des égouts.
     */
    public Town() {
        this.survivors = new ArrayList<>();  
        this.zombies = new ArrayList<>();
    }


    /**
     * Obtient la largeur du plateau.
     * @return La largeur du plateau
     */
    public int getWidth(){
        return this.width ;
    }


    /**
     * Obtient la hauteur du plateau.
     * @return La hauteur du plateau
     */
    public int getHeight(){
        return this.height ;
    }


    /**
     * Obtient le tableau représentant les zones du plateau.
     * @return Le tableau représentant les zones du plateau
     */
    public Area[][] getBoard(){
        return this.board ;
    }


    /**
     * Définit les dimensions du plateau en fonction du choix donné.
     * Si choice est égal à 1, les dimensions seront 5x5.
     * Si choice est égal à 2, les dimensions seront 8x8.
     * Si choice est égal à 3, les dimensions seront 11x11.
     * Pour toute autre valeur de choice, les dimensions seront égales à choice x choice.
     * @param choice Le choix spécifié pour définir les dimensions du plateau.
     */
    public void setDimensions(int choice){
        if (choice==1){
            this.width=5;
            this.height=5;
        }
        else if (choice==2){
            this.width=8;
            this.height=8;
        }
        else if (choice==3){
            this.width=11;
            this.height=11; 
        }
        else if (choice%3==2){
                this.width=choice;
                this.height= choice;       
        }
    }


    /**
     * Demande à l'utilisateur de spécifier les dimensions du plateau.
     * Les dimensions peuvent être prédéfinies (facile, moyen, difficile) ou personnalisées.
     */
    public void setDimensionsFromUser() {

        boolean dimensionValid=false;
        Scanner scanner = new Scanner( System.in );

        System.out.println(" \n 💀🧟 Bienvenue dans Zombie Game! 🧟💀\n");
        System.out.print("\nCher joueur, veuillez choisir le niveau que vous souhaitez : \n \n Tapez 1 pour la ville ClassicalTown (Facile,5x5); \n Tapez 2 pour la ville JazzTown (Moyen, 8x8); \n Tapez 3 pour la ville RockTown (Difficile, 11x11).\n \n Sinon, si vous êtes un 💪WARRIOR💪 choisissez la taille de votre ville. Pas de limites, choisissez aussi grand que votre bravoure vous le permet ! 😉 (par exemple : 14, ou peut-être bien 50?..😱 )\n");
        System.out.println(" ");

        int choice;

        while (true){
            try{
                choice = scanner.nextInt();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("☹️ Oups, il faut entrer un entier pour pouvoir indiquer la taille de la ville.");
                scanner.next();
                continue;
            }
        }   
        
        while (dimensionValid==false){
        
            if (choice==1 || choice==2 || choice==3 || choice%3==2){
                this.setDimensions(choice);
                dimensionValid=true;  
            }
            
            else {
                
                System.out.println("\n ☹️ Oups, veuillez réessayez en entrant un entier valide. Un autre essaie ? Qui sait, peut-être que cette fois-ci, la magie opérera !\n");
                while (true){
                    try{
                        choice = scanner.nextInt();
                        break;
                    }
                    catch(InputMismatchException e){
                        System.out.println("☹️ Oups, il faut entrer un entier pour pouvoir indiquer la taille de la ville.");
                        scanner.next();
                    }
                } 
            }
        }   

        System.out.println(" ");
        System.out.println("👇 Voici votre ville, soyez prêt à affronter les zombies aussi nombreux soient-ils ! \n");
    }
    
    
     /**
     * Remplit le tableau du plateau avec des pieces, des rues, et des objets spécifiques (pharmacie, hôtel, égouts).
     */
    public void remplissageTableau() {

        this.board = new Area[width][height];

		for (int x = 0; x < this.width; x+=3) {
			for (int y = 0; y < this.height; y+=3) {
                
				if ((this.width) % 3 == 2) { 
                    board[x][y]=new Room();               
                    board[x+1][y]=new Room();
               
                    board[x][y+1] = new Room();
                    board[x+1][y +1] = new Room();
                }
            }
        }

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.placerPharmacy(this);

        ContinentalHotel hotel = new ContinentalHotel();
        hotel.placerHotel(this);

        for (int x = 0; x < this.width; x++) {
        	for (int y = 0; y < this.height; y++) {
        		if(board[x][y]==null){
        			board[x][y]=new Street();
        		}
            }
    
        }
        
        Sewer sewer = new Sewer();

        if (this.width==5 && this.height==5){
            sewer.placerBoucheEgout_auCentre(this);
        }
        else {
            sewer.placerBouchesEgouts(this);   
        } 
    }

    /**
     * Affiche le plateau de jeu avec les éléments actuels 
     */
    public void afficherTableau() {
        for(int i =0 ;i< width+1 ; i++){
            System.out.print(" -");
        }
        System.out.println();
        for (int i=0; i<board.length; i++) {
            System.out.print("| ");
            for (int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("| ");
        }
            for (int i = 0 ; i<width+1 ; i++){
                System.out.print(" _");
            } 
            System.out.println();
        }
    

    /**
     * Vérifie si le plateau contient un hôtel.
     * @return true si un hôtel est présent sur le plateau, sinon false.
     */
    public boolean hasHotel(){
        int find = 0 ;
        for( int i=0; i<this.width ; i++){
            for (int j =0 ; j<this.height;j++){
                if(this.board[i][j] instanceof zombiegame.SpecialRoom.ContinentalHotel){
                    find++;
                }
            }
        }
        return find==1 ;
    }
 

    /**
     * Vérifie si le plateau contient une pharmacie.
     * @return true si une pharmacie est présente sur le plateau, sinon false.
     */
    public boolean hasPharmacy(){
        int find = 0 ;
        for (int i = 0; i<this.width ; i++){
            for (int j = 0 ; j<this.height; j++){
                if(this.board[i][j] instanceof zombiegame.SpecialRoom.Pharmacy){
                        find++ ;
                }
            }
        }
        return find==1 ;
    }


    /**
     * Vérifie si le plateau contient un égout.
     * @return true si un égout est présent sur le plateau, sinon false.
     */
    public boolean hasSewer(){
        boolean find = false ;
        for (int i = 0; i<this.width ; i++){
            for (int j = 0 ; j<this.height; j++){
                if(this.board[i][j] instanceof zombiegame.SpecialStreet.Sewer){
                    find = true ;
                }
            }
        }
        return find ;
    }


    /**
     * Place les survivant au carrefour principal du plateau, si il y'a pas de carrefour principale alors les survivants sont placé autour du batiment centrale (sur une même zone).
     */
    public void placeSurvivors(){


        Scanner scanner = new Scanner( System.in );

        System.out.println("\n Les grognements des zombies affamés se font entendre ! 🧟 \n    Combien de braves survivants répondront à l'appel pour les exterminer ? 🥷 \n");
        int reponse_nombreSurvivants;

        while (true){
            try{
                reponse_nombreSurvivants = scanner.nextInt();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("☹️ Oups, il faut entrer un entier pour indiquez le nombre de survivants");
                scanner.next();
                continue;
            }
        }  
       

        System.out.println(" \nWOW, quel équipe redoutable vous formez ! 💪 \n \n   Voici votre champ de bataille : 👇\n ");

        int middle_x= this.width/2;
        int middle_y= this.height/2;

        for (int i=1;i<reponse_nombreSurvivants+1; i++){
            String nomsurvivant = "survivant_" +i;
            if (this.board[middle_x][middle_y] instanceof Room){
                Survivor survivor = new Survivor(nomsurvivant,middle_x+1, middle_y,this);
                this.board[middle_x +1][middle_y].ajouterSurvivor(survivor);
                this.survivors.add(survivor);  
            }
            else{
                Survivor survivor =new Survivor(nomsurvivant,middle_x,middle_y,this);
                this.board[middle_x][middle_y].ajouterSurvivor(survivor);
                this.survivors.add(survivor); 
            }
        
    }  
    afficherTableau();     
    System.out.println("\n Bien, que le combat commence ! 💥 \n\n Alors, êtes-vous prêt à relever le défi ? 👀 \n    Dites 'Oui' pour plonger tête la première dans les ténèbres, sinon, laissez-vous engloutir par la terreur et murmurez 'Non' pour échapper à ce cauchemar. \n");
    while(true){
        String reponse_joueur;
        reponse_joueur = scanner.next();

    
        if (reponse_joueur.toLowerCase().equals("oui")){
            System.out.println("\n Les zombies sont là ! \n");
            break;

        }
        else if (reponse_joueur.toLowerCase().equals("non")){
            System.out.println("Vous avez décidé de quittez le jeu. Au revoir.");
            System.exit(0);
        }
        else{
            System.out.println("☹️ Oups, la ville à besoin de savoir si vous êtes la pour elle. Repondez oui ou non.");
        }
    }
   
}

	/**
	 * Supprime un survivor qui était dans la ville.
	 */
	/**
	 * Supprime un survivant de la ville.
	 * @param survivor Le survivant à supprimer.
	 */
	public void removeSurvivor(Survivor survivor) {
	    this.survivors.remove(survivor);
	    
	}
	
	public void removeZombie(Zombie zombie){
	    this.zombies.remove(zombie);
	}
	
	/**
	 * Place les zombies sur chaque bouches d'égouts.
	 */
	public void placeZombies(){
	    // Parcourir les bords horizontaux du plateau
	    int i =0;
	
	    for(int x = 0; x < this.getWidth() ; x++) {
	        
	        if (x == 0 || x == this.getWidth() - 1) {
	            // Si c'est le bord gauche ou droit
	            for (int y = 0 ; y < this.getHeight() ; y++) {
	                
	                
	                // Si la case est une rue, la remplacer par une bouche d'égout
	                if (this.getBoard()[x][y] instanceof zombiegame.Street) {
	                    i++;
	                    String nomZombie = "🧟 zombie" +i;
	                    Zombie zombie = new Zombie(nomZombie,x,y);
	                    this.getBoard()[x][y].ajouterZombie(zombie);
	
	                    this.zombies.add(zombie);
	                }
	            }
	        }
	    }
	    /*Parcourir les bords verticaux du plateau */
	    for(int y = 0; y < this.getHeight() ; y++) {
	        if (y == 0 || y == this.getHeight() - 1) {
	            for (int x = 0 ; x < this.getWidth() ; x++) {
	                
	                if (this.getBoard()[x][y] instanceof zombiegame.Street) {
	                    i++;
	                    String nomZombie = "🧟 zombie" +i;
	                    Zombie zombie = new Zombie(nomZombie,x,y);
	                    this.getBoard()[x][y].ajouterZombie(zombie); 
	                    this.zombies.add(zombie);
	                }
	            }
	        }
	    }
	
	}
	
	/**
	 * Renvoie la liste des survivors présent dans la ville
	 * @return la liste des survivors présent dans la ville
	 */
	public ArrayList<Survivor> getSurvivors(){
	    return this.survivors;
	}
	
	
	/**
	 * Renvoie la lise des zombies présent dans la ville
	 * @return Renvoie la lise des zombies présent dans la ville
	 */
	public ArrayList<Zombie> getZombies(){
	    return this.zombies;
	}
	
	
	/**
	 * Indique si le position du deplacement est valide donc:
	 * - si elle ne dépasse pas les limites du plateau 
	 * - fait des pas de 1 avec l'interdiction de passé en diagonale.
	 * 
	 * @param survivor le survivant qui se deplacera sur les coordonées
	 * @param coord_x la coordonée x du déplacement
	 * @param coord_y la coordonée y du déplacement
	 * @return True si la position du deplacement est valide sinon false.
	 */
	public boolean validePosition(Actor survivor,int coord_x, int coord_y){
	    return (coord_x>=0 && coord_x<this.width && coord_y>=0 && coord_y<this.height)&& ((survivor.positionX == coord_x && survivor.positionY+1 == coord_y) || (survivor.positionX+1 == coord_x && survivor.positionY == coord_y) || (survivor.positionX == coord_x && survivor.positionY-1 == coord_y) || (survivor.positionX - 1 == coord_x && survivor.positionY == coord_y));
	}
	
	/**
	 * Pour chaque survivant, son action est tiré au hasard
	 */
	public void phaseSurvivants(){
	    for (Survivor survivor : this.survivors){
	        Random hasard = new Random();
	        int direction_hasard = hasard.nextInt(4);
	             
	        int coord_x = survivor.getPositionX();
	        int coord_y = survivor.getPositionY();
	       
	            // Action du déplacement du survivor 
	            if (direction_hasard==0){
	                coord_x = survivor.positionX+1;
	                coord_y = survivor.positionY;
	
	            }
	            else if (direction_hasard==1){
	                coord_x = survivor.positionX-1;
	                coord_y = survivor.positionY ;
	
	            }
	            else if (direction_hasard==2){
	                coord_x = survivor.positionX;
	                coord_y = survivor.positionY+1;
	
	            }
	            else if (direction_hasard==3){
	                coord_x = survivor.positionX;
	                coord_y = survivor.positionY-1;
	
	            }
	            if (this.validePosition(survivor,coord_x,coord_y)){
	
	            survivor.move_survivor(this, coord_x, coord_y);
	            }
	
	             // Action attaquer Zombie
	            if (!zombies.isEmpty()){
	                int randomIndex = hasard.nextInt(zombies.size());
	                Zombie zombieCible = zombies.get(randomIndex);
	                survivor.attaquerZombie(this,zombieCible);
	            }
		        else {
		           System.out.println("Aucun zombie n'est disponible pour l'attaque.");
		        }
	            
	            // Action fouiller pièce
	                int positionX = survivor.getPositionX();
	                int positionY = survivor.getPositionY();
	                
	                Area currentArea = board[positionX][positionY];
	                survivor.fouillerPiece(currentArea);
	           
	                // Action prendre en main
	                List<Equipment> backpack = survivor.getBackpack();
	                if (!backpack.isEmpty()) {
	                    int randomEquipIndex = hasard.nextInt(backpack.size());
	                    Equipment equipement = backpack.get(randomEquipIndex);
	                    // Appeler la méthode prendreEnMain avec l'équipement sélectionné
	                    survivor.prendreEnMain(equipement);
	                } else {
	                    System.out.println("Le " + survivor.getName() + " ne possède aucun équipement dans son sac pour prendre en main.");
	                }
	            
	                // Action regarder autour de soi
	                survivor.lookAround(currentArea);
	                
	                // Action faire du bruit
	                survivor.faireDuBruit(currentArea);
	                
	                int randomIndex = hasard.nextInt(zombies.size());
	                Zombie zombieCible = zombies.get(randomIndex);
	                survivor.applyRole(this,zombieCible);
	
	                Room room = null;
	                // recupere les coordonnée d'une room qui se toruve a coté de lui afin de l'ouvrir
	                if (this.validePosition(survivor, survivor.getPositionX()+1, survivor.getPositionY()) && this.getBoard()[survivor.getPositionX()+1][survivor.getPositionY()] instanceof Room){
	                    room = (Room) this.getBoard()[survivor.getPositionX()+1][survivor.getPositionY()];
	                }
	                else if (this.validePosition(survivor, survivor.getPositionX()-1, survivor.getPositionY()) && this.getBoard()[survivor.getPositionX()-1][survivor.getPositionY()] instanceof Room){
	                    room = (Room) this.getBoard()[survivor.getPositionX()-1][survivor.getPositionY()];
	                }
	                else if (this.validePosition(survivor, survivor.getPositionX(), survivor.getPositionY()+1) &&this.getBoard()[survivor.getPositionX()][survivor.getPositionY()+1] instanceof Room){
	                    room = (Room) this.getBoard()[survivor.getPositionX()][survivor.getPositionY()+1];
	                }
	                else if (this.validePosition(survivor, survivor.getPositionX(), survivor.getPositionY()-1) &&this.getBoard()[survivor.getPositionX()][survivor.getPositionY()-1] instanceof Room){
	                    room = (Room) this.getBoard()[survivor.getPositionX()][survivor.getPositionY()-1];
	                }
	                if (room!=null){ // si une room est disponible à proximité
	                    survivor.ouvrir_une_porte(this, room); // alors on ouvre sa porte
	                }
	                else{ // sinon, le survivant ne peux ouvrir aucune porte
	                    System.out.println("Le " + survivor.getName() + " ne peut pas ouvrir de porte : aucune porte n'est à proximité");
	                }
	                
	    
	            /*Fait des erreurs dans play donc je met en commentaire(nada)  
	            // S'il y a des équipements dans le sac à dos
	            if (!backpack.isEmpty()) {
	                // Générer un index aléatoire pour choisir un équipement dans le sac à dos
	                Random random = new Random();
	                int randomEquipIndex = random.nextInt(backpack.size());
	                // Récupérer l'équipement à cet index
	                Equipment equipment = backpack.get(randomEquipIndex);
	
	                // Utilisation de l'équipement par le survivant
	                System.out.println(survivor.getName() + " utilise l'équipement : " + equipment.getName());
	                equipment.use(this,survivor);
	
	                equipment.applyEffect();
	                Equipment test = new InfraredGlasses();
	                test.use(this,survivor); // fonctionne 
	                Equipment test2 = new Map();
	                test2.use(this,survivor); // fonctionne
	
	                // Suppression de l'équipement utilisé du sac à dos du survivant
	                survivor.enleverEquipement(equipment);
	            }
	            */
	     /*
	            else if (action_hasard==5){
	                survivor.utiliserUnEquimeent(equipement);
	                System.out.println("Le "+survivor.getName()+" à utiliser l'équipement : "+ equipement.getName());
	
	            }            
	                 
	            
	            */
	            afficherTableau(); // Affiche le tableau qui est mis à jour
	    }
	}
	
	/**
	 * Méthode pour exécuter la phase des zombies.
	 */
	public void phaseZombies() {
	    for (Zombie zombie : zombies) {
	        int zombieX = zombie.getPositionX();
	        int zombieY = zombie.getPositionY();
			Random hasard = new Random();
	        int direction_hasard = hasard.nextInt(4);
	             
	        int coord_x = zombie.getPositionX();
	        int coord_y = zombie.getPositionY();
	       
	            // Action du déplacement du survivor 
	            if (direction_hasard==0){
	                coord_x = zombie.positionX+1;
	                coord_y = zombie.positionY;
	
	            }
	            else if (direction_hasard==1){
	                coord_x = zombie.positionX-1;
	                coord_y = zombie.positionY ;
	
	            }
	            else if (direction_hasard==2){
	                coord_x = zombie.positionX;
	                coord_y = zombie.positionY+1;
	
	            }
	            else if (direction_hasard==3){
	                coord_x = zombie.positionX;
	                coord_y = zombie.positionY-1;
	
	            }
	            if (this.validePosition(zombie,coord_x,coord_y)){
	
	            zombie.move_zombie(this, coord_x, coord_y);
	            }
	
	
	        // Vérifier s'il y a des survivants dans la même zone que le zombie
	        boolean survivorPresent = false;
	        for (Survivor survivor : survivors) {
	            if (survivor.getPositionX() == zombieX && survivor.getPositionY() == zombieY) {
	                survivorPresent = true;
	                
	                System.out.println("Le " + zombie.getName() + " est dans la meme zone que " + survivor.getName());
	                System.out.println("    ⚠️Le " + zombie.getName() + " va donc préparer son attaque attention.... : ");
	                break;
	            }
	        }
	        // Si un survivant est présent, le zombie attaque, sinon il se déplace
	        if (survivorPresent) {
	            // Attaquer un survivant présent dans la même zone
	            for (Survivor survivor : survivors) {
	                if (survivor.getPositionX() == zombieX && survivor.getPositionY() == zombieY) {
	                    zombie.attaquerSurvivant(this,survivor);
	                    System.out.println("😨Le " + zombie.getName() + " à attaquer le " + survivor.getName());
	                    break; // Attaquer seulement un survivant à la fois
	                }
	            }
	        } else {
	            
	            System.out.println("Le " + zombie.getName() + " ne peut pas attaquer, il se trouve pas dans la même zone qu'un survivant");
	            System.out.println("  🔊 Le zombie se déplace donc vers la zone la plus bruyante afin de trouver un survivant!");

	            
	        }
			System.out.println();
	    }

	}
	
	/**
	 * Effectue les actions nécessaires à la fin d'un tour de jeu.
	 * Cela comprend le nettoyage du plateau des zombies et des survivants tués,
	 * la remise à zéro du niveau de bruit sur toutes les zones,
	 * et l'apparition de nouveaux zombies proportionnellement à l'expérience globale des survivants
	 * sur les zones des rues disposant de bouches d'égouts, à condition qu'il reste encore des zombies vivants.
	 */
	public void phaseFinDeTour() {
	    // Nettoyer le plateau des zombies et survivants tués
	    this.cleanDeadActors();
	    // Remettre le bruit à zéro sur toutes les zones
	    this.resetNoise();
	    //Fait apparaître de nouveaux zombies proportionnellement à l'expérience globale des survivants sur les zones des rues disposant de bouches d'égouts, à condition qu'il reste encore des zombies vivants.
	    spawnNewZombies();
	    
	}
	
	/* Nettoie le plateau des zombies et survivants tués.
	 */
	public void cleanDeadActors() {
	    // Supprimer les zombies morts de la liste des zombies
	    for (Zombie zombie : this.getZombies()){
	        if (zombie.isDead()) {
	            System.out.println("Le " + zombie.getName() + " est mort. Il est évacué de la ville");
	            // Retirer le zombie mort de la zone où il se trouve
	            this.board[zombie.getPositionX()][zombie.getPositionY()].supprimerZombie(zombie);
	            // Retirer le zombie de la liste des zombies
	            this.getZombies().remove(zombie);
	        }
	    }
	    
	    // Supprimer les survivants morts de la liste des survivants
	    for (Survivor survivor : this.getSurvivors()){
	        if (survivor.isDead()) {
	            System.out.println("Le " + survivor.getName() + " est mort. Il est évacué de la ville");
	            // Retirer le survivant mort de la zone où il se trouve
	            this.board[survivor.getPositionX()][survivor.getPositionY()].supprimerSurvivor(survivor);
	            // Retirer le survivant de la liste des survivants
	            this.getSurvivors().remove(survivor);
	        }
	    }
	    
	    System.out.println("- Le plateau est nettoyé et les zombies et les survivants morts sont éliminés");
	
	}
	
	
	/**
	 * Remet le bruit à zéro sur toutes les zones.
	 */
	public void resetNoise() {
	    for (int x = 0; x < width; x++) {
	        for (int y = 0; y < height; y++) {
	            board[x][y].resetNoise();
	        }
	    }
	    System.out.println("- Le bruit est remis à zéro sur toute les zones");
	
	}
	
	/**
	 * Fait apparaître de nouveaux zombies proportionnellement à l'expérience globale des survivants
	 * sur les zones des rues disposant de bouches d'égouts, à condition qu'il reste encore des zombies vivants.
	 */
	public void spawnNewZombies() {
	    // Vérifier s'il reste des zombies vivants
	    if (!zombies.isEmpty()) {
	        int i =0;
        int size=this.getZombies().size();
        Random hasard = new Random();
        int nouveauZombie = hasard.nextInt(2)+1;
        
        
        // Parcourir les bords horizontaux du plateau
        for(int x = 0; x < this.getWidth()  &&  i < nouveauZombie; x++) {
            
            if (x == 0 || x == this.getWidth() - 1) {
                // Si c'est le bord gauche ou droit
                for (int y = 0 ; y < this.getHeight() && i < nouveauZombie; y++) {
                    
                    if (this.getBoard()[x][y] instanceof zombiegame.Street) {
                        i++;
                        size++;
                        String nomZombie = "👿nouveauZombie" ;
                        Zombie zombie = new Zombie(nomZombie,x,y);
                        this.getBoard()[x][y].ajouterZombie(zombie);
                        this.zombies.add(zombie);
						return;

                    }
                }
				
            }
        }
	    }
	    System.out.println("- De nouveaux zombies apparaissent proportionnellement à l’expérience globale des survivants sur les zones des rues disposant de bouches d’égouts");
	}
	
	/**
	 * Lance la Partie
	 * Tant que la partie n'est pas finis on aura : une phase pour les survivors, une phase pour les zombies et une phase de fin de tour
	*/
	public void play() {
	
	    while (!endGame()) {
	        System.out.println();
	        System.out.println();
	        
	        
	        System.out.println(" 🙎‍♂️PHASE SURVIVANTS : 🙎‍♂️");
	        System.out.println();
	        phaseSurvivants();
	       
	        System.out.println();
	        System.out.println();
	
	        System.out.println(" 🧟 PHASE ZOMBIES : 🧟 ");
	        System.out.println();
	        phaseZombies();
	        
	        System.out.println();
	        System.out.println();
	
	        System.out.println(" 🧹 PHASE DE FIN DE TOUR : 🧹");
	        System.out.println();
	        phaseFinDeTour();
	       
	
	
	        // Vérifier la condition de fin de jeu
	        if (endGame()) {
	            break; // Sortir de la boucle si la partie est terminée
	        }
	    }
	    System.out.println();
	
	    // Afficher le résultat du jeu
	    System.out.println();
	    if (calculerExperienceTotaleSurvivants() >= 30 ) {
			System.out.println("La partie est déjà terminée ! : ");
			System.out.println("  Le niveau d’expérience global (somme des expériences des survivants) à atteint le score de 30.");
			System.out.println();
	        System.out.println("🎉🎉🎉Félicitations les survivants ont gagné !!🎉🎉🎉");
	    }
		else if (zombiesAreDead()){
			System.out.println("La partie est déjà terminée ! : ");
			System.out.println("Tous les zombies sont morts.");
			System.out.println();
			System.out.println("🎉🎉🎉Félicitations les survivants ont gagné !!🎉🎉🎉");

		}
		else {
	        System.out.println("Perdu ! Les zombies ont gagné.");
	    }
	    System.out.println();
	
	}
	
	/**
	 * Calcule et retourne l'expérience totale des survivants présents dans la zone.
	 * L'expérience totale est la somme des niveaux d'expertise de tous les survivants.
	 * @return L'expérience totale des survivants présents dans la zone.
	 */
	public int calculerExperienceTotaleSurvivants() {
	    int experienceTotale = 0;
	    for (Survivor survivant : this.survivors) {
	        experienceTotale += survivant.getExpertiseLevel();
	    }
	    return experienceTotale;
	}
	
	/**
	 * Vérifie si tous les zombies présents dans la zone sont morts.
	 * @return true si tous les zombies sont morts, sinon false.
	 */
	public boolean zombiesAreDead() {
		boolean tousMorts = true;
	    for (Zombie zomb : this.zombies) {
	        if (!zomb.isDead()) {
	            tousMorts = false;
	            break;
	        }
	    }
	    return tousMorts;
	}
	
	
	/**
	 * Indique si la partie est finis ou non.
	 * @return True si la partie est finis, sinon false.
	 */
	public boolean endGame() {
	    
	    // Vérifier si l'expérience totale des survivants est supérieure ou égale à 30
	    int experienceTotale = calculerExperienceTotaleSurvivants();
	    boolean atteintObjectifExperience = experienceTotale >= 30;
	    
	    // La partie se termine si tous les zombies ont été vaincus ou si l'expérience totale des survivants est supérieure ou égale à 30
	    return zombiesAreDead() || atteintObjectifExperience;
	}
	
	
    /**
     * Indique quel équipe a gagné la partie, les survivants ou les zombies.
     * @return Un String en fonction du gagnant.
     */
    public String EquipeGagnante(){
        return "Perdu ! Les zombies vous ont exterminés.";
    }  
    
    
    /**
    * Vérifie si les coordonnées spécifiées pour un déplacement sont valides.
    * @param x La coordonnée x du déplacement.
    * @param y La coordonnée y du déplacement.
    * @return true si le déplacement est valide, sinon false.
    */
    public boolean isMoveValid(int x, int y) {
        // Vérifie si les coordonnées se trouvent à l'intérieur du plateau
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return false;
        }
        // Vérifie si la zone est accessible (pas une porte)
        return board[x][y].isAccessible(x, y);
    }
    

    /**
     * Le fait d’ouvrir une porte fait apparaître systématiquement entre 1 et 3 zombies, et au plus une Abomination ou un
     * Balaise
     */
    public void consequence_ouvrage_porte(){
        int i =0;
        int size=this.getZombies().size();
        Random hasard = new Random();
        int zombieApparition = hasard.nextInt(3)+1;
        int abomination_ou_balaise=hasard.nextInt(5);
        
        // Parcourir les bords horizontaux du plateau
        for(int x = 0; x < this.getWidth()  &&  i < zombieApparition; x++) {
            
            if (x == 0 || x == this.getWidth() - 1) {
                // Si c'est le bord gauche ou droit
                for (int y = 0 ; y < this.getHeight() && i < zombieApparition; y++) {
                    
                    if (this.getBoard()[x][y] instanceof zombiegame.Street) {
                        i++;
                        size++;
                        String nomZombie = "👹zombie_apparu_consequence" +size;
                        Zombie zombie = new Zombie(nomZombie,x,y);
                        this.getBoard()[x][y].ajouterZombie(zombie);
                        this.zombies.add(zombie);
                        this.zombies.add(zombie);
                        i++;
                        this.zombies.add(zombie);    
                        i++;

                    }
                }
            }
        }
        System.out.println("🧟Attention : l'ouverture de porte à ajouté " + zombieApparition +" zombies à la bataille!");
        
        if (abomination_ou_balaise==0){
            size++;
            String nomZombie = "👹 zombieAbomination" + size ;

            Abomination zombieAbomination = new Abomination(nomZombie,0,2);
            this.getBoard()[0][2].ajouterZombie(zombieAbomination);
            this.zombies.add(zombieAbomination);   
            System.out.println("👹 Attention : l'ouverture de porte à ajouté un zombie spécial Abomination à la bataille!");
           
        }
        if (abomination_ou_balaise==1){
            size++;
            String nomZombie = "👹 zombieBalaise"+size;
            
            Abomination zombieBalaise = new Abomination(nomZombie,0,2);
            this.getBoard()[0][2].ajouterZombie(zombieBalaise);
            this.zombies.add(zombieBalaise);  
            System.out.println("👹 Attention : l'ouverture de porte à ajouté un zombie spécial Balaise à la bataille!");
            
        }
}
}
