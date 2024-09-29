package zombiegame.Actors;

import java.util.*;
import zombiegame.*;


import zombiegame.Equipments.Weapons.*;
import zombiegame.Equipments.*;



/**
 * La classe Survivor représente un survivant dans le jeu.
 * Chaque survivant possède des points d'action, un niveau d'expertise, des points de vie,
 * un sac à dos contenant des équipements, un équipement en main, des rôles spécifiques,
 * et une indication sur s'il est éliminé ou non.
 */
public class Survivor extends Actor {
	
	 private int actionPoints; // Points d'action du survivant
	 private int expertiseLevel; // Niveau d'expertise du survivant
	 private int healthPoints; // Nombre de points de vies
	 private List<Equipment> backpack; // Sac à dos du survivant
	 private Equipment equipEnMain; // Équipement en main du survivant
	 private List<String> roles; // Les différents roles du survivant
	 private Town town; // une ville
	 
	 /**
	  * Constructeur de la classe Survivor.
	  * @param name        Le nom du survivor.
	  * @param positionX   La position en abscisse du survivor.
	  * @param positionY   La position en ordonnée du survivor.
	  */
	 public Survivor(String name, int positionX, int positionY, Town town ) {	
		    super(name, positionX, positionY);
			this.town =town ;
	        this.actionPoints = 3; // Initialisation des points d'action à 3
	        this.expertiseLevel = 1; // Initialisation du niveau d'expertise à 1
	        this.backpack = new ArrayList<>(); // Initialisation du sac à dos comme une liste vide
	        this.roles = new ArrayList<>(); // Initialisation des rôles du survivor comme une liste vide
	        this.healthPoints = 5; // Initialisation du nombre de points de vie
			this.equipEnMain = new Gun();
	        assignerRoles();

	    }
	
	 
	/**
	  * Renvoie une représentation textuelle du survivant adaptée à l'affichage sur le plateau de jeu.
	  *
	  * @return Une chaîne de caractères représentant le nom du survivant.
	  */
	 public String toString() {
		return "\u001B[33m𖡌\u001B[0m";
	}
	 
	 
	 /**
	 * Attribue aléatoirement des rôles à chaque survivant.
	 */
    public void assignerRoles() {
        Random random = new Random();
        int nombreRoles = random.nextInt(4) + 1; // Choix aléatoire du nombre de rôles entre 1 et 4

        for (int i = 0; i < nombreRoles; i++) {
            int roleIndex = random.nextInt(4); // Choix aléatoire d'un index de rôle
            String role = ""; // Initialisation du rôle

            switch (roleIndex) {
                case 0:
                    role = "Fighter";
                    break;
                case 1:
                    role = "Healer";
                    break;
                case 2:
                    role = "Lucky";
                    break;
                case 3:
                    role = "Snoop";
                    break;
            }

            ajouterRole(role); // Ajout du rôle attribué au survivant
        }
    }
	  
