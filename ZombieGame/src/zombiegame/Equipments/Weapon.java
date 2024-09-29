package zombiegame.Equipments;

import zombiegame.Equipment;
import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;



/**
 * La classe Weapon représente les armes
 * Permets de réaliser l’action d’attaquer un zombie 
 * ou bien l’action d’ouverture de porte
 */
public abstract class Weapon extends Equipment {
	private String nom;
	protected int seuil;
	protected int degat;
	private int portee;



	public Weapon (String nom, int seuil, int degat, int portee) {
		super(nom);
        this.seuil = seuil;
        this.degat = degat;
        this.portee = portee;
    }


    /**
     * Méthode abstraite qui sera implémentée dans les sous-classes.
     * L'équipement est utilisé par un Survivor pour attaquer un Zombie.
     * @param survivor Le survivant qui utilise l'équipement.
     * @param zombie Le zombie ciblé par l'attaque.
     */
    public abstract void utiliser(Survivor survivor, Zombie zombie);



    public void use(Survivor survivor) {
        
    }




    public String getNom() {
        return nom;
    }

    public int getSeuil() {
        return seuil;
    }

    public int getDegat() {
        return degat;
    }

    public int getPortee() {
        return portee;
    }

    
}

