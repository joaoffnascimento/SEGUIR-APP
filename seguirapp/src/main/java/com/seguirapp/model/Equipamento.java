package com.seguirapp.model;

import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author João Felipe Fonseca Nascimento
 * @since 25/08/2019
 */
public class Equipamento {
    private int idEquipamento;
    private String marca;
    private Coordenada coordenada = new Coordenada();
    private String identificador;

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idEquipamento;
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
        final Equipamento other = (Equipamento) obj;
        if (this.idEquipamento != other.idEquipamento) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.coordenada, other.coordenada)) {
            return false;
        }
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Equipamento{" + "idEquipamento=" + idEquipamento + ", marca=" + marca + ", coordenada=" + coordenada + ", identificador=" + identificador + '}';
    }
    
    
}
