package zombiegame;

import java.util.ArrayList;
import java.util.Random;

import zombiegame.Equipments.*;
import zombiegame.Actors.*;
import zombiegame.Equipments.Weapons.*;

/**
 * La classe Room représente les pièces dans le jeu zombie.
 */
public class Room extends Area {
    protected ArrayList<Equipment> equipements; // Liste d'équipement dans la pièce
    public Door door; // Porte


    protected String roomType;
    /**
     * Constructeur par défaut pour une pièce normale.
     * Initialise le type de pièce à "NormalRoom".
     */
    public Room() {
        this.roomType = "NormalRoom";
        this.door = new Door(this);
        this.equipements = new ArrayList<Equipment>();
        generateRandomEquipments();
    }
   /**
     * Constructeur pour une pièce avec un type spécifié.
     * @param roomType Le type de la pièce (p/H)
     */
    public Room(String roomType) {
        this.roomType = roomType;
        this.equipements = new ArrayList<Equipment>();

    }
     /**
     * Obtient le type de la pièce.
     * @return Le type de la pièce
     */
    public String getRoomType() {
        return roomType;
    }
    /**
     * Définit le type de la pièce.
     * @param roomType Le nouveau type de la pièce
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    /**
     * Renvoie une représentation textuelle de la pièce.
     * @return Une lettre représentant une pièce
     */
    @Override
    public String toString() {
        if (this.survivors.isEmpty() && this.zombies.isEmpty()){
            return "\u001B[34m🅁\u001B[0m";
        }
        else if(!this.zombies.isEmpty()){
            return "\u001B[34m☠\u001B[0m";
        }
        
        else{
            return "\u001B[33m𖡌\u001B[0m";
        }
    }

    /**
     * Renvoie la liste des équipements présents dans la pièce.
     * @return La liste des équipements présents dans la pièce.
     */
    public ArrayList<Equipment> getEquipment() {
    	return this.equipements;
    }
    
    /**
     * Ajoute un équipement à la pièce.
     * @param equip L'équipement à ajouter à la pièce.
     */
    public void ajouterEquipment(Equipment equip) {
    	this.equipements.add(equip);
    }
    
    /**
     * Supprime un équipement de la pièce.
     * @param equip L'équipement à supprimer de la pièce.
     */

    public void removeEquipment (Equipment equip) {
    	this.equipements.remove(equip);
    }

    /**
     * Obtient la classe Door de la room
     */
    public Door getDoor(){
        return this.door;
    }
    
    /**
     * Ouvre la porte gauche de la room.
     * Si il y'a une room à sa gauche alors la porte droite de la room à sa gauche s'ouvre en consequence
     */
    public void room_ouvrir_porte_gauche(Town town,Survivor survivor){
        int room_x=-1;
        int room_y=-1;
        this.door.Ouvrir_Porte_Gauche(survivor); // ouvre la porte gauche
        for (int x=0;x<town.getWidth();x++){
            for (int y=0;y<town.getHeight();y++){
                if (town.getBoard()[x][y]==this){
                    // recupère les coordonnées de cet room
                    room_x=x;
                    room_y=y;
                }
            }
        }  
        if (town.getBoard()[room_x-1][room_y] instanceof Room){ // si une room se trouve à sa gauche
            Room room_a_gauche = (Room) town.getBoard()[room_x-1][room_y];
            room_a_gauche.getDoor().Ouvrir_Porte_Droite(survivor); // ouvre la porte droite de la room qui se trouve à sa gauche
        }
        
        
    }

    /**
     * Ouvre la porte droite de la room.
     * Si il y'a une room à sa droite alors la porte gauche de la room à sa droite s'ouvre en consequence
     */
    public void room_ouvrir_porte_droite(Town town, Survivor survivor){
        int room_x=-1;
        int room_y=-1;
        this.door.Ouvrir_Porte_Droite(survivor); // ouvre la porte droite
        for (int x=0;x<town.getWidth();x++){
            for (int y=0;y<town.getHeight();y++){
                if (town.getBoard()[x][y]==this){
                    // recupère les coordonnées de cet room
                    room_x=x;
                    room_y=y;
                }
            }
        }  
        if (town.getBoard()[room_x+1][room_y] instanceof Room){ // si une room se trouve à sa droite
            Room room_a_droite = (Room) town.getBoard()[room_x+1][room_y];
            room_a_droite.getDoor().Ouvrir_Porte_Gauche(survivor); // ouvre la porte gauche de la room qui se trouve à sa gauche
        }
    }
    
