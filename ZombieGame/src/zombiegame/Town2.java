
package zombiegame;


import zombiegame.Actors.*;


/**
 * Creer la ville pour le jeu classique : Zombicide.
 * 
 */
public class Town2 extends Town {

     /**
     * Construit une nouvelle ville avec les dimensions spécifiées par choix.
     * Les dimensions du plateau sont définies en fonction du choix donné.
     * @param choice Le choix spécifié pour définir les dimensions du plateau.
     */
    public Town2 (int choice){
        super();
        setDimensions(choice);
    }


    /**
    * Place les survivant au carrefour principal du plateau, si il y'a pas de carrefour principale alors les survivants sont placé autour du batiment centrale (sur une même zone).
    */

    public void placeSurvivors2(int reponse_nombreSurvivants){

        int middle_x= this.getWidth()/2;
        int middle_y= this.getWidth()/2;
        
 
        for (int i=1;i<reponse_nombreSurvivants+1; i++){
            String nomsurvivant = "survivant_" +i;
            if (this.getBoard()[middle_x][middle_y] instanceof Room){
                Survivor survivor = new Survivor(nomsurvivant,middle_x+1, middle_y,this);
                this.getBoard()[middle_x +1][middle_y].ajouterSurvivor(survivor);
                this.getSurvivors().add(survivor);  
            }
            else{
                Survivor survivor =new Survivor(nomsurvivant,middle_x,middle_y,this);
                this.getBoard()[middle_x][middle_y].ajouterSurvivor(survivor);
                this.getSurvivors().add(survivor); 
            }
        
        } 
    }

}
