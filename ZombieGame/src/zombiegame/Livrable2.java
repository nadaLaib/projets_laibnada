package zombiegame;

public class Livrable2 {

    public static void main(String[] args) {
    	
      Town game = new Town(); // Création d'un plateau : une ville 
      
      
      game.setDimensionsFromUser();  // Demander à l'utilisateur les dimensions qu'il souhaite appliquer à sa ville
      
      
      game.remplissageTableau();  // Affichage du plateau de jeu
      
      
      
      game.afficherTableau();   // Contour du plateau

      
      game.placeSurvivors();  // Placer les survivants

       


    }

}