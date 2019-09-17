package com.seguirapp.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {
    private int idPessoa;
    private String nome;
    private Date dtNascimento;
    private String cpfCnpj;
    private String rg;
    private String sexo;
    private Date dtCadastro;
    private String email;
    private String logradouro;
    private String telefone;
    private Pessoa pessoaByIdResponsavel;
    private Auth authByIdAuth;
    private Cidade cidadeByIdCidade;

    public Pessoa (){

    }

    public Pessoa(String nome, Date dtNascimento, String cpfCnpj, String rg, String sexo, Date dtCadastro, String email, String logradouro, String telefone) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.cpfCnpj = cpfCnpj;
        this.rg = rg;
        this.sexo = sexo;
        this.dtCadastro = dtCadastro;
        this.email = email;
        this.logradouro = logradouro;
        this.telefone = telefone;
    }

    @Id
    @Column(name = "id_pessoa", nullable = false)
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Basic
    @NotBlank(message = "Nome é uma Informação Obrigatória !")
    @Column(name = "nome", nullable = false, length = 100)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @NotNull(message = "Data é uma informação obrigatória.")
    @Column(name = "dt_nascimento", nullable = false)
    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Basic
    @Column(name = "cpf_cnpj", nullable = false, length = 45)
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @Basic
    @Column(name = "rg", nullable = true, length = 45)
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Basic
    @Column(name = "sexo", nullable = true, length = 45)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @NotNull(message = "Data é uma informação obrigatória.")
    @Column(name = "dt_cadastro", nullable = false)
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
                Objects.equals(cpfCnpj, pessoa.cpfCnpj) &&
                Objects.equals(rg, pessoa.rg) &&
                Objects.equals(sexo, pessoa.sexo) &&
                Objects.equals(dtCadastro, pessoa.dtCadastro) &&
                Objects.equals(email, pessoa.email) &&
                Objects.equals(logradouro, pessoa.logradouro) &&
                Objects.equals(telefone, pessoa.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, dtNascimento, cpfCnpj, rg, sexo, dtCadastro, email, logradouro, telefone);
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
    @JoinColumn(name = "id_auth", referencedColumnName = "id_auth", nullable = false)
    public Auth getAuthByIdAuth() {
        return authByIdAuth;
    }

    public void setAuthByIdAuth(Auth authByIdAuth) {
        this.authByIdAuth = authByIdAuth;
    }

    @ManyToOne
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade", nullable = false)
    public Cidade getCidadeByIdCidade() {
        return cidadeByIdCidade;
    }

    public void setCidadeByIdCidade(Cidade cidadeByIdCidade) {
        this.cidadeByIdCidade = cidadeByIdCidade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dtNascimento=" + dtNascimento +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", rg='" + rg + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dtCadastro=" + dtCadastro +
                ", email='" + email + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
