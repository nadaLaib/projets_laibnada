package zombiegame.Equipments;

import zombiegame.Equipment;
import zombiegame.Actors.Survivor;



/**
 * La classe MasterKey représente la clé passe-partout
 * Son utilisation permet d'ouvrir n'importe quelle porte 
 */
public class MasterKey extends Equipment {

	public MasterKey() {
        super("un passe-partout");
    }



	public void use(Survivor survivor) {
		// TODO Auto-generated method stub
		
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