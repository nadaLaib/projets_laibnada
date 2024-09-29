package zombiegame;

import zombiegame.Actors.*;

public class Door{
    public boolean porte_gauche; // État de la porte gauche
    public boolean porte_droite; // État de la porte droite
    public boolean porte_haut; // État de la porte du haut
    public boolean porte_bas; // État de la porte du bas
    public Room room; // La pièce 
    

    public Door(Room room){
        this.room=room; // la pièce qui contient les 4 portes

        // les directions de ses 4 portes
        this.porte_gauche=false;
        this.porte_droite=false;
        this.porte_bas=false;
        this.porte_haut=false;
    }
    
    

    /**
     * Renvoie l'état de la porte gauche 
     * @return vrai si elle est ouverte, false sinon
     */
    public boolean getPorte_Gauche(){
        return this.porte_gauche;
    }

    /**
     * Ouvre la porte gauche
     */
    public void Ouvrir_Porte_Gauche(Survivor survivor){
        if (survivor.peut_ouvrir(this.room)){
            this.porte_gauche=true;
        }
    }
    
    /**
     * Verifie si la porte gauche est ouverte
     * @return vrai si la porte est ouverte sinon false
     */
    public boolean Porte_Gauche_ouverte(){
        return this.porte_gauche==true;
    }

    /**
     * Renvoie l'état de la porte haut 
     * @return vrai si elle est ouverte, false sinon
     */
    public boolean getPorte_Haut(){
        return this.porte_haut;
    }

    /**
     * Ouvre la porte droite
     */
    public void Ouvrir_Porte_Haut(Survivor survivor){
        if (survivor.peut_ouvrir(this.room)){
            this.porte_haut=true;
        }
    }

    /**
     * Verifie si la porte bas est ouverte
     * @return vrai si la porte est ouverte sinon false
     */
   
     public boolean Porte_Haut_ouverte(){
        return this.porte_haut==true;
    }

    /**
     * Renvoie l'état de la porte bas 
     * @return vrai si elle est ouverte, false sinon
     */
    public boolean getPorte_Bas(){
        return this.porte_bas;
    }

    /**
     * Ouvre la porte bas
     */
    public void Ouvrir_Porte_Bas(Survivor survivor){
        if (survivor.peut_ouvrir(this.room)){
            this.porte_bas=true;
        }
    }

    /**
     * Verifie si la porte bas est ouverte
     * @return vrai si la porte est ouverte sinon false
     */
   
     public boolean Porte_Bas_ouverte(){
        return this.porte_bas==true;
    }

    /**
     * Renvoie l'état de la porte droite 
     * @return vrai si elle est ouverte, false sinon
     */
    public boolean getPorte_Droite(){
        return this.porte_droite;
    }

    /**
     * Ouvre la porte droite
     */
    public void Ouvrir_Porte_Droite(Survivor survivor){
        if (survivor.peut_ouvrir(this.room)){
            this.porte_droite=true;
        }
    }

    /**
     * Verifie si la porte droite est ouverte
     * @return vrai si la porte est ouverte sinon false
     */
   
    public boolean Porte_Droite_ouverte(){
        return this.porte_droite==true;
    }

    /**
     * Verifie si au moins une des porte est ouverte
     * @return vrai si au moins une des porte est ouverte, sinon false
     */
    public boolean Une_Porte_Est_Ouverte(){
        return getPorte_Gauche() || getPorte_Bas() || getPorte_Droite() || getPorte_Haut();
    }

    

}