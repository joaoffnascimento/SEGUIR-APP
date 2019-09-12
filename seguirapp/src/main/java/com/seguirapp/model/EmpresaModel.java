package com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "empresa", schema = "DBIFS", catalog = "")
public class EmpresaModel {
    private int idEmpresa;
    private String nome;
    private String cnpj;
    private int idPessoa;
    private PessoaModel pessoaByIdPessoa;

    @Id
    @Column(name = "id_empresa", nullable = false)
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

    @Basic
    @Column(name = "id_pessoa", nullable = false)
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaModel that = (EmpresaModel) o;
        return idEmpresa == that.idEmpresa &&
                idPessoa == that.idPessoa &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, nome, cnpj, idPessoa);
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
}
