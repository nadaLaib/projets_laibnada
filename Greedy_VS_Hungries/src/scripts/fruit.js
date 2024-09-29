import ananasImgSrc from '../scripts/assets/images/ananas.png'
import citronImgSrc from '../scripts/assets/images/citron.png'
import pommeImgSrc from '../scripts/assets/images/pomme.png'

import Hungrie from './hungrie';
export default class Fruit{


    /**
     * 
     * @param {HTMLCanvasElement} canvas 
     * @param {} context 
     */
    constructor(canvas,context){

        this.canvas=canvas;
        this.context=context;

        const images = [ananasImgSrc, citronImgSrc, pommeImgSrc];
        this.image = this.#createImage(images[Math.floor(Math.random()*images.length)]);
        this.x = Math.random()*(canvas.width-this.image.width);
        this.y = Math.random()*(canvas.height-this.image.height);

        
    }

    /**
     * Renvoie la largeur de l'image
     */
    get width() {
        return this.image.width;
    }
    
    /**
     * Renvoie la hauteur de l'image
     */
    get height() {
        return this.image.height;
    }

    /* crée l'objet Image à utiliser pour dessiner un fruit */
    #createImage(imageSource) {
        const newImg = new Image();
        newImg.src = imageSource;
        return newImg;
    }
   
    /* draw this actor mobile, using the given drawing 2d context */
    draw(context) {
        context.drawImage(this.image,this.x,this.y);
    }

    /**
    * Renvoie un boolean qui indique si il y'a eu une collision entre le greedy et le parametre.
    * @param {Greedy} greedy 
    * @returns True si il y'a eu une collision sinon false
    */
    collisionWith(greedy){

        const A1_x = this.x;
        const A1_y = this.y;
        const A1prime_x = greedy.x;
        const A1prime_y = greedy.y;
    
        const P1_x = Math.max(A1_x,A1prime_x);
        const P1_y = Math.max(A1_y,A1prime_y);
    
        const A2_x = this.x + this.width;
        const A2_y = this.y + this.height;
        const A2prime_x = greedy.x + greedy.width;
        const A2prime_y = greedy.y + greedy.height;
    
        const P2_x = Math.min(A2_x, A2prime_x);
        const P2_y = Math.min(A2_y, A2prime_y);
    
        if (P1_x < P2_x && P1_y < P2_y){
            
          return true;
        }
        else {
          return false;
        }
       
    }
    
    

}

