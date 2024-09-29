package zombiegame.Equipments.Weapons;

import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;
import zombiegame.Equipments.Weapon;
import zombiegame.Town;


/**
 * La classe ChainSaw représente la tronçonneuse 
 */

public class ChainSaw extends Weapon {

    /**
     * Constructeur de la classe ChainSaw
     */
    public ChainSaw() {
    	super("une tronçonneuse", 5, 3, 0);
    }

    
    
    /**
    * Utilise la tronçonneuse pour attaquer un zombie.
    * @param survivor Le survivant qui utilise l'arme.
    * @param zombie Le zombie ciblé
    */
		
    public  void utiliser(Survivor survivor, Zombie zombie) {
        Town town = new Town();
        // Appeler la méthode attaquerZombie du survivant 
        survivor.attaquerZombie(town, zombie);

		
	}
	



}