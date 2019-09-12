package com.seguirapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "coordenada", schema = "DBIFS", catalog = "")
public class CoordenadaModel {
    private int idCoordenada;
    private double latitude;
    private double longitude;
    private double velocidade;
    private double altitude;
    private Date horario;
    private int idEquipamento;
    private EquipamentoModel equipamentoByIdEquipamento;

    @Id
    @Column(name = "id_coordenada", nullable = false)
    public int getIdCoordenada() {
        return idCoordenada;
    }

    public void setIdCoordenada(int idCoordenada) {
        this.idCoordenada = idCoordenada;
    }

    @Basic
    @Column(name = "latitude", nullable = false, precision = 0)
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = false, precision = 0)
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "velocidade", nullable = false, precision = 0)
    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Basic
    @Column(name = "altitude", nullable = false, precision = 0)
    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    @Basic
    @Column(name = "horario", nullable = false)
    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    @Basic
    @Column(name = "id_equipamento", nullable = false)
    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordenadaModel that = (CoordenadaModel) o;
        return idCoordenada == that.idCoordenada &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.velocidade, velocidade) == 0 &&
                Double.compare(that.altitude, altitude) == 0 &&
                idEquipamento == that.idEquipamento &&
                Objects.equals(horario, that.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCoordenada, latitude, longitude, velocidade, altitude, horario, idEquipamento);
    }

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "equipamento",
            joinColumns = {@JoinColumn(name = "id_equipamento", nullable = false)})
    public EquipamentoModel getEquipamentoByIdEquipamento() {
        return equipamentoByIdEquipamento;
    }

    public void setEquipamentoByIdEquipamento(EquipamentoModel equipamentoByIdEquipamento) {
        this.equipamentoByIdEquipamento = equipamentoByIdEquipamento;
    }
}
