import React from 'react';
import barImage from '../assets/images/icone_histo.jpg';
import lineImage from '../assets/images/icone_courbe.png';
import lineAreaImage from '../assets/images/icone_graphdesurface.png';
import radarChartImage from '../assets/images/icone_circulaire.jpg';

/**
 * Extension ajoutée : L'utilisateur à la possibilité de selectionné le type de graphique
 * Il peut choisir parmi quatre options représentées par des boutons radio
 * @param {} charType le type de graphique
 * @param {} changeChartType fonction qui met à jour le type
 * @returns les boutons radios pour choisir le graphique
 */
const SelectChartType = ({chartType,changeChartType})=>{   
     
    return(
        <>
            <div id="SelectChartType">
                <p className= "InfoChartType">Exploration graphique</p>
                <div>
                <label className = "OptionChartType" >
                    <img src={barImage} alt="barre_verticale"/>
                     Barres Verticales
                    <input type="radio" value="bar" checked={chartType === 'bar'} onChange={changeChartType} />
                </label>
                <label id = "courbe" className = "OptionChartType">
                    <img src={lineImage} alt="courbe" />
                     Courbe
                    <input type="radio" value="line" checked={chartType === 'line'} onChange={changeChartType}/>
                </label>
                <br/>
                <label className = "OptionChartType">
                <img src={lineAreaImage} alt="graphique_de_surface" />
                     Graphique de surface
                    <input type="radio" value="lineArea" checked={chartType === 'lineArea'} onChange={changeChartType}/>
                </label>
                <label className = "OptionChartType">
                <img src={radarChartImage} alt="circulaire" />
                     Diagramme circulaire
                    <input type="radio" value="radarChart" checked={chartType === 'radarChart'} onChange={changeChartType}/>
                </label>

                </div>
            </div>
        </>
    );
}

export default SelectChartType;