package com.seguirapp.modelHibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "servico", schema = "DBIFS", catalog = "")
public class ServicoModel {
    private int idServico;
    private int idPessoa;
    private double preco;
    private int idVeiculo;
    private String descricao;
    private int idEquipamento;
    private PessoaModel pessoaByIdPessoa;
    private VeiculoModel veiculoByIdVeiculo;
    private EquipamentoModel equipamentoByIdEquipamento;

    @Id
    @Column(name = "idServico", nullable = false)
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    @Basic
    @Column(name = "idPessoa", nullable = false)
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
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
    @Column(name = "idVeiculo", nullable = false)
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    @Basic
    @Column(name = "descricao", nullable = true, length = -1)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "idEquipamento", nullable = false)
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
        ServicoModel that = (ServicoModel) o;
        return idServico == that.idServico &&
                idPessoa == that.idPessoa &&
                Double.compare(that.preco, preco) == 0 &&
                idVeiculo == that.idVeiculo &&
                idEquipamento == that.idEquipamento &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServico, idPessoa, preco, idVeiculo, descricao, idEquipamento);
    }

    @ManyToOne
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa", nullable = false)
    public PessoaModel getPessoaByIdPessoa() {
        return pessoaByIdPessoa;
    }

    public void setPessoaByIdPessoa(PessoaModel pessoaByIdPessoa) {
        this.pessoaByIdPessoa = pessoaByIdPessoa;
    }

    @ManyToOne
    @JoinColumn(name = "idVeiculo", referencedColumnName = "idVeiculo", nullable = false)
    public VeiculoModel getVeiculoByIdVeiculo() {
        return veiculoByIdVeiculo;
    }

    public void setVeiculoByIdVeiculo(VeiculoModel veiculoByIdVeiculo) {
        this.veiculoByIdVeiculo = veiculoByIdVeiculo;
    }

    @ManyToOne
    @JoinColumn(name = "idEquipamento", referencedColumnName = "idEquipamento", nullable = false)
    public EquipamentoModel getEquipamentoByIdEquipamento() {
        return equipamentoByIdEquipamento;
    }

    public void setEquipamentoByIdEquipamento(EquipamentoModel equipamentoByIdEquipamento) {
        this.equipamentoByIdEquipamento = equipamentoByIdEquipamento;
    }
}
