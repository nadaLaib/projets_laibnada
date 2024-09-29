package zombiegame.SpecialZombie;

import zombiegame.Actors.*;

/**
 * La classe Walker représente un type spécial de zombie particulièrement redoutable dans le jeu.
 */
public class Walker extends Zombie {
    
    private static final int INITIAL_HEALTH_POINTS = 1;
    /** Les points de dégâts infligés par un Walker lorsqu'il attaque. */
    private static final int DAMAGE_POINTS = 1;
    
    
    /**
     * Constructeur pour la classe Walker.
     * @param name Le nom du Walker.
     * @param positionX La position X initiale du Walker.
     * @param positionY La position Y initiale du Walker.
     */
    public Walker(int positionX, int positionY) {
        super("Walker", positionX, positionY);
        this.healthPoints = INITIAL_HEALTH_POINTS;
    }
    
    
    /**
     * Méthode permettant au Walker d'attaquer une cible.
     * Si la cible est un Survivor, le Walker lui inflige des dégâts.
     * @param survivor La cible de l'attaque.
     */
    public void attack(Survivor survivor) {
         survivor.takeDamage(DAMAGE_POINTS);
    }
}