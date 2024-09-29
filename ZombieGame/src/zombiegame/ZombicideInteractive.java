package zombiegame;


/**
 * Lance le jeu Interactivement.
 * L'utilisateur à maintenant une immersion totale dans l'univers du Jeu.
 */
public class ZombicideInteractive {
  public static void main(String[] args) {
   
	  Town game = new Town(); // Création de la vile
   
	  game.setDimensionsFromUser();  // Demande à l'utilisateur la taille du plateau et le nombre de survivants
   
	  game.remplissageTableau();  // Affichage du plateau de jeu

    
    game.afficherTableau(); // Contour du plateau
  
    game.placeSurvivors(); // Place les survivors dans la ville.

    game.placeZombies(); // Place les zombies dans la ville.
        
    game.play(); // Lancement du jeu


      
  
  }
}
