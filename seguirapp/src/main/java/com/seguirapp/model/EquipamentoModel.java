package com.seguirapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "equipamento", schema = "DBIFS", catalog = "")
public class EquipamentoModel {
    private int idEquipamento;
    private String marca;
    private String identificador;
    private Collection<CoordenadaModel> coordenadasByIdEquipamento;
    private Collection<ServicoModel> servicosByIdEquipamento;

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
        EquipamentoModel that = (EquipamentoModel) o;
        return idEquipamento == that.idEquipamento &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipamento, marca, identificador);
    }

    @OneToMany(mappedBy = "equipamentoByIdEquipamento")
    public Collection<CoordenadaModel> getCoordenadasByIdEquipamento() {
        return coordenadasByIdEquipamento;
    }

    public void setCoordenadasByIdEquipamento(Collection<CoordenadaModel> coordenadasByIdEquipamento) {
        this.coordenadasByIdEquipamento = coordenadasByIdEquipamento;
    }

    @OneToMany(mappedBy = "equipamentoByIdEquipamento")
    public Collection<ServicoModel> getServicosByIdEquipamento() {
        return servicosByIdEquipamento;
    }

    public void setServicosByIdEquipamento(Collection<ServicoModel> servicosByIdEquipamento) {
        this.servicosByIdEquipamento = servicosByIdEquipamento;
    }
}
