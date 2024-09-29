package zombiegame.SpecialZombie;

import zombiegame.Actors.*;

/**
 * La classe Abomination représente un type spécial de zombie particulièrement redoutable dans le jeu.
 */
public class Abomination extends Zombie {
     /** Les points de vie initiaux d'une Abomination. */
    private static final int INITIAL_HEALTH_POINTS = 6;
    /** Les points de dégâts infligés par une Abomination lorsqu'elle attaque. */
    public static final int DAMAGE_POINTS = 3;
    
    
    /**
     * Constructeur pour la classe Abomination.
     * @param name Le nom de l'Abomination.
     * @param positionX La position X initiale de l'Abomination.
     * @param positionY La position Y initiale de l'Abomination.
     */
    public Abomination(String name, int positionX, int positionY) {
        super(name,positionX, positionY);
        this.healthPoints = INITIAL_HEALTH_POINTS;
    }
    
    /**
     * Méthode permettant à l'Abomination d'attaquer une cible.
     * Si la cible est un Survivor, l'Abomination lui inflige des dégâts.
     * @param target La cible de l'attaque.
     */
    public void attack(Survivor survivor) {
        survivor.takeDamage(DAMAGE_POINTS);
   }

    /**
     * Renvoie une représentation sous forme de symbole de l'Abomination.
     *
     * @return Une chaîne vide, car la représentation graphique de l'Abomination est définie ailleurs.
     */
   public String toString(){
        return "";
    }
}