package zombiegame;

public abstract class Actor {
    //Le nom de l'acteur
    protected String name;
    //Les points de vie de l'acteur
    protected int healthPoints;
    //La position en X de l'acteur sur la carte
    protected int positionX;
    //La position en Y de l'acteur sur la carte
    protected int positionY;
    
    
    /**
     * Constructeur de la classe Actor.
     * @param name Le nom de l'acteur.
     * @param positionX La position en X de l'acteur sur la carte.
     * @param positionY La position en Y de l'acteur sur la carte.
     */
    public Actor(String name, int positionX, int positionY) {
        this.name = name;
        this.healthPoints = 5;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    
    /**
     * Vérifie si l'acteur est mort 
     * @return true si l'acteur est mort (ses points de vie sont inférieurs ou égaux à 0), sinon false.
     */
    public boolean isDead() {
        return healthPoints <= 0;
    }
    

    /**
     * Modifie la position de l'acteur.
     * @param x la nouvelle position X
     * @param y la nouvelle position Y
     */
    public void setPosition(int x, int y){
        this.positionX=x;
        this.positionY=y;
    }

    
    /**
	  * Obtient la position en abscisse (X) de l'acteur sur le plateau de jeu.
	  *
	  * @return La position en abscisse (X) de l'acteur.
	  */
	 public int getPositionX() {
        return this.positionX;
    }
	 
    
    /**
     * Obtient la position en ordonnée (Y) de l'acteur sur le plateau de jeu.
     *
     * @return La position en ordonnée (Y) de l'acteur.
     */
    public int getPositionY() {
        return this.positionY;
    }

    
    
    /**
    * Réduit les points de vie de l'acteur en fonction des dommages infligés.
    * @param damage Le montant de dommages infligés à l'acteur.
    */
    public void takeDamage(int damage) {
        healthPoints -= damage;
        if (healthPoints <= 0) {
    }
}
    
    
    /**
     * Obtient le nombre de points de vie de l'acteur.
     *
     * @return Le nombre de points de vie de l'acteur.
     */
    public int getHealthPoints() {
        return this.healthPoints;
    }

}