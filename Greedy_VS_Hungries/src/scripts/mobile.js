import Greedy from "./greedy";
export default class Mobile{

    /**
     * Constructeur de la classe Mobile
     * @param {int} x 
     * @param {int} y 
     */
    constructor(x,y) {
        this.x=x;
        this.y=y;

    }

    /* draw this actor mobile, using the given drawing 2d context */
    draw(context) {
    context.drawImage(this.image,this.x,this.y);
  }
    
  


}