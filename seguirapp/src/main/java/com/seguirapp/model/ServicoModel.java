package com.seguirapp.model;

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
    @Column(name = "id_servico", nullable = false)
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    @Basic
    @Column(name = "id_pessoa", nullable = false)
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
    @Column(name = "id_veiculo", nullable = false)
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

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pessoa",
            joinColumns = {@JoinColumn(name = "id_pessoa", nullable = false)})
    public PessoaModel getPessoaByIdPessoa() {
        return pessoaByIdPessoa;
    }

    public void setPessoaByIdPessoa(PessoaModel pessoaByIdPessoa) {
        this.pessoaByIdPessoa = pessoaByIdPessoa;
    }

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "veiculo",
            joinColumns = {@JoinColumn(name = "id_veiculo", nullable = false)})
    public VeiculoModel getVeiculoByIdVeiculo() {
        return veiculoByIdVeiculo;
    }

    public void setVeiculoByIdVeiculo(VeiculoModel veiculoByIdVeiculo) {
        this.veiculoByIdVeiculo = veiculoByIdVeiculo;
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
