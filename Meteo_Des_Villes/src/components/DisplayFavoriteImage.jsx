import React from 'react';
import { useState } from "react"
import lille from "../assets/images/Lille.jpg";
import bordeaux from "../assets/images/Bordeaux.jpg";
import brest from "../assets/images/Brest.jpg";
import clermontFerrand from "../assets/images/Clermont-Ferrand.jpg";
import genève from "../assets/images/Genève.jpg";
import nice from "../assets/images/Nice.jpg";
import paris from "../assets/images/Paris.jpg";
import strasbourg from "../assets/images/Strasbourg.jpg";
import toulouse from "../assets/images/Toulouse.jpg";

/**
 * Extension Ajouté : Possibilité à l'utilisateur d'afficher sa ville favorite s'il le souhaite
 * 
 * @param {*} favoriteCity la ville favorite de l'utilisateur
 * @returns Une phrase à coché pour demander à l'utilisateur s'il veut voir une photo de sa ville favorite
 *          si la case est coché : la photo s'affiche,
 *          si la case est décoché : la photo ne s'affiche plus
 */
const DisplayFavoriteImage = ({favoriteCity})=>{

  const [isChecked,setIsChecked]= useState(false); // par défaut, la case n'est pas coché

  /**
   * met à jour l'état pour coché
   */
  const ChangeFavoriteImage =()=>{
    setIsChecked(!isChecked);
  };

  /**
   * Renvoie la source de l'image en fonction de la ville favorite
   * @param {*} favoriteCity la ville favorite
   * @returns la source de l'image
   */
  const getImageForCity = (favoriteCity)=>{
    if (favoriteCity=="Lille"){
      return lille;
    }
    else if (favoriteCity=="Bordeaux"){
      return bordeaux;
    }
    else if (favoriteCity=="Brest"){
      return brest;
    }
    else if (favoriteCity=="Clermont-Ferrand"){
      return clermontFerrand;
    }
    else if (favoriteCity=="Genève"){
      return genève;
    }
    else if (favoriteCity=="Nice"){
      return nice;
    }
    else if (favoriteCity=="Paris"){
      return paris;
    }
    else if (favoriteCity=="Strasbourg"){
      return strasbourg;
    }
    else if (favoriteCity=="Toulouse"){
      return toulouse;
    }
    else{
      return null;
    }
  };

  return(
    <>
    <div>
    <label className= "admirer">
      🏆Admirer ma ville favorite🏆
        <input type="checkbox" checked={isChecked} onChange={ChangeFavoriteImage}/> {/**case à coché */}
      </label>
    </div>

    <div>
      {isChecked ? <img src={getImageForCity(favoriteCity)}  alt="image_photo_favori" style={{width:'400px', height:'300px'}}/> : null} {/**si la case est coché alors on affiche l'image de la ville favorite,sinon on l'affiche pas*/}
    </div>
    </>
  );
};

export default DisplayFavoriteImage;


