package zombiegame.Equipments;

import zombiegame.Equipment;

import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;
import zombiegame.Area;
import zombiegame.Town;


/**
 * La classe map représente l'équipement carte 
 * Permet de visualiser l'ensemble de la ville et les acteurs
 */
public class Map extends Equipment {

    //attribut area pour stocker les zones d ela ville et les parcourir
    private Area[][] areas;

    /**
     * Constructeur de la classe Map
     * @param areas Les zones de la ville
     */
    public Map() {
        super("une carte");
    }
    

    /**
     * implémentation de use pour utiliser la carte
     * renvoie la liste des surviavnt de la carte avec leurs position 
     * @param survivor le surviavnt qui utilise la carte
     */
        
    public void use(Town town,Survivor survivor) {
        
        System.out.println("🗺️ La carte de la ville : ") ;
        System.out.println();

        //Parcourir les joueur du plateau
        //renvoyer leurs noms et leurs positions 
        System.out.println("Les survivants sur la carte :");
        for (Survivor s : town.getSurvivors()) {
            //nom du surviavnt 
            System.out.println("Nom du survivant : " + s.getName() +" Position X : " + s.getPositionX() +  " Position Y : " + s.getPositionY()+ " ") ;
            
        }
        System.out.println() ;

        //idem pour les zombies
        System.out.println("Zombies sur la carte :") ;
        for (Zombie z : town.getZombies()) {
            System.out.println("Nom du zombie : " + z.getName() +" Position X : " + z.getPositionX() +  " Position Y : " + z.getPositionY()+ " ") ;
           
        }


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





    // Augmenter le niveau de bruit de la zone
    /*survivor.makeNoise(1); mise en commentaire temporaire pour compiler et faire marcher le jeu
*/




}