import React from 'react';
import meteoDataByCity from '../data/meteo-data.js';

/**
 * Compare la ville selectionné et la ville favorite
 * @param {*} favoriteCity la ville favorite
 * @param {*} selectedCity la ville selectionné
 * @returns un tableau de comparaison 
 */
const DataComparison = ({favoriteCity,selectedCity})=>{

    const favoriteCityData = meteoDataByCity.find(c => c.city === favoriteCity);
    const selectedCityData = meteoDataByCity.find(c => c.city === selectedCity);

    // Je calcule les valeurs, les stock dans des variables afin de les afficher plus tard sur le tableau
    const somme_temp_minimal_favori= favoriteCityData.data.reduce((previous,el)=>previous+el.temp_min,0);
    const moyenne_temp_minimal_favori = (somme_temp_minimal_favori/12).toFixed(1);

    const somme_temp_maximal_favori= favoriteCityData.data.reduce((previous,el)=>previous+el.temp_max,0);
    const moyenne_temp_maximal_favori = (somme_temp_maximal_favori/12).toFixed(1);

    const somme_temp_minimal_selected= selectedCityData.data.reduce((previous,el)=>previous+el.temp_min,0);
    const moyenne_temp_minimal_selected = (somme_temp_minimal_selected/12).toFixed(1);

    const somme_temp_maximal_selected= selectedCityData.data.reduce((previous,el)=>previous+el.temp_max,0);
    const moyenne_temp_maximal_selected = (somme_temp_maximal_selected/12).toFixed(1);

    const somme_pluvimetrie_favori= (favoriteCityData.data.reduce((previous,el)=>previous+el.pluviometrie,0)).toFixed(1);
    const somme_pluvimetrie_selected= (selectedCityData.data.reduce((previous,el)=>previous+el.pluviometrie,0)).toFixed(1);

    const somme_temp_ensoleillement_favori= (favoriteCityData.data.reduce((previous,el)=>previous+el.ensoleillement,0)).toFixed(1);
    const somme_temp_ensoleillement_selected= (selectedCityData.data.reduce((previous,el)=>previous+el.ensoleillement,0)).toFixed(1);

    const somme_temp_jourDeGel_favori =(favoriteCityData.data.reduce((previous,el)=>previous+el.jours_gel,0)).toFixed(1);
    const somme_temp_jourDeGel_selected =(selectedCityData.data.reduce((previous,el)=>previous+el.jours_gel,0)).toFixed(1);

    return(
    
    <table className="tableComparison">
        <thead>
            <tr>
            <th></th>
            {/**entete*/}
            <th>Temp minimale</th>
            <th>Temp maximale</th>
            <th>Pluviométrie</th>
            <th>Ensoleillement</th>
            <th>Jours de gel</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                {/**Données pour la ville selectionné */}
                <td>{selectedCity}</td>
                <td>{moyenne_temp_minimal_selected}°C</td>
                <td>{moyenne_temp_maximal_selected}°C</td>
                <td>{somme_pluvimetrie_selected}mm</td>
                <td>{somme_temp_ensoleillement_selected}h</td>
                <td>{somme_temp_jourDeGel_selected}j</td>
            </tr>
            <tr>
                {/**Données pour la ville favori */}
                <td>{favoriteCity}</td>
                <td>{moyenne_temp_minimal_favori}°C</td>
                <td>{moyenne_temp_maximal_favori}°C</td>
                <td>{somme_pluvimetrie_favori}mm</td>
                <td>{somme_temp_ensoleillement_favori}h</td>
                <td>{somme_temp_jourDeGel_favori}j</td>
            </tr>

        </tbody>
    </table>

    );

};
  
export default DataComparison;