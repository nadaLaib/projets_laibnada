package zombiegame.Equipments;

import zombiegame.Equipment;
import zombiegame.Actors.Survivor;


/**
 * La classe AidKit représente la trousse de secours
 * permet de soigner au choix un des survivants dans sa zone 
 * augmente ses points de vie de 1
 */
public class AidKit extends Equipment {

    /**
     * Constructeur de la classe AidKit
     */
    public AidKit() {
        // Appel au constructeur de la classe mere
        super("une trousse de secours") ;
    }
    
    /**
     * Utiliser la troussed e secours
     * Augmente les points de vie du survivant 
     * @param survivor Le survivant sur lequel on utilise la trousse de secours 
     */
    public void use(Survivor survivor) {
        //les survivant gagne un point de vie
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