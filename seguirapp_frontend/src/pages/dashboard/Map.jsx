import React, { Component } from 'react'

import mapboxgl, {Marker} from 'mapbox-gl'

import { Button } from 'semantic-ui-react'

class Map extends Component {

    state = {
        center: [-37.6737025, -10.9162652],
        position: [],
        lat: 1,
        long: 1
    }

    componentDidMount() {
        const { container, style, zoom, accessToken } = this.props
        const { center } = this.state

        this.handlePosition()
        this.handleMap(container, style, center, zoom, accessToken)
    }

    handleMap(container, style, center, zoom, accessToken) {
        mapboxgl.accessToken = accessToken
        const map = new mapboxgl.Map({
            container: container,
            style: style,
            center: center,
            zoom: zoom
        })

        
        navigator.geolocation.getCurrentPosition((pos) => {
            let latitude = pos.coords.latitude
            let longitude = pos.coords.longitude


            const marker = new Marker()

            const marker2 = new Marker()

            marker2.setLngLat([longitude, latitude])
            marker2.addTo(map)

            marker.setLngLat([longitude, latitude])
            marker.addTo(map)

            setInterval(() => {
                longitude = longitude + 0.00005
                latitude = latitude + 0.00005

                marker.setLngLat([longitude, latitude])
            }, 1000);
            
            // map.on('load', () => {

            //     map.addSource('pointsSoucer', {
            //         type: 'geojson',
            //         data: {
            //             "type": "FeatureCollection",
            //             "features": [{
            //                 "type": "Feature",
            //                 "properties": {},
            //                 "geometry": {
            //                     "type": "Point",
            //                     "coordinates": [longitude, latitude]
            //                 }
            //             }]
            //         }

            //     });

            //     let offset = [longitude, latitude]

            //     map.addLayer({
            //         id: 'points',
            //         source: 'pointsSoucer',
            //         type: 'circle',
            //         paint: {
            //             'circle-translate': [longitude + 0.1, latitude + 0.1]
            //         },
            //     });

            //     setTimeout(() => {
            //         offset = [longitude + 0.1, latitude + 0.1]; // or whatever
            //     map.set .setPaintProperty('points', 'circle-translate', offset);
            //     }, 5000);

                

            // })


            // 






            //fill, line, symbol, circle, heatmap, fill-extrusion, raster, hillshade, background

            // map.getSource('pointsSoucer').setData({
            //     "type": "FeatureCollection",
            //     "features": [{
            //         "type": "Feature",
            //         "properties": { "name": "Null Island" },
            //         "geometry": {
            //             "type": "Point",
            //             "coordinates": [0, 0]
            //         }
            //     }]
            // });
        })

        this.setState({
            map: map
        })
    }

    addLayer() {
        const { map } = this.state

        map.on('load', () => {
            map.addSource('pointsSoucer', {
                type: 'geojson',
                data: {
                    "type": "FeatureCollection",
                    "features": [{
                        "type": "Feature",
                        "properties": {},
                        "geometry": {
                            "type": "Point",
                            "coordinates": [
                                -74.50,
                                40
                            ]
                        }
                    }]
                }
            });

            map.addLayer({
                id: 'points',
                source: 'pointsSoucer',
                type: 'circle',
            });

            // map.getSource('pointsSoucer').setData({
            //     "type": "FeatureCollection",
            //     "features": [{
            //         "type": "Feature",
            //         "properties": { "name": "Null Island" },
            //         "geometry": {
            //             "type": "Point",
            //             "coordinates": [0, 0]
            //         }
            //     }]
            // });
        })
    }


    handlePosition() {
        const options = {
            enableHighAccuracy: true
        }
        navigator.geolocation.getCurrentPosition((pos) => {
            const center = [pos.coords.longitude, pos.coords.latitude]
            this.setState({
                center
            })
        }, (err) => {
            console.log(err)
        }, options)
    }

    handleFlyToAPosition() {
        console.log(this.state.position)

        // map.flyTo({
        //     center: position
        // })
    }

    render() {
        const { container, classNameStyle } = this.props

        console.log(this.state.position)
        return (
            <div id={container} className={classNameStyle}>
            </div>
        )
    }
}

export default Map