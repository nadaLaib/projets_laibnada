package zombiegame.Equipments.Weapons;

import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;
import zombiegame.Town;
import zombiegame.Equipments.Weapon;



 
/** 
 * La class Axe représente une hache 
 */
public class Axe extends Weapon {

    /**
     * Constructeur de la classe Axe
     * Initialise les propriétés de l'arme en fonction des spécifications de la hache.
     */
    public Axe() {
    	super("une hache", 4, 2, 0);
    }
    
    
    /**
     * Utilise la hache pour attaquer un zombie.
     * @param survivor Le survivant qui utilise l'arme.
     * @param zombie Le zombie ciblé par l'attaque.
     */
    public  void utiliser(Survivor survivor, Zombie zombie) {
        Town town = new Town();
        // Appeler la méthode attaquerZombie du survivant 
        survivor.attaquerZombie(town, zombie);

		
	}
    
    
    

}