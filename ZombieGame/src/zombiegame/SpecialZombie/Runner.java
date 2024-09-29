
package zombiegame.SpecialZombie;

import zombiegame.Actors.*;


/**
 * La classe Runner représente un type spécial de zombie particulièrement redoutable dans le jeu.
 */
public class Runner extends Zombie {
    /** Les points de vie initiaux d'un Runner. */
    private static final int INITIAL_HEALTH_POINTS = 2;
    /** Les points de dégâts infligés par un Runner lorsqu'il attaque. */
    private static final int DAMAGE_POINTS = 1;
   
    
    /**
     * Constructeur pour la classe Runner.
     * @param name Le nom du Runner.
     * @param positionX La position X initiale du Runner.
     * @param positionY La position Y initiale du Runner.
     */
    public Runner(String name, int positionX, int positionY) {
        super("Runner", positionX, positionY);
        this.healthPoints = INITIAL_HEALTH_POINTS;

    }
    
  
    /**
     * Méthode permettant au Runner d'attaquer une cible.
     * Si la cible est un Survivor, le Runner lui inflige des dégâts.
     * @param target La cible de l'attaque.
     */
    
    public void attack(Survivor survivor) {
        survivor.takeDamage(DAMAGE_POINTS);
   }

}
