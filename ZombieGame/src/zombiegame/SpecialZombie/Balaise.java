package zombiegame.SpecialZombie;

import zombiegame.Actors.*;


/**
 * La classe Balaise représente un type spécial de zombie particulièrement redoutable dans le jeu.
 */
public class Balaise extends Zombie {
    /** Les points de vie initiaux d'un Balaise. */
    private static final int INITIAL_HEALTH_POINTS = 4;
    /** Les points de dégâts infligés par un Balaise lorsqu'il attaque. */
    private static final int DAMAGE_POINTS = 2;
    
    
    /**
     * Constructeur pour la classe Balaise
     * @param name Le nom du Walker.
     * @param positionX La position X initiale du Walker.
     * @param positionY La position Y initiale du Walker.
     */
    public Balaise(String name, int positionX, int positionY) {
        super("Balaise", positionX, positionY);
        this.healthPoints = INITIAL_HEALTH_POINTS;
    }
    
    
    /**
     * Méthode permettant au Balaise d'attaquer une cible.
     * Si la cible est un Survivor, le Balaise lui inflige des dégâts.
     * @param target La cible de l'attaque.
     */
    public void attack(Survivor survivor) {
        survivor.takeDamage(DAMAGE_POINTS);
   }
    
    
}