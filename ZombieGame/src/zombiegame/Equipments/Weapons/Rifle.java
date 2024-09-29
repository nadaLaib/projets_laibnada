package zombiegame.Equipments.Weapons;

import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;
import zombiegame.Equipments.Weapon;
import zombiegame.Town;

/**
 * La classe Rifle représente la carabine
 * seuil 4, valeur de dégât 1, 
 * portée 1 à 3
 */

public class Rifle extends Weapon {

    /**
     * Constructeur de la classe Rifle
     */
    public Rifle() {
    	super("une carabine", 4, 1, 3);
    }


	/**
     * Utilise la carrabine pour attaquer un zombie.
     * @param survivor Le survivant qui utilise l'arme.
     * @param zombie Le zombie ciblé par l'attaque.
     */
    @Override
    public  void utiliser(Survivor survivor, Zombie zombie) {
        Town town = new Town();
        // Appeler la méthode attaquerZombie du survivant 
        survivor.attaquerZombie(town, zombie);

		
	}


}