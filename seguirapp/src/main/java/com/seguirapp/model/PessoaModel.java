package com.seguirapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pessoa", schema = "DBIFS")
public class PessoaModel {
    private int idPessoa;
    private String nome;
    private Date dtNascimento;
    private String cpf;
    private String rg;
    private String sexo;
    private Date dtCadastro;
    private String email;
    private Integer idEmpresa;
    private int numeroCasa;
    private String bairro;
    private String siglaEstado;
    private String logradouro;
    private String cidade;
    private String telefone;
    private Integer idResponsavel;
    private String login;
    private String senha;
    private EmpresaModel empresaByIdEmpresa;
    private PessoaModel pessoaByIdResponsavel;
    private Collection<PessoaModel> pessoasByIdPessoa;
    private Collection<ServicoModel> servicosByIdPessoa;

    @Id
    @Column(name = "idPessoa", nullable = false)
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
    @Column(name = "dtNascimento", nullable = false)
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
    @Column(name = "sexo", nullable = false, length = 1)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "dtCadastro", nullable = true)
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
    @Column(name = "idEmpresa", nullable = true, insertable = false, updatable = false)
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "numeroCasa", nullable = false)
    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    @Basic
    @Column(name = "bairro", nullable = true, length = 45)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Basic
    @Column(name = "siglaEstado", nullable = false, length = 45)
    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
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
    @Column(name = "cidade", nullable = false, length = 45)
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Basic
    @Column(name = "telefone", nullable = false, length = 20)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Basic
    @Column(name = "idResponsavel", nullable = true, insertable = false, updatable = false)
    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "senha", nullable = false, length = 45)
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
        PessoaModel that = (PessoaModel) o;
        return idPessoa == that.idPessoa &&
                numeroCasa == that.numeroCasa &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(dtNascimento, that.dtNascimento) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(rg, that.rg) &&
                Objects.equals(sexo, that.sexo) &&
                Objects.equals(dtCadastro, that.dtCadastro) &&
                Objects.equals(email, that.email) &&
                Objects.equals(idEmpresa, that.idEmpresa) &&
                Objects.equals(bairro, that.bairro) &&
                Objects.equals(siglaEstado, that.siglaEstado) &&
                Objects.equals(logradouro, that.logradouro) &&
                Objects.equals(cidade, that.cidade) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(idResponsavel, that.idResponsavel) &&
                Objects.equals(login, that.login) &&
                Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, dtNascimento, cpf, rg, sexo, dtCadastro, email, idEmpresa, numeroCasa, bairro, siglaEstado, logradouro, cidade, telefone, idResponsavel, login, senha);
    }

    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
    public EmpresaModel getEmpresaByIdEmpresa() {
        return empresaByIdEmpresa;
    }

    public void setEmpresaByIdEmpresa(EmpresaModel empresaByIdEmpresa) {
        this.empresaByIdEmpresa = empresaByIdEmpresa;
    }

    @ManyToOne
    @JoinColumn(name = "idResponsavel", referencedColumnName = "idPessoa")
    public PessoaModel getPessoaByIdResponsavel() {
        return pessoaByIdResponsavel;
    }

    public void setPessoaByIdResponsavel(PessoaModel pessoaByIdResponsavel) {
        this.pessoaByIdResponsavel = pessoaByIdResponsavel;
    }

    @OneToMany(mappedBy = "pessoaByIdResponsavel")
    public Collection<PessoaModel> getPessoasByIdPessoa() {
        return pessoasByIdPessoa;
    }

    public void setPessoasByIdPessoa(Collection<PessoaModel> pessoasByIdPessoa) {
        this.pessoasByIdPessoa = pessoasByIdPessoa;
    }

    @OneToMany(mappedBy = "pessoaByIdPessoa")
    public Collection<ServicoModel> getServicosByIdPessoa() {
        return servicosByIdPessoa;
    }

    public void setServicosByIdPessoa(Collection<ServicoModel> servicosByIdPessoa) {
        this.servicosByIdPessoa = servicosByIdPessoa;
    }
}