    /**
     * Applique les effets des rôles du survivant dans la ville, en fonction de la situation.
     *
     * @param town   La ville où se trouve le survivant.
     * @param zombie Le zombie à attaquer.
     */
    public void applyRole(Town town,Zombie zombie) {
        if (this.roles != null) {
	        for (String role : this.roles) {
	        	
	        	
	        	if (role == "Fighter") {
	        		 this.attaquerZombie(town , zombie); 
	        	     this.addActionPoints();
                     System.out.println("🎲 Le Combattant " + this.getName() + " a bénéficié d'un lancé de dés en plus pour attaquer un zombie ");

	        	}
	        	
	        	
	        	if (role == "Healer") {
	        		int positionX = this.getPositionX();
	                int positionY = this.getPositionY();
	               
	             // Parcourir tous les survivants de la ville
	                for (Survivor otherSurvivor : town.getSurvivors()) {
	                    // Vérifier si le survivant actuel est dans la même zone que le survivant donné en paramètre
	                    if (otherSurvivor.getPositionX() == positionX && otherSurvivor.getPositionY() == positionY) {
	                            otherSurvivor.addHealthPoints(1);
	                            System.out.println("⛑️ Le soigneur " + this.getName() + " a soigné " + otherSurvivor.getName() + ".");
	                    }
	                }
	                this.addHealthPoints(1);
	            }
	        	
	        	if (role == "Lucky") {
	        		 this.attaquerZombie(town,zombie); 
	        	     this.addActionPoints();
                     System.out.println("🍀 Le chanceux " + this.getName() + " a  pu avoir un dé supplémentaire afin d'attaquer un zombie");

	        	}
	        	
	        	if (role == "Snoop") {
	        		int positionX = this.getPositionX();
	                int positionY = this.getPositionY();
	                
	                Area currentArea = town.board[positionX][positionY];
	                this.fouillerPiece(currentArea);
	                this.addHealthPoints(1); // Car l'action est gratuite grace à ce role
                    System.out.println("Le fouineur " + this.getName() + " a  pu réaliser une action de fouille gratuite");

	        	}
	       }
        }
    }
    
    
	 /**
	  * Renvoie une représentation textuelle détaillée du survivant, incluant son nom, ses points de vie,
	  * son niveau d'expertise, son équipement en main et le contenu de son sac à dos.
	  *
	  * @return Une chaîne de caractères représentant les détails du survivant.
	  */
	 public String Description() {
	        System.out.println("Survivant: " + name);
	        System.out.println("Points de vie restants: " + healthPoints);
	        System.out.println("Niveau d'expertise: " + expertiseLevel);
	        System.out.println("Équipement en main: " + (equipEnMain != null ? equipEnMain : "Aucun"));
	        System.out.print("Cartable: ");
	        if (backpack.isEmpty()) {
	            System.out.println("Vide");
	        } else {
	            for (Equipment equipment : backpack) {
	                System.out.print(equipment + ", ");
	            }
	            System.out.println();
	        }
	        return "";
	    }
	 
	 
	 /**
	  * Vérifie si le survivant est mort en fonction de ses points de vie.
	  *
	  * @return true si le survivant est mort (points de vie <= 0), sinon false.
	  */
	public boolean isDead() {
		return this.healthPoints <= 0;
	}

	
	 /**
	  * Obtient le nom du survivant.
	  *
	  * @return Le nom du survivant.
	  */
	 public String getName() {
		 return this.name;
	 }
	 
	
	 /**
	  * Obtient les points de vie actuels du survivant.
	  *
	  * @return Les points de vie actuels du survivant.
	  */
	 public int getHealthPoints() {
		 return this.healthPoints;
	 }
	 
	 
	 /**
	  * Obtient le contenu du sac à dos du survivant.
	  *
	  * @return La liste des équipements présents dans le sac à dos du survivant.
	  */
	 public List <Equipment> getBackpack(){
		 return this.backpack;
	 }
	 
	 
	 /**
	 * Obtient le niveau d'expertise du survivant.
	 * @return Le niveau d'expertise du survivant
	 */
     public int getExpertiseLevel() {
	        return this.expertiseLevel;
	 }

	  /**
	  * Obtient les points d'action du survivant.
	  * @return Les points d'action du survivant
	  */
	  public int getActionPoints() {
		  return this.actionPoints;
	  }
	  
	 /**
	  * Ajouter un point d'action
	  */
	  public void addActionPoints() {
		  this.actionPoints ++ ;
		  
	  }
	  
	   /**
	   * Obtient les rôles du survivant.
	   * @return Les rôles du survivant
	   */
	   public List<String> getRoles() {
		   return this.roles;
	    }

	 
	   /**
	   * Ajoute un équipement au sac à dos du survivant.
	   * @param equipement L'équipement à ajouter
	   */
	   public void ajouterEquipement(Equipment equipement) {
		   backpack.add(equipement);
	    }
	   
	   
	   /**
	     * Enlève un équipement du sac à dos du survivant.
	     * @param equipement L'équipement à enlever
	     */
	    public void enleverEquipement(Equipment equipement) {
	        backpack.remove(equipement);
	    }
	    
	  
		
	    /**
	     * Augmente le niveau d'expertise du survivant.
	     */
	    public void augmenterNiveauExpertise() {
	    	expertiseLevel++;
	    }

	    /**
	     * Ajoute un rôle au survivant.
	     * 
	     * @param role Le rôle à ajouter au survivant.
	     */
	    public void ajouterRole(String role) {
	        roles.add(role);
	    }
	    
	   
	    
