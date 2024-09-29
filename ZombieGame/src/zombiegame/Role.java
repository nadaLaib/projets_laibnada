package zombiegame;
import zombiegame.Actors.*;


/**
 * L'interface Role définit le contrat pour les différents rôles des survivants dans la ville.
 */
public interface Role {
		
	/**
     * Applique le rôle spécifié à un survivant dans la ville.
     * @param town la ville où se trouve le survivant
     * @param survivor le survivant auquel appliquer le rôle
     * @param zombie le zombie rencontré par le survivant
     */
    public void applyRole(Town town, Survivor survivor, Zombie zombie);
}
