package com.seguirapp.modelHibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "veiculo", schema = "DBIFS")
public class VeiculoModel {
    private int idVeiculo;
    private String placa;
    private String chassi;
    private Date ano;
    private String cor;
    private String marca;
    private String modelo;
    private Collection<ServicoModel> servicosByIdVeiculo;

    @Id
    @Column(name = "idVeiculo", nullable = false)
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
        VeiculoModel that = (VeiculoModel) o;
        return idVeiculo == that.idVeiculo &&
                Objects.equals(placa, that.placa) &&
                Objects.equals(chassi, that.chassi) &&
                Objects.equals(ano, that.ano) &&
                Objects.equals(cor, that.cor) &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(modelo, that.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, placa, chassi, ano, cor, marca, modelo);
    }

    @OneToMany(mappedBy = "veiculoByIdVeiculo")
    public Collection<ServicoModel> getServicosByIdVeiculo() {
        return servicosByIdVeiculo;
    }

    public void setServicosByIdVeiculo(Collection<ServicoModel> servicosByIdVeiculo) {
        this.servicosByIdVeiculo = servicosByIdVeiculo;
    }
}
