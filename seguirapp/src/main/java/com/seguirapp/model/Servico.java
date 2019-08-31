package com.seguirapp.model;

import java.sql.Date;
import java.util.Objects;
/**
 *
 * @author thecu
 */
public class Servico {

    private int idServico;
    private Pessoa pessoa = new Pessoa();
    private float preco;
    private Veiculo veiculo = new Veiculo();
    private String descricao;
    private Equipamento equipamento = new Equipamento();

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idServico;
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
        final Servico other = (Servico) obj;
        if (this.idServico != other.idServico) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (Float.floatToIntBits(this.preco) != Float.floatToIntBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.equipamento, other.equipamento)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Servico{" + "idServico=" + idServico + ", pessoa=" + pessoa + ", preco=" + preco + ", veiculo=" + veiculo + ", descricao=" + descricao + ", equipamento=" + equipamento + '}';
    }

}