	    /**
	     * Effectue une attaque contre un zombie avec l'équipement en main du survivant.
	     * Si le survivant réussit son attaque, le zombie perd des points de vie équivalents aux dégâts de l'équipement en main.
	     * Si le zombie meurt suite à l'attaque, le niveau d'expertise du survivant est augmenté et le zombie est retiré de la ville.
	     * Le nombre de points d'action du survivant est décrémenté après l'attaque.
	     * 
	     * @param town La ville où se déroule l'action.
	     * @param zombie Le zombie ciblé par l'attaque.
	     */
	    public void attaquerZombie(Town town, Zombie zombie) {
    		this.expertiseLevel++;

	    	// Vérifie si le survivant a des points d'action suffisants pour attaquer
	        if (this.actionPoints <= 0) {
	            System.out.println("Le " + this.getName() +" n'a pas suffisamment de points d'action pour attaquer.");
	            return;
	        }
	        // Le cas où l'équipement en main est un Pied de Biche 
	        if (this.equipEnMain instanceof Crowbar) {
	        	if (this.positionX == zombie.getPositionX() && this.positionY == zombie.getPositionY()) {
		            int resultDe = lancerDe(); 
		            if (resultDe >= equipEnMain.getSeuil()) {
		            	System.out.println("L'attaque est réussie");
		            	zombie.reduirePointsVies(equipEnMain.getDegat());
		            	if (zombie.isDead()) {
		            		this.expertiseLevel++;
		            		town.removeZombie(zombie);
			            	System.out.println("Le "+ zombie.getName() + " a été tué par le " + this.name);

		            	}
		            } else {
		            	System.out.println("Le " + this.getName() +" n'a pas réussi à attaquer le " + zombie.getName() + " à cause du résultat du dé");
			        }
	        	} else {
	            	System.out.println("Le " + this.getName() + " ne peut pas attaquer le "+ zombie.getName() +  " car il faut qu'il soit dans la meme piece que lui");
		            }
		            
	        }
	        // Le cas où l'équipement en main est une Hache
	        else if (this.equipEnMain instanceof Axe) {
	        	if (this.positionX == zombie.getPositionX() && this.positionY == zombie.getPositionY()) {
		            int resultDe = lancerDe();
		            if (resultDe >= equipEnMain.getSeuil()) {
		            	System.out.println("L'attaque est réussie");
		            	zombie.reduirePointsVies(equipEnMain.getDegat());
		            	if (zombie.isDead()) {
		            		this.expertiseLevel++;
		            		town.removeZombie(zombie);
			            	System.out.println("Le "+ zombie.getName() + " a été tué par le " + this.name);
		            	}
		            } else {
		            	System.out.println("Le " + this.getName() +" n'a pas réussi à attaquer le " + zombie.getName() + " à cause du résultat du dé");
			        }
	        	} else {
	            	System.out.println("Le " + this.getName() + " ne peut pas attaquer le "+ zombie.getName() +  " car il faut qu'il soit dans la meme piece que lui");
		            }
		            
	        }
	        // Le cas où l'équipement en main est un Pistolet 
	        else if (this.equipEnMain instanceof Gun) {
	        	if((this.positionX - zombie.getPositionX()) <= 1  && (this.positionY - zombie.getPositionY() <= 1) ) {
		            int resultDe = lancerDe();
		            if (resultDe >= equipEnMain.getSeuil()) {
		            	System.out.println("Le " + this.getName() + " a attaqué le "+ zombie.getName() + " avec succès !");
		            	zombie.reduirePointsVies(equipEnMain.getDegat());
		            	if (zombie.isDead()) {
		            		this.expertiseLevel++;
		            		town.removeZombie(zombie);
			            	System.out.println("Le "+ zombie.getName() + " a été tué par le " + this.name);
		            	}
		            } else {
		            	System.out.println("Le " + this.getName() +" n'a pas réussi à attaquer le " + zombie.getName() + " à cause du résultat du dé");
			        }
	        	} else {
		            	System.out.println("Le " + this.getName() + " ne peut pas attaquer le "+ zombie.getName() +  " car il faut qu'il soit dans la meme piece que lui");
		            }
		            
	        }
	        // Le cas où l'équipement en main est une Tronçonneuse 
	        else if(this.equipEnMain instanceof ChainSaw ) {
	        	if (this.positionX == zombie.getPositionX() && this.positionY == zombie.getPositionY()) {
		        	int successes = 0;
		        	// Le survivant a le droit à deux lancers de dés
		            for (int i = 0; i < 2; i++) {
		                int resultDe = lancerDe();
		                if (resultDe >= equipEnMain.getSeuil()) {
		                    successes++;
		                }
		            }
		            if (successes > 0) {
		                System.out.println("Le " + this.getName()+ " a attaqué le "+ zombie.getName() + " avec succès !");
		                zombie.reduirePointsVies(equipEnMain.getDegat() * successes);
		                if (zombie.isDead()) {
		                    this.expertiseLevel++;
		            		town.removeZombie(zombie);
			            	System.out.println("Le "+ zombie.getName() + " a été tué par le " + this.name);
		                }
		            } else {
		            	System.out.println("Le " + this.getName() +" n'a pas réussi à attaquer le " + zombie.getName());
		            }
	        	}
	        	else {
	            	System.out.println("Le " + this.getName() + " ne peut pas attaquer le "+ zombie.getName() +  " car il faut qu'il soit dans la meme piece que lui");
	        	}
	        }
	        // Le cas où l'équipement en main est une Carabine 
	        else if(this.equipEnMain instanceof Rifle) {
	        	if (this.positionX != zombie.getPositionX() && this.positionY != zombie.getPositionY()) {
		        	int successes = 0;
		        	// Le survivant à le droit à deux lancers de dés
		            for (int i = 0; i < 2; i++) {
		                int resultDe = lancerDe();
		                if (resultDe >= equipEnMain.getSeuil()) {
		                    successes++;
		                }
		            }
		            if (successes > 0) {
		                System.out.println("Le " + this.getName()+ " a attaqué le "+ zombie.getName() + " avec succès !");
		                zombie.reduirePointsVies(equipEnMain.getDegat() * successes);
		                if (zombie.isDead()) {
		                    this.expertiseLevel++;
		            		town.removeZombie(zombie);
		                }
		            } else {
		            	System.out.println("Le " + this.getName() +" n'a pas réussi à attaquer le " + zombie.getName());
		            }
	        	}
	        	else {
	            	System.out.println("Le " + this.getName() + " ne peut pas attaquer le "+ zombie.getName() +  " à cause de la portée de l'arme");
	        	}
	        }
	        // Décrémente les points d'action du survivant
	        actionPoints--;
    		this.expertiseLevel++;

	    }

