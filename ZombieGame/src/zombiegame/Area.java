package zombiegame ;

import java.util.ArrayList;
import java.util.List;

import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;

/**
 * La classe abstraite Area représente une zone dans le jeux 
 */
public abstract class Area {

	 /**
     * Cette méthode abstraite doit être implémentée par les sous-classes pour fournir une représentation textuelle de l'aire.
     * @return Une chaîne de caractères représentant l'aire.
     */
	public abstract String toString();

     protected int width; // Largeur de la zone
     protected int height; // Hauteur de la zone
     protected int noiseLevel ; // Niveau de bruit dans la zone
     protected List<Survivor> survivors; // Liste de survivants sur la zone
     protected List<Zombie> zombies; // Liste de zombie sur la zone
     protected List<Equipment> equipmentList; // Liste des équipements sur la zone
     
     
     /**
     * Constructeur de la classe Area.
     */
    public Area() {
	     this.noiseLevel = 0; // Initialise le niveau de bruit à 0 par défaut
	     this.survivors= new ArrayList<>(); // Initialise une liste vide de survivants
	     this.zombies = new ArrayList<>(); // Initialise une liste vide de zombies
	     this.equipmentList = new ArrayList<>(); // Initialise une liste vide d'équipements
    }

    /**
     * Ajoute un survivor à la zone.
     * @param survivor le survivor à ajouter
     */
    public void ajouterSurvivor(Survivor survivor){
     this.survivors.add(survivor);
    }

    
    /**
     * Ajoute un zombie à la zone
     * @param zombie le zombie à ajouté
     */
    public void ajouterZombie(Zombie zombie){
     this.zombies.add(zombie);
    }

    
    /**
     * Supprime le survivor de la zone
     * @param survivor le survivor à supprimé
     */
    public void supprimerSurvivor(Survivor survivor){
     this.survivors.remove(survivor);
    }

    
    /**
     * Supprime le zombie de la zone
     * @param zombie le zombie à supprimer
     */
    public void supprimerZombie(Zombie zombie){
     this.zombies.remove(zombie);
    }

    
     /**
      * Ajouter du bruit dans la zone 
      * @param noiseAmount le bruit ajouté à cette zone (selon l'action)
      */
     public void makeNoise(int noiseAmount) {
          noiseLevel += noiseAmount ;

     }


     /**
      * Méthode pour réinitialiser le niveau de bruit à 0 pour le nouveau tour
      */
     public void resetNoise() {
          noiseLevel = 0 ;
     }
     
     

     /**
      * Obtenir le niveau de bruit de la zone
      * @return le niveau de bruit de la zone
      */
     public int getNoiseLevel() {
          return noiseLevel ;

     }
     
     /**
      * Ajouter un equipement à la zone
      * @param equipment Equipement à ajouter dans la zone
      */
     public void ajouterEquipmentToArea(Equipment equipment) {
          equipmentList.add(equipment);
      }

     

     /**
      * Obtenir la liste d'équipement sur la zone
      * @return la liste d'équipement sur la zone
      */
     public List<Equipment> getEquipmentList() {
          return equipmentList;
      }
     
     
     /**
      * Vérifie si la position spécifiée est accessible dans la zone.
      * @param x coordonnée x de la position à vérifier
      * @param y coordonnée y de la position à vérifier
      * @return true si la position est accessible, false sinon
      */
     public boolean isAccessible(int x, int y) {
          if (x < 0 || x >= width || y < 0 || y >= height) {
               return false;
           }
          return false;
           
      }
     
     
     
     /**
      * Obtient la liste des survivants dans la zone.
      * @return La liste des survivants dans la zone.
      */
     public List<Survivor> getSurvivors() {
         return survivors;
     }


    
     /**
      * Obtient la liste des zombies dans la zone.
      * @return La liste des zombies dans la zone.
      */
     public List<Zombie> getZombies() {
         return zombies;
     }


    
}