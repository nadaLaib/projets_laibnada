package zombiegame.Equipments;

import zombiegame.Town;
import zombiegame.Actors.Survivor;

public class AidKitTest {

    
    public static void main(String[] args) {
        // Création d'une trousse de secours
        AidKit aidKit = new AidKit();

        Town town = new Town();
        // Création d'un survivant pour tester l'utilisation de la trousse de secours
        Survivor survivor = new Survivor("S1", 10, 20,town);

        // Affichage des points de vie avant l'utilisation de la trousse de secours
        System.out.println("Points de vie avant : " + survivor.getHealthPoints());

        // Utilisation de la trousse de secours par le survivant
        aidKit.use(survivor);

        // Affichage des points de vie après l'utilisation de la trousse de secours
        System.out.println("Points de vie après : " + survivor.getHealthPoints());

        // Vérification si les points de vie ont augmenté
        if (survivor.getHealthPoints() > 20) {
            System.out.println("Les points de vie ont augmenté avec succès !");
        } else {
            System.out.println("Les points de vie n'ont pas augmenté !");
        }
    }
}
