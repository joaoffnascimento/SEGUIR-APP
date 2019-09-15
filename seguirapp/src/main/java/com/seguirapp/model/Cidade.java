package com.seguirapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Cidade implements Serializable {
    private int idCidade;
    private String nome;
    private Estado estadoByIdEstado;
    private Collection<Pessoa> pessoasByIdCidade;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return idCidade == cidade.idCidade &&
                Objects.equals(nome, cidade.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCidade, nome);
    }

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    public Estado getEstadoByIdEstado() {
        return estadoByIdEstado;
    }

    public void setEstadoByIdEstado(Estado estadoByIdEstado) {
        this.estadoByIdEstado = estadoByIdEstado;
    }

    @OneToMany(mappedBy = "cidadeByIdCidade")
    public Collection<Pessoa> getPessoasByIdCidade() {
        return pessoasByIdCidade;
    }

    public void setPessoasByIdCidade(Collection<Pessoa> pessoasByIdCidade) {
        this.pessoasByIdCidade = pessoasByIdCidade;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "idCidade=" + idCidade +
                ", nome='" + nome + '\'' +
                ", estadoByIdEstado=" + estadoByIdEstado +
                ", pessoasByIdCidade=" + pessoasByIdCidade +
                '}';
    }
}
