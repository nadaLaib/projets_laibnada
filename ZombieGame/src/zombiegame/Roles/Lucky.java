package zombiegame.Roles;


import zombiegame.Role;
import zombiegame.Town;
import zombiegame.Actors.*;
   
/**
 * La classe Lucky représente le rôle d'un survivant chanceux dans le jeu.
 */
public class Lucky implements Role {
    private String name;
	
    
    /**
     * Constructeur par défaut pour la classe Lucky.
     * Initialise le nom du rôle à "Lucky".
     */
    public Lucky() {
    	this.name = "Lucky";
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
     * Applique le rôle de survivant chanceux à un survivant.
     * Augmente de 1 le nombre de points d'action du survivant et lui permet d'attaquer un zombie une deuxième fois gratuitement.
     *
     * @param town La ville où se trouve le survivant.
     * @param survivor Le survivant auquel appliquer le rôle.
     * @param zombie Le zombie à attaquer.
     */
    public void applyRole(Town town, Survivor survivor, Zombie zombie) {
    	// Bénéficie d'une deuxième tentative d'attaque de zombie gratuite
        survivor.attaquerZombie(town,zombie); 
        survivor.addActionPoints();
    }
    
}