	    /**
	     * Permet au survivant de regarder autour de lui dans une zone donnée.
	     * Affiche les survivants et les zombies présents dans la même zone que le survivant.
	     * 
	     * @param area La zone dans laquelle le survivant effectue son observation.
	     */
	    public void lookAround(Area area) {
	        System.out.println("👀 Le "+ this.getName() + " regarde autour de lui : ");


			// Survivants présents
	        System.out.println("  👥 Survivants présents dans la meme zone que lui :");

			if (area.getSurvivors().isEmpty()){
	            System.out.println("    Aucun");
			}
			else{			
				for (Survivor s : area.getSurvivors()) {
					System.out.println("    Nom du survivant : " + s.getName());
				}
			}


			// Zombies présents
	        System.out.println("  💀 Zombies présents dans la meme zone que lui :");
	        if (area.getZombies().isEmpty() ) {
	            System.out.println("    Aucun");
        	}
	        for (Zombie z : area.getZombies()) {
	        	System.out.println("    Nom du zombie : " + z.getName());
	        }

			// Indique l'état des portes (ouvert ou fermé) de la zone
			System.out.println("🚪 État des portes :");
			if (area instanceof Room){
				Room room = (Room) area;

				
				if (room.getDoor().Porte_Droite_ouverte()){
					System.out.println("    Porte droite : Ouverte");
				}
				else{
					System.out.println("    Porte droite : Fermée");
				}
				if (room.getDoor().Porte_Gauche_ouverte()){
					System.out.println("    Porte gauche : Ouverte");
				}
				else{
					System.out.println("    Porte gauche : Fermée");
				}
				if (room.getDoor().Porte_Bas_ouverte()){
					System.out.println("    Porte bas : Ouverte");
				}
				else{
					System.out.println("    Porte bas : Fermée");
				}
				if (room.getDoor().Porte_Haut_ouverte()){
					System.out.println("    Porte Haut : Ouverte");
				}
				else{
					System.out.println("    Porte Haut : Fermée");
				}
			}
			else{
				System.out.println("    Le survivant se trouve une rue alors il ne peut pas savoir.");
			}
		}

	    /**
	     * Fait du bruit pour attirer les zombies.
	     * Augmente d'une unité le niveau de bruit de la zone où se trouve le survivant.
	     */
	    public void faireDuBruit(Area area) {
            area.makeNoise(1);
            System.out.println("🔊 Le " + getName() + " fait du bruit pour attirer les zombies.");
	    }
		

		/**
	     * Lance un dé à six faces et renvoie le résultat.
	     *
	     * @return Le résultat du lancer de dé, un nombre aléatoire entre 1 et 6 inclus.
	     */
	    private int lancerDe() {
	        return (int) (Math.random() * 6) + 1;
	    }
	    
