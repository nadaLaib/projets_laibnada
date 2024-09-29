package zombiegame.SpecialStreet;

import zombiegame.Street;
import zombiegame.Town;

/**
 * La classe Sewer représente les égouts dans le jeu zombie.
 * Elle permet de placer les bouches d'égouts sur le plateau de la ville.
 */

public class Sewer extends Street {

	/**
	 * Constructeur d'une bouche d'égout
	 */
	public Sewer(){
		super();
	}

	/**
     * Renvoie une représentation textuelle des égouts.
     * @return La lettre "B" pour représenter les égouts
     */
	@Override
	public String toString() {
		if(this.zombies.isEmpty()){
			return "\u001B[31m𝗢\u001B[0m";
		}
        if (this.survivors.isEmpty()){
			return "☠";
        }
		return "\u001B[33m𖡌\u001B[0m";
	}


	/**
	*  placer les bouches d'égouts
	*  @param town La ville où placer les bouches d'égouts
	*/
	public void placerBouchesEgouts(Town town) {
		// Parcourir les bords horizontaux du plateau
		for(int x = 0; x < town.getWidth() ; x++) {
			if (x == 0 || x == town.getWidth() - 1) {
				// Si c'est le bord gauche ou droit
				for (int y = 0 ; y < town.getHeight() ; y++) {
					// Si la case est une rue, la remplacer par une bouche d'égout
					if (town.getBoard()[x][y] instanceof zombiegame.Street) {
						town.getBoard()[x][y] = new Sewer();
					}
				}
			}
		}
	    /*Parcourir les bords verticaux du plateau */
		for(int y = 0; y < town.getHeight() ; y++) {
			if (y == 0 || y == town.getHeight() - 1) {
				for (int x = 0 ; x < town.getWidth() ; x++) {
					if (town.getBoard()[x][y] instanceof zombiegame.Street) {
						town.getBoard()[x][y] = new Sewer();
					}
				}
			}
		}
	}

	/**
	 * Place une bouche d'égout au centre pour une ville 5x5
	 * @param town la ville ou on placera cette bouche d'égout
	 */
	public void placerBoucheEgout_auCentre(Town town){
		int x = town.getHeight()/2;
		int y = town.getWidth()/2;
		town.getBoard()[x][y] = new Sewer();	
		}

		
		
	}

	