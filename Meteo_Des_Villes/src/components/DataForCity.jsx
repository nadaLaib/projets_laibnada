import React from 'react';
import meteoDataByCity from '../data/meteo-data.js';

/**
 * Affiche les données météo de la ville
 * @param {*} city  la ville
 * @returns un tableau contenant les données de la ville
 */
const DataForCity = ({city})=>{
  const cityData = meteoDataByCity.find(c=> c.city===city);

  return(
  <>
  <table className="table">

    <thead>
      <tr>
        <th></th>
        {cityData.data.map((data, index) => (<th i={index}>{data.pour}</th> ))} {/**on affiche le mois */}
      </tr>
    </thead>

    <tbody>
        <tr>
          <td>Temp minimale</td>
          {cityData.data.map(data=>(<td i={data.pour}>{data.temp_min}°C</td>))} {/*on affiche le temp_min pour chaque mois*/ }
        </tr>

        <tr>
          <td>Temp maximale</td>
          {cityData.data.map(data=>(<td i={data.pour}>{data.temp_max}°C</td>))} {/*on affiche le temp_max pour chaque mois*/ }
        </tr>

        <tr>
          <td>Pluviométrie</td>
          {cityData.data.map(data=>(<td i={data.pour}>{data.pluviometrie}mm</td>))} {/*on affiche la pluviometrie pour chaque mois*/ }
        </tr>

        <tr>
          <td>Ensoleillement</td>
          {cityData.data.map(data=>(<td i={data.pour}>{data.ensoleillement}h</td>))} {/*on affiche l'ensoleillement pour chaque mois*/ }
        </tr>

        <tr>
          <td>Jours de gel</td>
          {cityData.data.map(data=>(<td i={data.pour}>{data.jours_gel}j</td>))} {/*on affiche le nombres de jours_gel pour chaque mois*/ }
        </tr>
    </tbody>
    
  </table>
  </>
  );

  };
  
  export default DataForCity;