import React from "react";

/**
 * Extension ajoutée : Une légende à été mis en place afin que l'utilisateur distingue clairement sa ville favorite de sa ville selectionné
 * @returns la légende avec les couleurs correspondante pour la ville favorite et la ville sélectionné
 */
const Legend=()=>{
    return(
        <div className="legend">
            <p className="legendtitre">Legend</p>
            <div className="legend-ville_selec">
                <div className="legendColor" style={{backgroundColor: '#49b58c'}}></div> 
                <div className="legendVilleSelec">Ville sélectionnée</div>
            </div>
            <div className="legend-ville_fav">
                <div className="legendColor" style={{backgroundColor: '#fbff00'}}></div>
                <div className="legendVilleFav">Ville favorite</div>
            </div>
        </div>
    );
}
export default Legend;
