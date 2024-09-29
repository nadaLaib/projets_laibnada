import { useState } from "react";
import { useEffect } from "react";
import React from 'react';
import Chart from 'chart.js/auto'
import { Bar } from "react-chartjs-2";
import { Line } from "react-chartjs-2";
import { Radar} from "react-chartjs-2";
import meteoDataByCity from "../data/meteo-data"
import Buttons from "./Buttons.jsx";
import SelectChartType from"./SelectChartType.jsx";
import '../assets/style/chartZone.style.css'

const LABELS = ['Jan','Fev','Mar','Avr','Mai','Jun','Jul','Aou','Sep','Oct','Nov','Dec']

/**
 * affiche un graphique comparant les données méteo de la ville selectionné et de la ville favorite
 * @param {*} selectedCity la ville selectionné
 * @param {*} favoriteCity la ville favori 
 * @returns graphique de comparaison entre la ville selectionné et la ville favorite
 */
const ChartZone = ( { selectedCity , favoriteCity } ) => {
    const [MIN_VALUE,setMIN_VALUE]=useState(MIN_VALUE);
    const [MAX_VALUE,setMAX_VALUE]=useState(MAX_VALUE);
    
    const selectedCityData = meteoDataByCity.find(c=> c.city === selectedCity);
    const favoriteCityData = meteoDataByCity.find(c=> c.city === favoriteCity);
    
    const [type,setType] = useState("temp_min");

    const [chartType, setChartType] = useState("bar"); // par defaut, le type du graphique est bar

    const changeChartType=(evt)=>{
        setChartType(evt.target.value);
    }

    // @return le jeux de données (datasets) du graphique
    const buildData = (type)  => {    
        const type_liste_selected = selectedCityData.data.map(mois=> mois[type]);
        const type_liste_favorite = favoriteCityData.data.map(mois=> mois[type]);
                                         
        return (
            chartType ==="lineArea" || chartType ==="radarChart" ? 
            {
                labels: LABELS,                                            // définit les étiquettes en abscisses
                datasets : [
                    {
                        label : selectedCity,                         // légende jeu de données 1 
                        data : type_liste_selected,            // valeurs jeu de données 1 (type demandé pour la ville selectionné)
                        backgroundColor: 'rgba(73, 181, 140, 0.2)', // couleur presque transparente pour bien voir l'aire des graphique
                        borderColor: 'rgb(73, 181, 140)',
                        borderWidth: 1
                    },
                    {
                        label :favoriteCity,                         // légende jeu de données 2 
                        data : type_liste_favorite,            // valeurs jeu de données 1 (type demandé pour la ville favorie)
                        backgroundColor: 'rgba(251, 255, 0, 0.2)', // couleur presque transparente pour bien voir l'aire des graphique
                        borderColor: 'gold',
                        borderWidth: 1
                    },                                                     
                                                               
                ]  
            }
            
            
            : {
                labels: LABELS,                                            // définit les étiquettes en abscisses
                datasets : [
                    {
                        label : selectedCity,                         // légende jeu de données 1 
                        data : type_liste_selected,            // valeurs jeu de données 1 (type demandé pour la ville selectionné)
                        backgroundColor: 'rgb(73, 181, 140)',               // couleur jeu de données 1 
                        borderColor: 'rgba(0, 0, 0, 0.5)',
                        borderWidth: 1
                    },
                    {
                        label :favoriteCity,                         // légende jeu de données 2 
                        data : type_liste_favorite,            // valeurs jeu de données 1 (type demandé pour la ville favorie)
                        backgroundColor: 'rgb(251, 255, 0)',                           // couleur jeu de données 2
                        borderColor: 'rgba(0, 0, 0, 0.5)',
                        borderWidth: 1
                    },                                                     
                                                               
                ]  
            })
    }

    const [chartData,setChartData]= useState(buildData(type));

    const [title, setTitle] = useState("Température minimale (°C)"); // par défaut on affiche le graphique de type temp_min alors on met son titre correspondant par conséquence

    // construit le graphique en fonction de son type
    const chart = chartType==='bar' ? (
        <div className="chartZone">
            <Bar
                data={chartData}
                options={{
                    scales: {
                        y: {
                            min: MIN_VALUE,
                            max: MAX_VALUE,
                        }
                    },
                    animation: {
                        duration: 500,
                        easing: 'easeIn'
                    },
                    plugins: {
                        title: {
                            display: true,
                            text: title,
                        }
                    },
                    legend: {
                        labels: {
                            fontSize: 14
                        }
                    }
                }}
            />
        </div>
    ) :  chartType ==="line" ? (
        <div className="chartZone">
            <Line
                data={chartData}
                options={{
                    scales: {
                        y: {
                            min: MIN_VALUE,
                            max: MAX_VALUE,
                        }
                    },
                    animation: {
                        duration: 500,
                        easing: 'easeIn'
                    },
                    plugins: {
                        title: {
                            display: true,
                            text: title,
                        }
                    },
                    legend: {
                        labels: {
                            fontSize: 14
                        }
                    },
                    elements:{
                        line:{
                            fill: false
                        }
                    }
                }}
            />
        </div>
    ) : chartType ==="lineArea" ? (
        <div className="chartZone">
            <Line
                data={chartData}
                options={{
                    scales: {
                        y: {
                            min: MIN_VALUE,
                            max: MAX_VALUE,
                        }
                    },
                    animation: {
                        duration: 500,
                        easing: 'easeIn'
                    },
                    plugins: {
                        title: {
                            display: true,
                            text: title,
                        }
                    },
                    legend: {
                        labels: {
                            fontSize: 14
                        }
                    },
                    elements:{
                        line:{
                            fill: true
                        }
                    }
                }}
            />
        </div>
    ) : chartType === "radarChart" ? (
        <div className="chartZone">
            <Radar
                data={chartData}
                options={{
                    scales: {
                        y: {
                            display:false
                        }
                    },
                    animation: {
                        duration: 500,
                        easing: 'easeIn'
                    },
                    plugins: {
                        title: {
                            display: true,
                            text: title,
                        }
                    },
                    legend: {
                        labels: {
                            fontSize: 14
                        }
                    },
                    elements:{
                        line:{
                            fill: true
                        }
                    }
                }}
            />
        </div>
    ) : null;


    const changeData = (newtype,titleText) => {
        setType(newtype);
        setChartData(buildData(newtype));  // génère de nouvelles données et met à jour la variable d'état
        setTitle(titleText);
    };

    
    useEffect(() => {
        // récupère la liste de données par rapport au type météo choisi
        const type_liste_selected= selectedCityData.data.map(mois => mois[type]);
        const type_liste_favorite= favoriteCityData.data.map(mois => mois[type]);

        // coordonnée minimal et maximal du graphique en fonction du type selectionné
        const MIN_VALUE= (Math.min(...type_liste_selected, ...type_liste_favorite))<0 ? -5 : 0; 
        const MAX_VALUE= Math.max(...type_liste_selected, ...type_liste_favorite) + 10; 

        //mise à jour des coordonnées
        setMIN_VALUE(MIN_VALUE); 
        setMAX_VALUE(MAX_VALUE);

        setChartData(buildData(type,chartType)); // construit le graphique en fonction du type méteo selectionné et du type de graphique

    },[type, selectedCity, favoriteCity, chartType]); // dépendances

    return (
        <>
        <div>
            <SelectChartType chartType={chartType} changeChartType={changeChartType}/> {/**Extension ajoutée : Possibilité de choisir le type de graphique */}
            <Buttons changeData={changeData}/> {/** bouttons pour choisir les données du graphique */}
            { chart } {/** affiche le graphique */}
        </div>
        </>
    );
}

export default ChartZone;