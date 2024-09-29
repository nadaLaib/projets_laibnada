package zombiegame ;

/**
 * La classe Street représente les rues dans le jeu zombie.
 * Elle est utilisée pour remplir le plateau de jeu avec des rues.
 */
public class Street extends Area {
	// Lettre représentant une rue
	protected String letter;
	
	/**
     * Constructeur par défaut de la classe Street.
     * Initialise la lettre représentant une rue à "S".
     */
	public Street() {
		this.letter="S";
	}
	/**
     * Obtient la lettre représentant une rue.
     * @return La lettre représentant une rue
     */
	public String getLetter() {
		if (this.survivors.isEmpty() && this.zombies.isEmpty()){
			return "\u001B[37m"+this.letter+"\u001B[0m";
		}
		else if (!this.zombies.isEmpty()){
			return "\u001B[34m☠\u001B[0m";
		}
		return "\u001B[33m𖡌\u001B[0m";
	}
	/**
     * Renvoie une représentation textuelle de la rue.
     * @return La lettre représentant une rue
     */
	@Override
	public String toString() {
		return getLetter();
	}
	
}

    
    
   