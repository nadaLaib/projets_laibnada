package zombiegame.SpecialRoom;

import java.util.*;

import zombiegame.*;

/**
 * La classe ContinentalHotel représente un hôtel dans le jeu. Elle étend la classe Room.
 * L'hôtel est une zone spécifique dans la ville où les joueurs peuvent interagir.
 */
public class ContinentalHotel extends Room {
	/**
     * Constructeur par défaut de la classe ContinentalHotel.
     * Initialise une instance d'hôtel avec le type "ContinentalHotel".
     */
	public ContinentalHotel(){ 
		
		super();
	}
	/**
     * Redéfinition de la méthode toString pour représenter visuellement l'hôtel dans le jeu.
     * @return Une chaîne de caractères représentant l'hôtel.
     */
    @Override
	public String toString() {
        if (this.survivors.isEmpty() && this.zombies.isEmpty()){
            return "🅷";
        }
		else if (!this.zombies.isEmpty()){
			return "\u001B[34m☠\u001B[0m";
		}
        else{
            return "\u001B[33m𖡌\u001B[0m";
        } 
    }
	/**
     * Place un hôtel aléatoirement sur le plateau de la ville.
     * @param town La ville dans laquelle placer l'hôtel.
     */
	public void placerHotel(Town town) {
    	Random random = new Random();
		boolean hotel_present = false;
		for (int x=0; x<town.getWidth();x++){
			for(int y=0;y<town.getHeight();y++){
				if(town.getBoard()[x][y] instanceof zombiegame.SpecialRoom.ContinentalHotel){
					hotel_present=true;
					break;
				}
			}
			if (hotel_present){
				break;
			}
			
		}
		if(!hotel_present){
			while (true) {
				int hotelWidth = random.nextInt(town.getWidth());
				int hotelHeight = random.nextInt(town.getHeight());
				if ((town.getBoard()[hotelWidth][hotelHeight]) instanceof zombiegame.Room) {
					if (!((town.getBoard()[hotelWidth][hotelHeight]) instanceof zombiegame.SpecialRoom.Pharmacy)){
						town.getBoard()[hotelWidth][hotelHeight] = new ContinentalHotel();
						break;
						}
				}
			}
		}
	}
}
