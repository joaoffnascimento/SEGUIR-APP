package com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Equipamento {
    private int idEquipamento;
    private String marca;
    private String identificador;
    private Coordenada coordenadaByIdCoordenada;

    @Id
    @Column(name = "id_equipamento", nullable = false)
    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @Basic
    @Column(name = "marca", nullable = false, length = 45)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "identificador", nullable = false, length = 10)
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipamento that = (Equipamento) o;
        return idEquipamento == that.idEquipamento &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipamento, marca, identificador);
    }

    @ManyToOne
    @JoinColumn(name = "id_coordenada", referencedColumnName = "id_coordenada", nullable = false)
    public Coordenada getCoordenadaByIdCoordenada() {
        return coordenadaByIdCoordenada;
    }

    public void setCoordenadaByIdCoordenada(Coordenada coordenadaByIdCoordenada) {
        this.coordenadaByIdCoordenada = coordenadaByIdCoordenada;
    }
}