    /**
     * Ouvre la porte haut de la room.
     * Si il y'a une room au dessus d'elle alors la porte bas de la room au dessus d'elle s'ouvre en consequence
     */
    public void room_ouvrir_porte_haut(Town town,Survivor survivor){
        int room_x=-1;
        int room_y=-1;
        this.door.Ouvrir_Porte_Haut(survivor); // ouvre la porte haut
        for (int x=0;x<town.getWidth();x++){
            for (int y=0;y<town.getHeight();y++){
                if (town.getBoard()[x][y]==this){
                    // recupère les coordonnées de cet room
                    room_x=x;
                    room_y=y;
                }
            }
        }  
        if (town.getBoard()[room_x][room_y+1] instanceof Room){ // si une room se trouve au dessus
            Room room_au_dessus = (Room) town.getBoard()[room_x][room_y+1];
            room_au_dessus.getDoor().Ouvrir_Porte_Bas(survivor); // ouvre la porte bas de la room qui se trouve au dessus
        }
        
        
    }

    /**
     * Ouvre la porte bas de la room.
     * Si il y'a une room en dessous d'elle alors la porte haut de la room en dessous d'elle s'ouvre en consequence
     */
    public void room_ouvrir_porte_bas(Town town,Survivor survivor){
        int room_x=-1;
        int room_y=-1;
        this.door.Ouvrir_Porte_Bas(survivor); // ouvre la porte bas
        for (int x=0;x<town.getWidth();x++){
            for (int y=0;y<town.getHeight();y++){
                if (town.getBoard()[x][y]==this){
                    // recupère les coordonnées de cet room
                    room_x=x;
                    room_y=y;
                }
            }
        }  
        if (town.getBoard()[room_x][room_y-1] instanceof Room){ // si une room se trouve au dessus
            Room room_en_dessous = (Room) town.getBoard()[room_x][room_y-1];
            room_en_dessous.getDoor().Ouvrir_Porte_Haut(survivor); // ouvre la porte haut de la room qui se trouve en dessous
        }
        
        
    }
    
    /**
     * Génère aléatoirement des équipements et les ajoute à la pièce.
     * Le nombre d'équipements générés est aléatoire entre 1 et 3.
     * Les équipements générés sont choisis parmi une liste prédéfinie.
     * Les équipements sont ajoutés à la pièce selon leur type.
     */
    public void generateRandomEquipments() {
        Random random = new Random();
        int numEquipments = random.nextInt(3) + 1; // Génère un nombre aléatoire entre 1 et 3 inclusivement

        // Sélectionne un équipement en fonction du nombre aléatoire généré
        for (int i = 0; i < numEquipments; i++) {
            int equipIndex = random.nextInt(9); // Génère un nombre aléatoire entre 0 et 8
            switch (equipIndex) {
                case 0:
                    this.ajouterEquipment(new AidKit());
                    break;
                case 1:
                    this.ajouterEquipment(new InfraredGlasses());
                    break;
                case 2:
                    this.ajouterEquipment(new Map());
                    break;
                case 3:
                    this.ajouterEquipment(new MasterKey());
                    break;
                case 4:
                    this.ajouterEquipment(new Axe());
                    break;
                case 5:
                    this.ajouterEquipment(new ChainSaw());
                    break;
                case 6:
                    this.ajouterEquipment(new Crowbar());
                    break;
                case 7:
                    this.ajouterEquipment(new Gun());
                    break;
                case 8:
                    this.ajouterEquipment(new Rifle());
                    break;
            }
        }
    }
}