package com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Servico {
    private int idServico;
    private double preco;
    private String descricao;
    private Pessoa pessoaByIdPessoa;
    private Equipamento equipamentoByIdEquipamento;

    @Id
    @Column(name = "id_servico", nullable = false)
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    @Basic
    @Column(name = "preco", nullable = false, precision = 0)
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Basic
    @Column(name = "descricao", nullable = true, length = -1)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return idServico == servico.idServico &&
                Double.compare(servico.preco, preco) == 0 &&
                Objects.equals(descricao, servico.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServico, preco, descricao);
    }

    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false)
    public Pessoa getPessoaByIdPessoa() {
        return pessoaByIdPessoa;
    }

    public void setPessoaByIdPessoa(Pessoa pessoaByIdPessoa) {
        this.pessoaByIdPessoa = pessoaByIdPessoa;
    }

    @ManyToOne
    @JoinColumn(name = "id_equipamento", referencedColumnName = "id_equipamento", nullable = false)
    public Equipamento getEquipamentoByIdEquipamento() {
        return equipamentoByIdEquipamento;
    }

    public void setEquipamentoByIdEquipamento(Equipamento equipamentoByIdEquipamento) {
        this.equipamentoByIdEquipamento = equipamentoByIdEquipamento;
    }
}
