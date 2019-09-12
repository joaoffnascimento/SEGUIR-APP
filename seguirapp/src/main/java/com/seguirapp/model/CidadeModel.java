package com.seguirapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cidade", schema = "DBIFS", catalog = "")
public class CidadeModel {
    private int idCidade;
    private String nome;
    private int estado;
    private EstadoModel estadoByEstado;
    private Collection<PessoaModel> pessoasByIdCidade;

    @Id
    @Column(name = "id_cidade", nullable = false)
    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    @Basic
    @Column(name = "nome", nullable = true, length = 45)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "estado", nullable = false)
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CidadeModel that = (CidadeModel) o;
        return idCidade == that.idCidade &&
                estado == that.estado &&
                Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCidade, nome, estado);
    }

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "estado",
            joinColumns = {@JoinColumn(name = "id_estado", nullable = false)})
    public EstadoModel getEstadoByEstado() {
        return estadoByEstado;
    }

    public void setEstadoByEstado(EstadoModel estadoByEstado) {
        this.estadoByEstado = estadoByEstado;
    }

    @OneToMany(mappedBy = "cidadeByCidade")
    public Collection<PessoaModel> getPessoasByIdCidade() {
        return pessoasByIdCidade;
    }

    public void setPessoasByIdCidade(Collection<PessoaModel> pessoasByIdCidade) {
        this.pessoasByIdCidade = pessoasByIdCidade;
    }
}
