package zombiegame.Equipments.Weapons;

import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;
import zombiegame.Equipments.Weapon;
import zombiegame.Town;


/**
 * La classe Crowbar représente le pied de biche
 */

public class Crowbar extends Weapon {

	public Crowbar() {
		super("un pied de biche", 4, 1, 0);
	}
	
	/**
    * Utilise le pied de biche pour attaquer un zombie.
    * @param survivor Le survivant qui utilise l'arme.
    * @param zombie Le zombie ciblé
    */
	@Override
    public  void utiliser(Survivor survivor, Zombie zombie) {
        Town town = new Town();
        // Appeler la méthode attaquerZombie du survivant 
        survivor.attaquerZombie(town, zombie);

		
	}
}