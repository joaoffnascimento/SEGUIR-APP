package com.seguirapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empresa", schema = "DBIFS")
public class EmpresaModel {
    private int idEmpresa;
    private String nome;
    private String cnpj;
    private Collection<PessoaModel> pessoasByIdEmpresa;

    @Id
    @Column(name = "idEmpresa", nullable = false, insertable = false, updatable = false)
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "nome", nullable = false, length = 45)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "cnpj", nullable = false, length = 45)
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaModel that = (EmpresaModel) o;
        return idEmpresa == that.idEmpresa &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, nome, cnpj);
    }

    @OneToMany(mappedBy = "empresaByIdEmpresa")
    public Collection<PessoaModel> getPessoasByIdEmpresa() {
        return pessoasByIdEmpresa;
    }

    public void setPessoasByIdEmpresa(Collection<PessoaModel> pessoasByIdEmpresa) {
        this.pessoasByIdEmpresa = pessoasByIdEmpresa;
    }
}
