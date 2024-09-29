import React from 'react';
import { useState } from "react"
import SelectCity from './SelectCity.jsx';
import DataComparison from './DataComparison.jsx';
import DataForCity from './DataForCity.jsx';
import meteoDataByCity from '../data/meteo-data.js';
import ChartZone from './ChartZone.jsx';
import DisplayFavoriteImage from './DisplayFavoriteImage.jsx';
import Legend from './Legend.jsx';
import '../style/style.css';
import '../assets/style/SelectChartType.style.css';
import '../assets/style/favorite.style.css';
import '../assets/style/dataForCity.style.css';
import '../assets/style/app.style.css';
import '../assets/style/dataComparison.style.css';
import '../assets/style/chartZone.style.css';
import '../assets/style/buttons.style.css';
import '../assets/style/DisplayFavoriteImage.style.css';
import '../assets/style/selectCity.style.css';
import '../assets/style/legend.style.css';


/**
 * Une légende pour la ville selectionné et la ville favorite, les données de la ville selectionné,la comparaison entre la ville selectionné et la ville favorite, une photo de la ville favorite et un type de grahique qui a été choisi par l'utilisateur comparant la ville selectionné et la ville favorite 
 * @returns L'application 
 */
const App = ()=>{
  
  const [selectedCity,setSelectedCity]= useState(meteoDataByCity[1].city); // ville selectionné par défaut demandé dans l'énoncé
  const [favoriteCity, setFavoriteCity] = useState(meteoDataByCity[0].city); // ville favorite par défaut demandé dans l'énoncé

  const [chartZone_Visible, setChartZone_Visible]= useState(false); // par défaut, chartZone n'est pas affiché

  const change_chartZone_visible=()=> {
    setChartZone_Visible(!chartZone_Visible); // met à jour l'état du bouton.
  }

  return(

  <div className="App">
    <h1 className="meteoFor">Meteo pour {selectedCity} </h1> {/**titre avec un affichage dynamique pour le nom de la ville selectionné*/}
    <Legend /> {/**une légende avec les couleurs correspondante pour la ville favorite et la ville sélectionnée*/}
    <SelectCity selectedCity={selectedCity} setSelectedCity={ setSelectedCity} setFavoriteCity={setFavoriteCity} favoriteCity={favoriteCity}/> {/**selection de la ville avec le composant SelectCity et mis a jour de la ville favori */}
    <DataForCity city={selectedCity} />  {/**on affiche les données correspondant à la ville selectionné */}
    <DataComparison favoriteCity={favoriteCity} selectedCity={selectedCity}/> {/**on affiche le tableau de comparaison avec la ville selectionné et la ville favorite.*/}
    <DisplayFavoriteImage favoriteCity={favoriteCity}/> {/**Extension ajouté : Si l'utilisateur coche la case alors l'image de sa ville favorite s'affiche */}
    <button className="afficher" onClick={change_chartZone_visible}>{chartZone_Visible? "Cacher" : "Afficher"}</button> {/**boutton avec un nom dynamique pour afficher ou cacher le graphique */}
    { chartZone_Visible ? <ChartZone selectedCity={selectedCity} favoriteCity={favoriteCity} /> : null} {/** si le boutton est true alors on affiche le graphique comparant la ville selectionné et la ville favorite, sinon on affiche rien */}
  </div> 
  
  );
};

export default App;