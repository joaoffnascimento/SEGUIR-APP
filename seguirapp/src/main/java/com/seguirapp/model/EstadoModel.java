package com.seguirapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estado", schema = "DBIFS", catalog = "")
public class EstadoModel {
    private int idEstado;
    private String nome;
    private String sigla;
    private Collection<CidadeModel> cidadesByIdEstado;

    @Id
    @Column(name = "id_estado", nullable = false)
    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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
    @Column(name = "sigla", nullable = true, length = 2)
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoModel that = (EstadoModel) o;
        return idEstado == that.idEstado &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(sigla, that.sigla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, nome, sigla);
    }

    @OneToMany(mappedBy = "estadoByEstado")
    public Collection<CidadeModel> getCidadesByIdEstado() {
        return cidadesByIdEstado;
    }

    public void setCidadesByIdEstado(Collection<CidadeModel> cidadesByIdEstado) {
        this.cidadesByIdEstado = cidadesByIdEstado;
    }
}
