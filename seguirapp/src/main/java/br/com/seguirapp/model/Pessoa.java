package br.com.seguirapp.model;

import javax.persistence.*;
import java.awt.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
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
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    private String cpfCnpj;
    private String logradouro;

    @ManyToOne
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade", nullable = false)
    private Cidade cidade;

    @Basic
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;

    @Basic
    @Column(name = "dt_nascimento", nullable = false)
    private Date dtNascimento;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(unique = true)
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(unique = true)
    private Dispositivo dispositivo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo", nullable = false)
    private Grupo grupo;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idPessoa == pessoa.idPessoa &&
                Objects.equals(nome, pessoa.nome) &&
                Objects.equals(cpfCnpj, pessoa.cpfCnpj) &&
                Objects.equals(logradouro, pessoa.logradouro) &&
                Objects.equals(cidade, pessoa.cidade) &&
                Objects.equals(telefone, pessoa.telefone) &&
                Objects.equals(dtNascimento, pessoa.dtNascimento) &&
                Objects.equals(usuario, pessoa.usuario) &&
                Objects.equals(dispositivo, pessoa.dispositivo) &&
                Objects.equals(grupo, pessoa.grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, cpfCnpj, logradouro, cidade, telefone, dtNascimento, usuario, dispositivo, grupo);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cidade=" + cidade +
                ", telefone='" + telefone + '\'' +
                ", dtNascimento=" + dtNascimento +
                ", usuario=" + usuario +
                ", dispositivo=" + dispositivo +
                ", grupo=" + grupo +
                '}';
    }
}
