import meteoDataByCity from '../data/meteo-data.js';
import { useState } from "react";
import { useEffect } from "react";
import React from 'react';
import star_off from '../assets/images/star_off.png';
import star_on from '../assets/images/star_on.png';


/**
 * Liste déroulante contenant les villes. Une etoile à coté permet de mettre la ville en favori si l'utilisateur le souhaite
 * @param {*} selectedCity La ville selectionné
 * @param {*} favoriteCity La ville favorite
 * @returns un element select contenant les villes ainsi qu'une option favori
 */
const SelectCity = ({selectedCity, setSelectedCity,setFavoriteCity, favoriteCity})=>{
    
    const [isFavorite, setIsFavorite] = useState(false);

    // met à jour l'étoile en fonction de la ville sélectionné
    useEffect(()=> {
        setIsFavorite(selectedCity === favoriteCity);
    },[selectedCity, setFavoriteCity]);

    
    return(
    <>
    <div className="selectCity">
    <select value= {selectedCity} onChange= {(evt)=> setSelectedCity(evt.target.value)} > {/**Valeur selectionné et mis à jour */}
        {meteoDataByCity.map((cityData)=> (<option key={cityData.city} value={cityData.city}>{cityData.city}</option>))} {/**les options du select sont les noms de ville*/}
    </select>

    {/**Change l'état de la photo favori en fonction de isFavori. */}
    <img src={isFavorite? star_on : star_off} onClick={() => {
        setIsFavorite(!isFavorite);
        setFavoriteCity(selectedCity);
    }}
    />
    </div>

    </>
    
    );
};

  export default SelectCity;