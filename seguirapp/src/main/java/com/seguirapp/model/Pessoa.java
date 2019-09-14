package com.seguirapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Pessoa {
    private int idPessoa;
    private String nome;
    private Date dtNascimento;
    private String cpf;
    private String rg;
    private String sexo;
    private Date dtCadastro;
    private String email;
    private String logradouro;
    private String telefone;
    private Pessoa pessoaByIdResponsavel;
    private Auth authByAuth;
    private Cidade cidadeByCidade;

    @Id
    @Column(name = "id_pessoa", nullable = false)
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Basic
    @Column(name = "nome", nullable = false, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "dt_nascimento", nullable = true)
    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Basic
    @Column(name = "cpf", nullable = false, length = 45)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Basic
    @Column(name = "rg", nullable = false, length = 45)
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Basic
    @Column(name = "sexo", nullable = false, length = 45)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "dt_cadastro", nullable = true)
    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "logradouro", nullable = false, length = 100)
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Basic
    @Column(name = "telefone", nullable = false, length = 20)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idPessoa == pessoa.idPessoa &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(dtNascimento, pessoa.dtNascimento) &&
                Objects.equals(cpf, pessoa.cpf) &&
                Objects.equals(rg, pessoa.rg) &&
                Objects.equals(sexo, pessoa.sexo) &&
                Objects.equals(dtCadastro, pessoa.dtCadastro) &&
                Objects.equals(email, pessoa.email) &&
                Objects.equals(logradouro, pessoa.logradouro) &&
                Objects.equals(telefone, pessoa.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, dtNascimento, cpf, rg, sexo, dtCadastro, email, logradouro, telefone);
    }

    @ManyToOne
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id_pessoa")
    public Pessoa getPessoaByIdResponsavel() {
        return pessoaByIdResponsavel;
    }

    public void setPessoaByIdResponsavel(Pessoa pessoaByIdResponsavel) {
        this.pessoaByIdResponsavel = pessoaByIdResponsavel;
    }

    @ManyToOne
    @JoinColumn(name = "auth", referencedColumnName = "id_auth", nullable = false)
    public Auth getAuthByAuth() {
        return authByAuth;
    }

    public void setAuthByAuth(Auth authByAuth) {
        this.authByAuth = authByAuth;
    }

    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id_cidade", nullable = false)
    public Cidade getCidadeByCidade() {
        return cidadeByCidade;
    }

    public void setCidadeByCidade(Cidade cidadeByCidade) {
        this.cidadeByCidade = cidadeByCidade;
    }
}
