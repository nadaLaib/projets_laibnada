package zombiegame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import zombiegame.Actors.*;

public class TownTest {
    @Test 
    public void testSetDimensions_Choice1() {
        Town town = new Town();
        
        town.setDimensions(1);
        assertEquals(5, town.getWidth());
        assertEquals(5, town.getHeight());
    }
   

    /**
     * Test si les coordonnées pour se déplacé son valide, seul les position droite gauche haut bas le sont.
     */
    @Test
    public void testValideDimension(){
        Town town = new Town(); // créer une ville 5x5

        Survivor survivor = new Survivor("s1",2,2,town); // survivor de position x=2 et y=2

        for (int x=0; x<town.getWidth(); x++){
            for (int y=0; y<town.getHeight(); y++){

                // uniquement ces 4 positions sont valides pour survivor (droite, gauche, haut, bas)
                if ((x==2 && y==3) || (x==3 && y==2) || (x==1 && y==2) || (x==2 && y==1) ){
                    assertTrue(town.validePosition(survivor,x,y));
                }
                else { // toutes les autres positions sont incorrect.
                    assertFalse(town.validePosition(survivor,x,y));
                }
            }
        }


        // On verifie avec le survivor 2 si les positions qui se situe hors du plateau sont bien fausse
        Survivor survivor2 = new Survivor("s2",0,1,town); // survivor de position x=0 et y=1
        for (int x=0; x<town.getWidth(); x++){
            for (int y=0; y<town.getHeight(); y++){

                // uniquement ces 3 positions sont valides pour survivor2 car la 4eme fait sortir du plateau(droite, gauche, haut, bas)
                if ((x==1 && y==1) || (x==0 && y==0) || (x==0 && y==2) ){
                    assertTrue(town.validePosition(survivor2,x,y));
                }
                else { // toutes les autres positions sont incorrect.
                    assertFalse(town.validePosition(survivor2,x,y));
                }
            }
        }


        // Generalement, on verifie si pour chaque position du survivor3 ses seuls position valides sont gauche,droite,haut bas avec un pas de 1
        // Si c'est faux c'est soit qu'il sort du plateau soit qu'il fait un pas à la diagonale, soit qu'il fait un pas plus grand que 1.
        for (int x=0; x<town.getWidth(); x++){
            for (int y=0; y<town.getHeight(); y++){
                Survivor survivor3 = new Survivor("s3",x,y,town);
               
                if (x>0){
                    assertTrue(town.validePosition(survivor3,x-1,y)); // vrai, le survivor peut aller a gauche 
                }
                else{
                    assertFalse(town.validePosition(survivor,-1,y)); // faux, il sort à gauche du plateau
                }

                if (x<town.getWidth()-1){
                    assertTrue(town.validePosition(survivor3,x+1,y)); // vrai, le survivor peut aller a droite 
                }
                else{
                    assertFalse(town.validePosition(survivor,town.getWidth(),y)); // faux, il sort à droite du plateau
                }

                if (y>0){
                    assertTrue(town.validePosition(survivor3,x,y-1)); // vrai, le survivor peut aller en haut
                }
                else{
                    assertFalse(town.validePosition(survivor,x,-1)); // faux, il sort en haut du plateau
                }


                if (y<town.getHeight()-1){
                    assertTrue(town.validePosition(survivor3,x,y+1)); // le survivor peut aller en bas
                }
                else{
                    assertFalse(town.validePosition(survivor,x,town.getHeight())); // faux, il sort en bas du plateau
                }

                boolean gauche =(x>0) ? town.validePosition(survivor3, x-1, y) : false;
                boolean droite =(x<town.getWidth()-1) ? town.validePosition(survivor3, x+1, y) : false;
                boolean haut =(y>0) ? town.validePosition(survivor3, x, y-1) : false;
                boolean bas =(y<town.getHeight()-1) ? town.validePosition(survivor3, x, y+1) : false;

                // toutes les autres position : les déplacements à la diagonals ou les déplacements qui font un pas + grand que 1 sont faux
                assertFalse(town.validePosition(survivor3, x, y) && !gauche && !droite && !haut && !bas); 
                }
            }
        }
    
    @Test
    public void testHasHotel() {
        Town town = new Town();
        town.setDimensions(2);
        town.remplissageTableau();
        
        assertTrue(town.hasHotel());
    }

    @Test
    public void testHasPharmacy() {
        Town town = new Town();
        town.setDimensions(2);
        town.remplissageTableau();
        
        assertTrue(town.hasPharmacy());
    }

    @Test
    public void testHasSewer() {
        Town town = new Town();
        town.setDimensions(2);
        town.remplissageTableau();
        
        assertTrue(town.hasSewer());
    }

    }
    
