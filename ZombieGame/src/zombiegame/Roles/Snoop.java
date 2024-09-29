package zombiegame.Roles;

import zombiegame.Actors.*;
import zombiegame.*;

/**
 * La classe Snoop représente le rôle d'un survivant espion dans le jeu.
 */
public class Snoop implements Role {
    private String name;
	
    
    /**
     * Constructeur par défaut pour la classe Snoop.
     * Initialise le nom du rôle à "Snoop".
     */
    public Snoop() {
    	this.name = "Snoop";
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
     * Applique le rôle d'espion à un survivant.
     * Permet au survivant de fouiller une pièce gratuitement.
     *
     * @param town La ville où se trouve le survivant.
     * @param survivor Le survivant auquel appliquer le rôle.
     * @param zombie Le zombie qui peut être présent dans la même zone que le survivant.
     */
    public void applyRole(Town town, Survivor survivor, Zombie zombie) {
    	int positionX = survivor.getPositionX();
        int positionY = survivor.getPositionY();
        
        Area currentArea = town.board[positionX][positionY];
        survivor.fouillerPiece(currentArea);
        survivor.addHealthPoints(1); // Car l'action est gratuite grace à ce role
    }
}