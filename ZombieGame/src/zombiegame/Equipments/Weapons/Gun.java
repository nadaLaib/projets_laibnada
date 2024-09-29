package zombiegame.Equipments.Weapons;

import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;
import zombiegame.Town;
import zombiegame.Equipments.Weapon;


/**
 * La classe Gun représente un pistolet
 */
public class Gun extends Weapon {

    /**
     * Constructeur de la classe Gun
     */
    public Gun() {
        super("un pistolet", 4, 1, 1);
    }

    /**
     * Utilise le pistolet pour attaquer un zombie.
     * @param survivor Le survivant qui utilise l'arme.
     * @param zombie Le zombie ciblé par l'attaque.
     */
    @Override
    public void utiliser(Survivor survivor, Zombie zombie) {
        Town town = new Town();
        // Appeler la méthode attaquerZombie du survivant 
        survivor.attaquerZombie(town, zombie);
    }
}