	    /**
	     * Augmente le niveau d'expertise du survivant en ajoutant un certain nombre de points.
	     * 
	     * @param points Le nombre de points à ajouter au niveau d'expertise du survivant.
	     */
	    public void gagnerExpertise(int points) {
	    	this.expertiseLevel += points;
	    }

		/**
		 * Deplace un survivor avec l'interdiction de se deplacer en diagonales.
		 * @param town la ville où se trouve le survivor
		 * @param x la cordonnée x du déplacement, la nouvelle position
		 * @param y la coordonée y du déplacement, la nouvelle position
		 */
		public void move_survivor(Town town, int x, int y) {
			if(this.positionX==x && this.positionY+1==y || (this.positionX+1==x && this.positionY==y) || (this.positionX==x && this.positionY-1==y)||(this.positionX-1==x && this.positionY==y)){
				String res="";
				if ( this.positionX==x && this.positionY+1 ==y){
					res="droite";
				}
				else if ( this.positionX==x && this.positionY-1 ==y){
					res="gauche";
				}
				else if ( this.positionX-1==x && this.positionY ==y){
					res="haut";
				}
				else {
					res="bas";
				}
				town.getBoard()[this.positionX][this.positionY].supprimerSurvivor(this);
				this.setPosition(x, y);
				town.getBoard()[x][y].ajouterSurvivor(this);

				System.out.println("🚶 Le " + this.getName() + " s'est déplacé vers "+ res+  "  à la position : ("+x+","+y+")");

			}
		
			else {
				System.out.println("Déplacement invalide. Le survivant reste à sa position actuelle.");
			}
				
		}
		
		/**
		 * Fouiller une pièce.
		 * Seules les pièces peuvent être fouillées, pas les rues.
		 * Des équipements qui tombent dans la rue sont perdus et disparaissent du jeu.
		 * Lorsqu’il fouille une pièce, le survivant peut ramasser un équipement qu’il découvre et le mettre dans son sac à dos.
		 * Il est pour cela nécessaire qu’il y ait encore de la place dans son sac qui peut contenir au maximum 5 équipements.
		 * Si ce n’est pas le cas, le survivant peut jeter un équipement pour en prendre un nouveau.
		 * Dans ce cas l’équipement jeté reste sur place dans la pièce, de même que tout équipement découvert lors de la fouille mais non ramassé.
		 *
		 * @param area La pièce à fouiller.
		 */
		public void fouillerPiece(Area area) {
		    if (area instanceof Room) { // Seules les pièces peuvent être fouillées, pas les rues
		        Room room = (Room) area;
		        if (!room.getEquipment().isEmpty()) { // Si la pièce contient des équipements
		            if (backpack.size() < 5) { // Si le sac à dos du survivant n’est pas plein
		                Equipment equipmentToAdd = room.getEquipment().get(0); // On prend le premier équipement de la liste
		                room.removeEquipment(equipmentToAdd); // On le retire de la pièce
		                backpack.add(equipmentToAdd); // On l’ajoute au sac à dos du survivant
		                this.actionPoints--;
		                System.out.println("👌 Le " + this.getName() + " a fouillé une pièce et a trouvé " + equipmentToAdd.getName() + " et l'a ajouté à son sac à dos.");
		            } else { // Sinon, le sac à dos est plein
		                System.out.println("Votre sac à dos est plein. Vous devez jeter un équipement pour en prendre un nouveau.");
						Random hasard = new Random();
        				int equipement_hasard = hasard.nextInt(5);
						Equipment equipmentToRemove = backpack.get(equipement_hasard);
						System.out.println("Vous avez jeté " + equipmentToRemove + " de votre sac à dos.");


		                if (equipmentToRemove != null) {
		                    backpack.remove(equipmentToRemove); // On retire l’équipement du sac à dos du survivant
		                    room.ajouterEquipment(equipmentToRemove); // On le met dans la pièce
		                    Equipment equipmentToAdd = room.getEquipment().get(0); // On prend le premier équipement de la liste
		                    room.removeEquipment(equipmentToAdd); // On le retire de la pièce
		                    backpack.add(equipmentToAdd); // On l’ajoute au sac à dos du survivant
		                    System.out.println("Le " + this.getName() + " a fouillé une pièce mais son sac à dos est plein donc a jeté " + equipmentToRemove.getName() + " et trouvé " + equipmentToAdd.getName() + " qu'il a ajouté à son sac à dos.");
			                this.actionPoints--;
		                } else {
		                    System.out.println("Cet équipement n'existe pas dans votre sac à dos.");
		                }
		            }
		        } else {
		            System.out.println("Cette pièce ne contient aucun équipement donc le "+ this.getName() + " n'a pas pu fouiller la pièce et récupérer un équipement.");
		        }
		    } else {
		        System.out.println( "Le " + this.getName() + " ne peut pas fouiller une rue.");
		    }
		}
		
