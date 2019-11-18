import React, { Component } from 'react'
import ReactDOM from 'react-dom'
import mapboxgl from 'mapbox-gl';
import { Container } from 'semantic-ui-react';
import 'mapbox-gl/dist/mapbox-gl.css'

import Map from './Map'

const accessToken = 'pk.eyJ1IjoiYWxhbmZscG5zIiwiYSI6ImNrMnYyenJpNTAwOTMzb28zdHJvcmVrY28ifQ.cxL_Jttd3g3T9prj0TcRUg';


class Dashboard extends Component {

    // state = {
    //     viewport: {
    //         width: window.innerWidth,
    //         height: 600,
    //         latitude: mapConfig.center[0],
    //         longitude: mapConfig.center[1],
    //         zoom: mapConfig.zoom,
    //         isDragging: false,
    //         startDragLngLat: mapConfig.center,
    //         pitch: 50,
    //         bearing: 0
    //     }
    // }

    // onChangeViewport(viewport) {
    //     this.setState({
    //         viewport: { ...this.state.viewport, ...viewport }
    //     });
    // }

    // sair = () => {
    //     mapboxgl.remove()
    // }

    // getMap() {

    //     let localizacaoAtual = {}

    //     navigator.geolocation.getCurrentPosition(position => {
    //         localizacaoAtual = { latitude: position.coords.latitude, longitude: position.coords.longitude }
    //     })

    //     console.log(localizacaoAtual.latitude)

    //     const map = new mapboxgl.Map({
    //         container: 'root',
    //         style: 'mapbox://styles/mapbox/streets-v9'
    //     });

    //     map.on('load', () => {
    //         map.addSource('pointsSoucer', {
    //             type: 'geojson',
    //             data: {
    //                 "type": "FeatureCollection",
    //                 "features": [{
    //                     "type": "Feature",
    //                     "properties": {},
    //                     "geometry": {
    //                         "type": "Point",
    //                         "coordinates": [
    //                             localizacaoAtual.longitude,
    //                             localizacaoAtual.latitude
    //                         ]
    //                     }
    //                 }]
    //             }
    //         });

    //         map.addLayer({
    //             id: 'points',
    //             source: 'pointsSoucer',
    //             type: 'circle',
    //         });

    //         //  map.getSource('pointsSoucer').setData({
    //         //     "type": "FeatureCollection",
    //         //     "features": [{
    //         //         "type": "Feature",
    //         //         "properties": { "name": "Null Island" },
    //         //         "geometry": {
    //         //             "type": "Point",
    //         //             "coordinates": [ 0, 0 ]
    //         //         }
    //         //     }]
    //         //   });
    //     })

    //     console.log(map)
    // }

    render() {
        // const { viewport } = this.state;
        return (
            <div className='container-map'>
                <Map
                    container='map'
                    style='mapbox://styles/mapbox/streets-v9'
                    zoom={0}
                    classNameStyle='mapContainer'
                    accessToken='pk.eyJ1IjoiYWxhbmZscG5zIiwiYSI6ImNrMnYyenJpNTAwOTMzb28zdHJvcmVrY28ifQ.cxL_Jttd3g3T9prj0TcRUg'
                />
            </div>
            // <Container className='semi-fluid'>
            //     <ReactMapGL mapboxApiAccessToken={accessToken}
            //         width={window.innerWidth}
            //         height={window.innerWidth}
            //         latitude={37.7577}
            //         longitude={-122.4376}
            //         zoom={8}
            //         onViewportChange={(viewport) => {
            //             const { width, height, latitude, longitude, zoom } = viewport;
            //             // Optionally call `setState` and use the state to update the map.
            //         }}>

            //         <Marker latitude={37.78} longitude={-122.41} offsetLeft={-20} offsetTop={-10}>
            //             <div>You are here</div>
            //         </Marker>

            //     </ReactMapGL>


            //     {/* <div className="reactmapgl">
            //         <MapGL
            //             {...viewport}
            //             mapboxApiAccessToken={accessToken}
            //             perspectiveEnabled
            //             onChangeViewport={this.onChangeViewport}
            //         >
            //             <ScatterplotOverlay
            //                 {...viewport}
            //                 locations={locations}
            //                 dotRadius={2}
            //                 globalOpacity={1}
            //                 compositeOperation="screen"
            //                 dotFill="#1FBAD6"
            //                 renderWhileDragging
            //             />
            //         </MapGL>
            //     </div> */}
            // </Container>
        )
        // return (
        //     // <div>
        //     //     {this.getMap()}
        //     // </div>
        // )
    }
}

export default Dashboard