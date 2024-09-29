package zombiegame.Roles;

import zombiegame.Actors.*;
import zombiegame.Role;
import zombiegame.Town;


/**
 * La classe Healer représente le rôle d'un soignant dans le jeu.
 */
public class Healer implements Role {
    private String name;
	
    /**
     * Constructeur par défaut pour la classe Healer.
     * Initialise le nom du rôle à "Healer".
     */
    public Healer() {
    	this.name = "Healer";
    }
    
    /**
     * Récupère le nom du rôle.
     *
     * @return Le nom du rôle.
     */
    public String getName() {
    	return this.name;
    }
    
    
    /**
     * Applique le rôle de soignant à un survivant.
     * Augmente les points de vie du survivant et de tous les autres survivants dans la même zone.
     *
     * @param town La ville où se trouve le survivant.
     * @param survivor Le survivant auquel appliquer le rôle.
     * @param zombie Le zombie actuel (non utilisé dans cette méthode).
     */
    public void applyRole(Town town, Survivor survivor, Zombie zombie) {
    	int positionX = survivor.getPositionX();
        int positionY = survivor.getPositionY();
        
     // Parcourir tous les survivants de la ville
        for (Survivor otherSurvivor : town.getSurvivors()) {
            // Vérifier si le survivant actuel est dans la même zone que le survivant donné en paramètre
            if (otherSurvivor.getPositionX() == positionX && otherSurvivor.getPositionY() == positionY) {
                    otherSurvivor.addHealthPoints(1);
                    System.out.println("Le soigneur " + survivor.getName() + " a soigné " + otherSurvivor.getName() + ".");
            }
            
        }

        survivor.addHealthPoints(1);
    }

}