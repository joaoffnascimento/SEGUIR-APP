package br.com.seguirapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.awt.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "pessoa")
public class Pessoa {

    /**
     * CIDADE
     *
     * @author João F. F. Nascimento
     */

    @Id
    @Column(name = "id_pessoa", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPessoa;

    @Basic
    @Column(name = "nome", nullable = true, length = 45)
    private String nome;

    @Basic
    @Column(name = "cpf_cnpj", nullable = true, length = 15)
    private String cpfCnpj;
    @Basic
    @Column(name = "logradouro", nullable = true, length = 45)
    private String logradouro;

    @ManyToOne
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade", nullable = true)
    private Cidade cidade;

    @Basic
    @Column(name = "telefone", nullable = true, length = 11)
    private String telefone;

    @Basic
    @Column(name = "dt_nascimento", nullable = true)
    private Date dtNascimento;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Basic
    @Column(name = "senha", nullable = false, length = 32)
    private String senha;


    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "dispositivo", referencedColumnName = "id_dispositivo")
    private Dispositivo dispositivo;

//    @ManyToOne(optional = true, fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo", nullable = true)
//    private Grupo grupo;

    public Pessoa(){

    }

    public Pessoa(int idPessoa){
        this.idPessoa = idPessoa;
    }

    //Getters and Setters


    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

//    public Grupo getGrupo() {
//        return grupo;
//    }
//
//    public void setGrupo(Grupo grupo) {
//        this.grupo = grupo;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return getIdPessoa() == pessoa.getIdPessoa() &&
                Objects.equals(getNome(), pessoa.getNome()) &&
                Objects.equals(getCpfCnpj(), pessoa.getCpfCnpj()) &&
                Objects.equals(getLogradouro(), pessoa.getLogradouro()) &&
                Objects.equals(getCidade(), pessoa.getCidade()) &&
                Objects.equals(getTelefone(), pessoa.getTelefone()) &&
                Objects.equals(getDtNascimento(), pessoa.getDtNascimento()) &&
                Objects.equals(getEmail(), pessoa.getEmail()) &&
                Objects.equals(getSenha(), pessoa.getSenha()) &&
                Objects.equals(getDispositivo(), pessoa.getDispositivo());
//                Objects.equals(getGrupo(), pessoa.getGrupo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPessoa(), getNome(), getCpfCnpj(), getLogradouro(), getCidade(), getTelefone(), getDtNascimento(), getEmail(), getSenha(), getDispositivo());
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pessoa{");
        sb.append("idPessoa=").append(idPessoa);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", cpfCnpj='").append(cpfCnpj).append('\'');
        sb.append(", logradouro='").append(logradouro).append('\'');
        sb.append(", cidade=").append(cidade);
        sb.append(", telefone='").append(telefone).append('\'');
        sb.append(", dtNascimento=").append(dtNascimento);
        sb.append(", email='").append(email).append('\'');
        sb.append(", senha='").append(senha).append('\'');
        sb.append(", dispositivo=").append(dispositivo);
//        sb.append(", grupo=").append(grupo);
        sb.append('}');
        return sb.toString();
    }
}
