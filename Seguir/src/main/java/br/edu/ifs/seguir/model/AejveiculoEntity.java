package br.edu.ifs.seguir.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "AEJVEICULO", schema = "DBIFS", catalog = "")
public class AejveiculoEntity {
    private int idAejveiculo;
    private String placa;
    private String chassi;
    private Date ano;
    private String cor;
    private String marca;
    private String modelo;

    @Id
    @Column(name = "idAEJVEICULO")
    public int getIdAejveiculo() {
        return idAejveiculo;
    }

    public void setIdAejveiculo(int idAejveiculo) {
        this.idAejveiculo = idAejveiculo;
    }

    @Basic
    @Column(name = "placa")
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Basic
    @Column(name = "chassi")
    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    @Basic
    @Column(name = "ano")
    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    @Basic
    @Column(name = "cor")
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Basic
    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "modelo")
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
        AejveiculoEntity that = (AejveiculoEntity) o;
        return idAejveiculo == that.idAejveiculo &&
                Objects.equals(placa, that.placa) &&
                Objects.equals(chassi, that.chassi) &&
                Objects.equals(ano, that.ano) &&
                Objects.equals(cor, that.cor) &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(modelo, that.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAejveiculo, placa, chassi, ano, cor, marca, modelo);
    }
}
