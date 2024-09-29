package zombiegame.Equipments;

import zombiegame.Town;
import zombiegame.Actors.Survivor;



public class HealingPotionTest {
    public static void main(String[] args) {
        // Création d'une fiole de guérison
        HealingPotion potion = new HealingPotion();

        Town town = new Town ();
        // Création d'un survivant pour tester l'utilisation de la fiole de guérison
        Survivor survivor = new Survivor("S1", 10, 20, town);

        // Affichage des points de vie avant l'utilisation de la potion
        System.out.println("Points de vie avant : " + survivor.getHealthPoints());

        // Utilisation de la potion par le survivant
        potion.use(survivor);

        // Affichage des points de vie après l'utilisation de la fiolr de guérison
        System.out.println("Points de vie après : " + survivor.getHealthPoints());
    
    
    
        // Vérification si les points de vie ont augmenté
        if (survivor.getHealthPoints() > 20) {
            System.out.println("Les points de vie ont augmenté avec succès !");
        } else {
            System.out.println("Les points de vie n'ont pas augmenté !");
        }
    
    }
}
