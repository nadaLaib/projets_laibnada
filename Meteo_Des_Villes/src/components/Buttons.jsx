import React from "react";

/**
 * Bouttons representant les types de données
 * @param {*} changeData fonction qui met à jour les données
 * @returns des bouttons représentant les types de données
 */
const Buttons = ({changeData}) => {
    return(
        <>
        <div className="buttonsType">   
        <button className="buttonType" onClick={()=> changeData("temp_min","Température minimale (°C)")}>Température minimale (°C)</button>
            <button className="buttonType" onClick={()=> changeData("temp_max","Température maximale (°C)")}>Température maximale (°C)</button>
            <button className="buttonType" onClick={()=> changeData("pluviometrie","Pluviométrie (mm)")}>Pluviométrie (mm)</button>
            <button className="buttonType" onClick={()=> changeData("ensoleillement","Ensoleillement (jours)")}>Ensoleillement (jours)</button>
            <button className="buttonType" onClick={()=> changeData("jours_gel","Jours de gel (jours)")}>Jours de gel (jours)</button>            
        </div> 
        </>
    );
}

export default Buttons;