package com.seguirapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name = "pessoa", schema = "DBIFS", catalog = "")
public class PessoaModel {
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
    private Integer idResponsavel;
    private int auth;
    private int cidade;
    private Collection<EmpresaModel> empresasByIdPessoa;
    private PessoaModel pessoaByIdResponsavel;
    private Collection<PessoaModel> pessoasByIdPessoa;
    private AuthModel authByAuth;
    private CidadeModel cidadeByCidade;
    private Collection<ServicoModel> servicosByIdPessoa;

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
    @Column(name = "dt_nascimento", nullable = false)
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

    @Basic
    @Column(name = "id_responsavel", nullable = true)
    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    @Basic
    @Column(name = "auth", nullable = false)
    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    @Basic
    @Column(name = "cidade", nullable = false)
    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaModel that = (PessoaModel) o;
        return idPessoa == that.idPessoa &&
                auth == that.auth &&
                cidade == that.cidade &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(dtNascimento, that.dtNascimento) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(rg, that.rg) &&
                Objects.equals(sexo, that.sexo) &&
                Objects.equals(dtCadastro, that.dtCadastro) &&
                Objects.equals(email, that.email) &&
                Objects.equals(logradouro, that.logradouro) &&
                Objects.equals(telefone, that.telefone) &&
                Objects.equals(idResponsavel, that.idResponsavel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, dtNascimento, cpf, rg, sexo, dtCadastro, email, logradouro, telefone, idResponsavel, auth, cidade);
    }

    @OneToMany(mappedBy = "pessoaByIdPessoa")
    public Collection<EmpresaModel> getEmpresasByIdPessoa() {
        return empresasByIdPessoa;
    }

    public void setEmpresasByIdPessoa(Collection<EmpresaModel> empresasByIdPessoa) {
        this.empresasByIdPessoa = empresasByIdPessoa;
    }

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pessoa",
            joinColumns = {@JoinColumn(name = "id_pessoa", nullable = false)})
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

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "auth",
            joinColumns = {@JoinColumn(name = "id_auth", nullable = false)})
    public AuthModel getAuthByAuth() {
        return authByAuth;
    }

    public void setAuthByAuth(AuthModel authByAuth) {
        this.authByAuth = authByAuth;
    }

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cidade",
            joinColumns = {@JoinColumn(name = "id_cidade", nullable = false)})
    public CidadeModel getCidadeByCidade() {
        return cidadeByCidade;
    }

    public void setCidadeByCidade(CidadeModel cidadeByCidade) {
        this.cidadeByCidade = cidadeByCidade;
    }

    @OneToMany(mappedBy = "pessoaByIdPessoa")
    public Collection<ServicoModel> getServicosByIdPessoa() {
        return servicosByIdPessoa;
    }

    public void setServicosByIdPessoa(Collection<ServicoModel> servicosByIdPessoa) {
        this.servicosByIdPessoa = servicosByIdPessoa;
    }
}
