package com.seguirapp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Veiculo {
    private int idVeiculo;
    private String placa;
    private String chassi;
    private Date ano;
    private String cor;
    private String marca;
    private String modelo;

    @Id
    @Column(name = "id_veiculo", nullable = false)
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Basic
    @Column(name = "placa", nullable = false, length = 45)
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Basic
    @Column(name = "chassi", nullable = false, length = 45)
    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Basic
    @Column(name = "ano", nullable = false)
    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    @Basic
    @Column(name = "cor", nullable = false, length = 45)
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
    @Column(name = "modelo", nullable = false, length = 45)
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return idVeiculo == veiculo.idVeiculo &&
                Objects.equals(placa, veiculo.placa) &&
                Objects.equals(chassi, veiculo.chassi) &&
                Objects.equals(ano, veiculo.ano) &&
                Objects.equals(cor, veiculo.cor) &&
                Objects.equals(marca, veiculo.marca) &&
                Objects.equals(modelo, veiculo.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, placa, chassi, ano, cor, marca, modelo);
    }
}
