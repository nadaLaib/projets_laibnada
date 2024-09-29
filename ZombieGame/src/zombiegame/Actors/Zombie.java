package zombiegame.Actors;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

import zombiegame.*;
import zombiegame.SpecialZombie.*;

/**
 * La classe Zombie représente un zombie dans le jeu.
 */
public class Zombie extends Actor {
	
    /**
     * Constructeur pour la classe Zombie.
     * @param name Le nom du zombie.
     * @param healthPoints Les points de vie du zombie.
     * @param positionX La position X initiale du zombie.
     * @param positionY La position Y initiale du zombie.
     */
    public Zombie(String name, int positionX, int positionY) {
        super(name, positionX, positionY);
    }
    
    
   /**
     * Méthode permettant au zombie d'attaquer une cible.
     * Si la cible est un Survivor, le zombie lui inflige des dégâts.
     * 
     * @param target La cible de l'attaque.
     */
    public void attack(Actor target) {
        if (target instanceof Survivor) {
            Survivor survivor = (Survivor) target;
            // Pour un zombie normal, l'attaque inflige toujours 1 point de dégât.
            survivor.takeDamage(1); 
        }
    }

    /**
     * Renvoie une représentation textuelle du zombie adaptée à l'affichage sur le plateau de jeu.
     *
     * @return Une chaîne de caractères représentant un zombie.
     */
    public String toString(){
        return "☠";
    }
    
    
    /**
     * Réduit les points de vie du zombie.
     *
     * @param points Les points de vie à retirer.
     */
    public void reduirePointsVies(int points) {
    	this.healthPoints = this.healthPoints - (points);
    }
    
    
    /**
     * Récupère les points de vie du zombie.
     *
     * @return Les points de vie du zombie.
     */
    public int getHealthPoints() {
    	return this.healthPoints;
    }

    /**
     * Action d'attaque du survivant par le zombie
     */
    public void attaquerSurvivant(Town town, Survivor[] survivors,Zombie zombie) {

        int zombieX = zombie.getPositionX();
        int zombieY = zombie.getPositionY();

        // Liste pour stocker les indices des survivants dans la même zone que le zombie
        List<Integer> survivorsInSameZoneIndices = new ArrayList<>();
    
    for (int i = 0; i < survivors.length; i++) {
        Survivor survivor = survivors[i];
        //les coordonnées du survivant
        int survivorX = survivor.getPositionX();
        int survivorY = survivor.getPositionY();
        
        if (zombieX == survivorX && zombieY == survivorY) {
            survivorsInSameZoneIndices.add(i);
        }
    }
    // Vérifier s'il y a au moins un survivant dans la même zone que le zombie,Sélectionner un indice aléatoire parmi les survivants dans la même zone
    if (!survivorsInSameZoneIndices.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(survivorsInSameZoneIndices.size());
            int selectedSurvivorIndex = survivorsInSameZoneIndices.get(randomIndex);
    
            // Récupérer le survivant correspondant à l'indice sélectionné
            Survivor selectedSurvivor = survivors[selectedSurvivorIndex];
    
            //le zombie est de type Runner
            if (this instanceof Runner) {
                ((Runner) this).attack(selectedSurvivor);
            } //le zombie est de type Walker
            else if (this instanceof Walker) {
                ((Walker) this).attack(selectedSurvivor);
            } //le zombie est de type Balaise
            else if (this instanceof Balaise) {
                ((Balaise) this).attack(selectedSurvivor);
            } //le zombie est de type Abomination
            else if (this instanceof Abomination) {
                ((Abomination) this).attack(selectedSurvivor);
            }
            // si le survivant est mort après l'attaque
            if (selectedSurvivor.isDead()) {
                town.removeSurvivor(selectedSurvivor);
            } 
        } 
        else {
        // Si aucun survivant n'est présent dans la même zone, le zombie ne fait rien
        System.out.println("Aucun survivant n'est présent dans la même zone que le zombie.");
    }
}
    
    

    /**
     * Action d'attaque du survivant par le zombie
     */
    public void attaquerSurvivant(Town town, Survivor survivor) {
        int zombieX = this.getPositionX();
        int zombieY = this.getPositionY();
        
        
            int survivorX = survivor.getPositionX();
            int survivorY = survivor.getPositionY();
            
            if (zombieX == survivorX && zombieY == survivorY) {
                this.attack(survivor);
                
                // sortir après avoir attaqué un survivant
                return; 
            }
        
        
    }


    /**
		 * Deplace un zombie vers la zone bruyante avec linterdiction de se déplacer en diagonale
		 * @param town la ville où se trouve le zombie
		 * @param x la cordonnée x du déplacement, la nouvelle position
		 * @param y la coordonée y du déplacement, la nouvelle position
		 */
		public void move_zombie(Town town, int x, int y) {
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
				town.getBoard()[this.positionX][this.positionY].supprimerZombie(this);
				this.setPosition(x, y);
				town.getBoard()[x][y].ajouterZombie(this);

				System.out.println("Le " + this.getName() + " s'est déplacé vers "+ res+  "  à la position : ("+x+","+y+")");

			}
		
			else {
				System.out.println("Déplacement invalide. Le zombie reste à sa position actuelle.");
			}
				
		}
    

    /**
     * Récupère le nom du zombie.
     *
     * @return Le nom du zombie.
     */
	public String getName() {
		return this.name;
	}


}
