
// importation de la classe Game.js
import Game from './game.js';
import Greedy from './greedy.js';
import Hungrie from './hungrie.js';
import Mobile from './mobile.js';


// mise en place de l'action des clics sur les boutons + les gestionnaires du clavier pour contrôler Greedy
const init = () => {
   const canvas = document.getElementById("playfield");
   const context =canvas.getContext("2d");
   const game = new Game(canvas);
   
   document.getElementById("stopAndStartGame").addEventListener("click", () => game.startAndStop()  );

   window.addEventListener('keydown', game.keyDownActionHandler.bind(game));

   window.addEventListener('keyup', game.keyUpActionHandler.bind(game));
 
}

window.addEventListener("load", init);

//
console.log('le bundle a été généré');
