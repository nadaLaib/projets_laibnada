
// la source de l'image à utiliser pour la balle
import greedyImgSrc from '../images/greedy64.png';
import Mobile from './mobile';
import KeyManager from './keyManager';

/* TYPE Greedy */
export default class Greedy extends Mobile {

	static GREEDY_WIDTH = 48;

  /**
   * Constructeur du Greedu
   * @param {int} x 
   * @param {int} y 
   * @param {int} deltaX 
   * @param {int} deltaY 
   */
  constructor(x,y,deltaX=3,deltaY=-2) {
    super(x,y);
    this.deltaX=deltaX;
    this.deltaY=deltaY;
    this.image = this.createImage(greedyImgSrc);
  }

  /* crée l'objet Image à utiliser pour dessiner greedy */
  createImage(imageSource) {
	const newImg = new Image();
  	newImg.src = imageSource;
  	return newImg;
  }
  
  /**
   * Renvoie la largeur de l'image
   */
  get width() {
    return this.image.width;
  }
  /**
   * Renvoie la hauteur de limage
   */
  get height() {
    return this.image.height;
  }

  /**
   * deplacement vers la gauche
   */
  moveLeft() {              
    this.deltaX = this.deltaX - 10;   // le déplacement se fera vers la gauche, par pas de 10px
  }

  /**
   * deplacement vers la droite
   */
  moveRight() {
      this.deltaX = this.deltaX + 10;   // le déplacement se fera vers la droite, par pas de 10px
  }

  /**
   * deplacement vers le haut
   */
  moveDown(){
      this.deltaY=this.deltaY + 10; // le déplacement se fera vers le haut, par pas de 10px
  }

  /**
   * deplacement vers le bas
   */
  moveUp(){
      this.deltaY=this.deltaY - 10; // le déplacement se fera vers le bas, par pas de 10px
  }

  /**
   * arret
   */
  stopMoving() {
      this.deltaX = 0;
      this.deltaY = 0;
  }

  /**
   * deplace dans les limites de *box
   * @param {} box 
   */
  move(box) {  // déplace sans sortir des limites de *box*
      this.x = Math.max(0, Math.min(box.width - this.width, this.x + this.deltaX));
      this.y = Math.max(0, Math.min(box.height - this.height, this.y + this.deltaY));

  }

  handleMoveKeys(keyManager) {
      this.stopMoving();    // on réinitialise les déplacements
      if (keyManager.left)  // touche flèche gauche pressée ?
        this.moveLeft();
      if (keyManager.right) // touche flèche droite pressée ?
        this.moveRight();
      if (keyManager.down) // touche flèche bas pressée ?
        this.moveDown();
      if (keyManager.up) // touche flèche haut pressée ?
        this.moveUp();

  }


}
