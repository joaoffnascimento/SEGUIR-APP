package br.edu.ifs.seguir.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "AEJPESSOA", schema = "DBIFS", catalog = "")
public class AejpessoaEntity {
    private int idPessoa;
    private String nome;
    private Date dtNascimento;
    private String cpf;
    private String rg;
    private String sexo;
    private Date dtCadastro;
    private String email;
    private int numeroCasa;
    private String bairro;
    private String siglaEstado;
    private String logradouro;
    private String cidade;
    private String telefone;
    private String login;
    private String senha;

    public AejpessoaEntity(String nome) {
        this.nome = nome;
    }

    @Id
    @Column(name = "idPessoa")
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "dtNascimento")
    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Basic
    @Column(name = "cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Basic
    @Column(name = "rg")
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Basic
    @Column(name = "sexo")
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "dtCadastro")
    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "numeroCasa")
    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    @Basic
    @Column(name = "bairro")
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Basic
    @Column(name = "siglaEstado")
    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    @Basic
    @Column(name = "logradouro")
    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Basic
    @Column(name = "cidade")
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Basic
    @Column(name = "telefone")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AejpessoaEntity that = (AejpessoaEntity) o;
        return idPessoa == that.idPessoa &&
                numeroCasa == that.numeroCasa &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(dtNascimento, that.dtNascimento) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(rg, that.rg) &&
                Objects.equals(sexo, that.sexo) &&
                Objects.equals(dtCadastro, that.dtCadastro) &&
                Objects.equals(email, that.email) &&
                Objects.equals(bairro, that.bairro) &&
                Objects.equals(siglaEstado, that.siglaEstado) &&
                Objects.equals(logradouro, that.logradouro) &&
                Objects.equals(cidade, that.cidade) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(login, that.login) &&
                Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, dtNascimento, cpf, rg, sexo, dtCadastro, email, numeroCasa, bairro, siglaEstado, logradouro, cidade, telefone, login, senha);
    }

    @Override
    public String toString() {
        return "AejpessoaEntity{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dtNascimento=" + dtNascimento +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dtCadastro=" + dtCadastro +
                ", email='" + email + '\'' +
                ", numeroCasa=" + numeroCasa +
                ", bairro='" + bairro + '\'' +
                ", siglaEstado='" + siglaEstado + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", telefone='" + telefone + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
