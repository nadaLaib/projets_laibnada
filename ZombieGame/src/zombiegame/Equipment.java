package zombiegame ;

import zombiegame.Actors.*;  //importer la classe Survivor
import zombiegame.Equipments.Weapons.* ; 
import zombiegame.Equipments.* ;

/**
 * La classe Equipment incarne un équipement du jeu
 * Un équipement a un attribut name 
 * et peut être utilisé par un Survivor
 */
public  class Equipment {
    private String name ;
    // Attribut pour stocker le niveau de bruit
    private int noiseLevel = 0;


    /**
     * Conctructeur de la classe Equipment
     * @param name le nom de l'équipement 
     */ 
    public Equipment(String name) {
        this.name = name;
    }

    /**
     * Getter pour avoir le nom de l'équipement
     * @return le nom de l'équipement
     */
    public String getName() {
        return this.name ;
    }



    public void applyEffect() {
        // Vérifier le type d'équipement
        if (this instanceof Map || this instanceof Gun || this instanceof Rifle || this instanceof ChainSaw) {
            // Augmenter le niveau de bruit dans la zone où se trouve le survivant
            this.noiseLevel+=1 ;
        }
    }


    /**
     * Méthode toString pour représenter l'équipement
     * @return le nom de l'équipement
     */
    public String toString() {
        return this.name ;
    }

    public int getDegat() {
        return 0; // Ou une autre valeur par défaut appropriée
    }
	
    public int getSeuil() {
        return 0; // Ou une autre valeur par défaut appropriée
    }
	
    public int getPortee() {
        return 0; // Ou une autre valeur par défaut appropriée
    }
    public void use(Town town, Survivor survivor){
    return ;
    }

}