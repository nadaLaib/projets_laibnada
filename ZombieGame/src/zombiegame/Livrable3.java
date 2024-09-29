package zombiegame;

public class Livrable3 {
  public static void main(String[] args) {
	  

	  Town game = new Town(); // Création d'un plateau : une ville 
    
    
    game.setDimensionsFromUser();  // Demander à l'utilisateur les dimensions qu'il souhaite appliquer à sa ville
    
    
    game.remplissageTableau();  // Affichage du plateau de jeu

    
    game.afficherTableau();      // Contour du plateau

    
  
    game.placeSurvivors(); // Place les survivors dans la ville.
    

    game.placeZombies(); // Place les zombies dans la ville.
    
        
    game.play();  // Lancement du jeu


      
  
  }
}
