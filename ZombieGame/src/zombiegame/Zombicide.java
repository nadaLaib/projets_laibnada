package zombiegame;

public class Zombicide {

	public static void main(String[] args) {
		if (args.length==3){ // Vérifie s'il y'a bien 3 arguments

            if ((Integer.parseInt(args[0])== Integer.parseInt(args[1]) )&& Integer.parseInt(args[0])>4 && Integer.parseInt(args[0])%3==2){ // si la longueur et la largeur sont égaux, largeur%3==2 et sont plus grand que 4x4 car le tableau minimal est de 5x5

                Town2 game = new Town2(Integer.parseInt(args[0])); 

                game.remplissageTableau();  // Affichage du plateau de jeu selon les dimensions choisi par l'utilisateur en 1er argument  (car notre ville doit obligatoirement avoir la meme hauteur et largeur)
            
                game.afficherTableau(); // Contour du plateau


                game.placeSurvivors2(Integer.parseInt(args[2])); // Place les survivants selon le nombre survivants que l'utilisateur à choisi en 3eme argument

                game.placeZombies(); // Place les zombies dans la ville.
            
                game.play(); // Lancement du jeu
                
         }
            
        }

        else{
        	System.out.println("Usage: java -jar Zombicide.jar <largeur_plateau> <hauteur_plateau> <nombre_joueurs>");
        	System.out.println("PS : La hauteur et la largeur du plateau doit etre la meme");
            System.out.println("Exemple : java -jar Zombicide.jar 5 5 8");
       
        }
        
        }
    }


            
    