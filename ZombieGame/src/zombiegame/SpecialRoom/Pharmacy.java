package zombiegame.SpecialRoom;
import zombiegame.*;
import zombiegame.Equipments.*;

import java.util.*;

/**
 * La classe Pharmacy représente une pharmacie dans le jeu zombie.
 * Elle hérite de la classe Room et représente une pièce spéciale.
 */
public class Pharmacy extends Room {
	/**
     * Constructeur par défaut pour une pharmacie.
     * Initialise le type de la pièce à "Pharmacy".
     */
	public Pharmacy (){ 
		super();
	}
	/**
     * Représentation textuelle d'une pharmacie.
     * @return Une lettre 'P' représentant une pharmacie
     */
	@Override
	public String toString() {
        if (this.survivors.isEmpty() && this.zombies.isEmpty()){
            return "🅿";
        }
		else if (!this.zombies.isEmpty()){
			return "\u001B[34m☠\u001B[0m";
		}
        else{
            return "\u001B[33m𖡌\u001B[0m";
        } 
    }
	/**
     * Place une pharmacie sur le plateau de jeu.
     * @param town La ville dans laquelle placer la pharmacie
     */
	public void placerPharmacy(Town town) {
    	Random random = new Random();
		boolean pharmacy_present = false;
		for (int x=0; x<town.getWidth();x++){
			for(int y=0;y<town.getHeight();y++){
				if(town.getBoard()[x][y] instanceof zombiegame.SpecialRoom.Pharmacy){
					pharmacy_present=true;
					break;
				}
			}
			if (pharmacy_present){
				break;
			}
			
		}
		if(!pharmacy_present){
			while (true) {
				int pharmacyWidth = random.nextInt(town.getWidth());
				int pharmacyHeight = random.nextInt(town.getHeight());
				if ((town.getBoard()[pharmacyWidth][pharmacyHeight] instanceof Room)) {
					town.getBoard()[pharmacyWidth][pharmacyHeight] = new Pharmacy();
					break;
				}
			}
		}
	}
	/**
     * Génère des fioles de guérison seulement puisque c'est une pharmacie
     */
    public void generateRandomEquipments() {
    	HealingPotion healingPotion = new HealingPotion();
        this.ajouterEquipment(healingPotion);
        
    }

}
