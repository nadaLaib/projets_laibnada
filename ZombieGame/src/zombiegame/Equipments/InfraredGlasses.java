package zombiegame.Equipments;

import zombiegame.Equipment;
import zombiegame.Actors.Survivor;
import zombiegame.Actors.Zombie;
import zombiegame.Town;
import java.util.List;
import java.util.ArrayList;
import zombiegame.Area;
import zombiegame.*;
import zombiegame.SpecialRoom.*;


/**
 * La classe InfraredGlasses représente les lunettes infrarouges
 * Leur utilisation permets de voir à travaers les murs,
 * voir les zones adjacentes lorsque les portes sont fermées 
 */
public class InfraredGlasses extends Equipment {

	/**
     * Constructeur de la classe AidKit
     */
    public InfraredGlasses() {
        // Appel au constructeur de la classe mere
        super("des lunettes infrarouges") ;
    }
    
    /**
     * méthode use pour utiliser les lunettes infrarouges
     * Permet au joeur de voir si il y'a des acteurs qui se trouve à proximité.
     */
    public void use(Town town, Survivor sur) {
        System.out.println();

        Area area=null;
        if (town.getBoard()[sur.getPositionX()][sur.getPositionY()+1] instanceof Area){
            area = (Area) town.getBoard()[sur.getPositionX()+1][sur.getPositionY()];
            System.out.println("Voici les acteurs que vous voyez à travers le mur du bas : ");
            System.out.println("Noms des Survivants qui s'y trouve: ");
            String res="Il y'a : ";
            for (Survivor survivor : area.getSurvivors()){
                res += survivor.getName() + " ";
            }
            if (area.getSurvivors().isEmpty()){
                System.out.println("Il n'y a aucun survivant dans cette zone.");
            }
            else {
                System.out.println(res);
            }

            System.out.println("Noms des Zombies qui s'y trouve : ");

            for (Zombie zombie : area.getZombies()){
                res += zombie.getName() + " ";
            }
            if (area.getZombies().isEmpty()){
                System.out.println("Il n'y a aucun zombie dans cette zone.");
            }
            else {
                System.out.println(res);
            }

          

        }
        System.out.println();

        if (town.getBoard()[sur.getPositionX()][sur.getPositionY()-1] instanceof Area){
            area = (Area) town.getBoard()[sur.getPositionX()+1][sur.getPositionY()];
            System.out.println("Voici les acteurs que vous voyez à travers le mur de gauche : ");
            System.out.println("Noms des Survivants qui s'y trouve: ");
            String res="Il y'a : ";
            for (Survivor survivor : area.getSurvivors()){
                res += survivor.getName() + " ";
            }
            if (area.getSurvivors().isEmpty()){
                System.out.println("Il n'y a aucun survivant dans cette zone.");
            }
            else {
                System.out.println(res);
            }

            System.out.println("Noms des Zombies qui s'y trouve : ");

            for (Zombie zombie : area.getZombies()){
                res += zombie.getName() + " ";
            }
            if (area.getZombies().isEmpty()){
                System.out.println("Il n'y a aucun zombie dans cette zone.");
            }
            else {
                System.out.println(res);
            }

          

        }
        System.out.println();

        if (town.getBoard()[sur.getPositionX()-1][sur.getPositionY()] instanceof Area){
            area = (Area) town.getBoard()[sur.getPositionX()+1][sur.getPositionY()];
            System.out.println("Voici les acteurs que vous voyez à travers le mur du haut : ");
            System.out.println("Noms des Survivants qui s'y trouve: ");
            String res="Il y'a : ";
            for (Survivor survivor : area.getSurvivors()){
                res += survivor.getName() + " ";
            }
            if (area.getSurvivors().isEmpty()){
                System.out.println("Il n'y a aucun survivant dans cette zone.");
            }
            else {
                System.out.println(res);
            }

            System.out.println("Noms des Zombies qui s'y trouve : ");

            for (Zombie zombie : area.getZombies()){
                res += zombie.getName() + " ";
            }
            if (area.getZombies().isEmpty()){
                System.out.println("Il n'y a aucun zombie dans cette zone.");
            }
            else {
                System.out.println(res);
            }

          

        }
        System.out.println();

        if (town.getBoard()[sur.getPositionX()+1][sur.getPositionY()] instanceof Area){
            area = (Area) town.getBoard()[sur.getPositionX()+1][sur.getPositionY()];
            System.out.println("Voici les acteurs que vous voyez à travers le mur du bas : ");
            System.out.println("Noms des Survivants qui s'y trouve: ");
            String res="Il y'a : ";
            for (Survivor survivor : area.getSurvivors()){
                res += survivor.getName() + " ";
            }
            if (area.getSurvivors().isEmpty()){
                System.out.println("Il n'y a aucun survivant dans cette zone.");
            }
            else {
                System.out.println(res);
            }

            System.out.println("Noms des Zombies qui s'y trouve : ");

            for (Zombie zombie : area.getZombies()){
                res += zombie.getName() + " ";
            }
            if (area.getZombies().isEmpty()){
                System.out.println("Il n'y a aucun zombie dans cette zone.");
            }
            else {
                System.out.println(res);
            }

          

        }


        
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

    
}