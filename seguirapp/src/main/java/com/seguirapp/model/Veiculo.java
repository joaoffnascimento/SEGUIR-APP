package com.seguirapp.model;

import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author thecu
 */
public class Veiculo {
    private int idVeiculo;
    private String placa;
    private String chassi;
    private Date ano;
    private String cor;
    private String marca;
    private String modelo;

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idVeiculo;
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
        final Veiculo other = (Veiculo) obj;
        if (this.idVeiculo != other.idVeiculo) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.chassi, other.chassi)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.cor, other.cor)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Veiculo{" + "idVeiculo=" + idVeiculo + ", placa=" + placa + ", chassi=" + chassi + ", ano=" + ano + ", cor=" + cor + ", marca=" + marca + ", modelo=" + modelo + '}';
    }    
}
