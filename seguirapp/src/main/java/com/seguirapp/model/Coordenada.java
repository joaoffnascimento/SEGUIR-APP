/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguirapp.model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author João Felipe Fonseca Nascimento
 * @since 25/08/2019
 */

public class Coordenada {

    private int idCoordenada;
    private float latitude;
    private float longitude;
    private float velocidade;
    private float altitude;
    private Date horario;

    public int getIdCoordenada() {
        return idCoordenada;
    }

    public void setIdCoordenada(int idCoordenada) {
        this.idCoordenada = idCoordenada;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idCoordenada;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordenada other = (Coordenada) obj;
        if (this.idCoordenada != other.idCoordenada) {
            return false;
        }
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitude) != Float.floatToIntBits(other.longitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.velocidade) != Float.floatToIntBits(other.velocidade)) {
            return false;
        }
        if (Float.floatToIntBits(this.altitude) != Float.floatToIntBits(other.altitude)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coordenada{" + "idCoordenada=" + idCoordenada + ", latitude=" + latitude + ", longitude=" + longitude + ", velocidade=" + velocidade + ", altitude=" + altitude + ", horario=" + horario + '}';
    }

}
