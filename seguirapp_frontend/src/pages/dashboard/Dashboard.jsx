import React, { Component } from 'react'
import { Map, InfoWindow, Marker, GoogleApiWrapper } from 'google-maps-react';

const style = {
    width: '100%',
    height: '100%'
  }

class Dashboard extends Component {
    render() {
        return (
            <Map google={this.props.google}
            style={style}
            zoom={10}
                initialCenter={{
                    lat: -10.88219015,
                    lng: -37.66411681
                }}>

                <Marker onClick={this.onMarkerClick}
                    name={'Current location'} />

                <InfoWindow onClose={this.onInfoWindowClose}>
                </InfoWindow>
            </Map>
        )
    }
}

export default GoogleApiWrapper({
    apiKey: ("AIzaSyCkAC9QaOfVLuMHffd5-ENkalQEEOXkmD0")
})(Dashboard)