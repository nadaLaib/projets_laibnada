package zombiegame.Equipments;

import zombiegame.Equipment;
import zombiegame.Actors.*;




/**
 * La classe HealingPotion représente la fiole de guérison
 * Elle augmente les points de vie du survivant qui l'utilise
 */
public class HealingPotion extends Equipment {

    /**
     * Constructeur de la classe HealingPotion
     */
    public HealingPotion() {
        super("une potion de guérison") ;

    }

    /**
     * Utilise la fiole de guérison pour augmenter les points
     * de vie du survivant
     * @param survivor Le survivant sur lequel utiliser la fiole
     */
    public void use(Survivor survivor) {
        //gagner un point de vie 
        survivor.gainHealthPoints() ;
        
    }
    
    @Override
    public int getDegat() {
        return 0; // Ou une autre valeur par défaut appropriée
    }
	
	@Override
    public int getSeuil() {
        return 0; // Ou une autre valeur par défaut appropriée
    }
	
	@Override
    public int getPortee() {
        return 0; // Ou une autre valeur par défaut appropriée
    }

}