		/**
		 * Augmente les points de santé du survivant de 1.
		 */
		public void gainHealthPoints() {
			this.healthPoints = this.healthPoints + 1;
		}

		/**
		 * Ajoute un nombre spécifié de points aux points de santé du survivant.
		 * 
		 * @param points Le nombre de points à ajouter aux points de santé du survivant.
		 */
		public void addHealthPoints(int points) {
			this.healthPoints += points;
		}
		
		
        /**
         * Permet au survivant de prendre un équipement en main à partir de son sac à dos.
         * 
         * @param equipement L'équipement à prendre en main.
         */
        public void prendreEnMain(Equipment equipement) {
        	// Vérifie si l'équipement spécifié est dans le sac du survivant
            if (this.backpack.contains(equipement)) {
            	if (this.equipEnMain != null) {
            		Equipment ancienEquip = this.equipEnMain;
                    // Si oui, remet l'équipement en main dans le sac
                    this.ajouterEquipement(this.equipEnMain);
                    this.equipEnMain = equipement;
                    this.enleverEquipement(equipement);
                    System.out.println("Le "+ this.getName()+ " remet " + ancienEquip + " dans son sac🎒 et prend " + this.equipEnMain.getName() + " en main🖐️");
                    this.actionPoints--;
            	}
            	else {
                    this.equipEnMain = equipement;
                    this.enleverEquipement(equipement);
                    System.out.println(this.getName() + " prends en main " + equipement.getName() + " .");
                    this.actionPoints--;
            } 
            }
            else {
                System.out.println("Le "+ this.getName() + "ne posséde pas " +equipement.getName() + " dans son sac.");
            }
        }
        
       
	/**
	 * Ouvre une porte en fonction de la position du survivor
	 */
	public void ouvrir_une_porte(Town town,Room room){
		if (this.peut_ouvrir(room)){
			int room_x=-1;
			int room_y=-1;
			for (int x=0;x<town.getWidth();x++){
				for (int y=0;y<town.getHeight();y++){
					if (town.getBoard()[x][y]==room){
						// recupère les coordonnées de cet room
						room_x=x;
						room_y=y;
					}
				}
			} 
			if(this.getPositionX()-1== room_x){ // la porte est a droite 
				room.room_ouvrir_porte_droite(town,this);
				System.out.println("Le "+this.getName()+" à ouvert la porte droite");
			}
			else if (this.getPositionX()+1== room_x){ // la porte est à gauche
				room.room_ouvrir_porte_gauche(town,this);
				System.out.println("Le "+this.getName()+" à ouvert la porte gauche");

			}
			else if (this.getPositionY()+1== room_x){ // la porte est en bas 
				room.room_ouvrir_porte_bas(town,this);
				System.out.println("Le "+this.getName()+" à ouvert la porte d'en bas");
			}
			else{ // la porte est en haut
				room.room_ouvrir_porte_haut(town,this);
				System.out.println("Le "+this.getName()+" à ouvert la porte du haut");
			}
			
			System.out.println("L'ouverture de la porte a provoqué du bruit!"); // car peut_ouvrir() augmente le bruit.

			town.consequence_ouvrage_porte(); 
		}
		else {
			System.out.println("Le " + this.getName() + " n'a pas d'équipement en main lui permettant d'ouvrir cette porte.");
		}

		
	}

	/**
     * Obtenir l'équipement en main
     * @return l'équipement en main
     */
	public Equipment get_equipMain(){
		return this.equipEnMain;
	}

	/**
     * Verifie si le survivant peur ouvrir une porte selon l'équipement qu'il a en main
     * @return Vrai si le survivant peut ouvrire une porte, faux sinon
     */
    public boolean peut_ouvrir(Room room){
        if (this.get_equipMain() instanceof MasterKey || this.get_equipMain() instanceof ChainSaw || this.get_equipMain() instanceof Axe || this.get_equipMain() instanceof Crowbar){
			if (this.get_equipMain() instanceof Weapon){
				room.makeNoise(1);
			}
            return true;
        }
        return false;
    }
}
