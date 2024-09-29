package zombiegame.Roles;
import zombiegame.Actors.*;
import zombiegame.Role;
import zombiegame.Town;


/**
 * La classe Fighter représente le rôle d'un combattant dans le jeu.
 */
public class Fighter implements Role {
    private String name;
	
    /**
     * Constructeur par défaut pour la classe Fighter.
     * Initialise le nom du rôle à "Fighter".
     */
    public Fighter() {
    	this.name = "Fighter";
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
     * Applique le rôle de combattant à un survivant.
     * Augmente de 1 le nombre de points d'action du survivant et le fait attaquer un zombie.
     *
     * @param town La ville où se trouve le survivant.
     * @param survivor Le survivant auquel appliquer le rôle.
     * @param zombie Le zombie à attaquer.
     */
    public void applyRole(Town town, Survivor survivor, Zombie zombie) {
        /* Ajouter 1 à chaque lancer de dé lors d'une attaque pour le survivant*/
        survivor.attaquerZombie(town,zombie); 
        survivor.addActionPoints();

    }
}