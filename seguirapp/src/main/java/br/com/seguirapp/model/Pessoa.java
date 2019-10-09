package br.com.seguirapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    /**
     * CIDADE
     * @author João F. F. Nascimento
     */

    @Id
    @Column(name = "id_pessoa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPessoa;

    @Basic
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    private String cpfCnpj;
    private String logradouro;

    @ManyToOne
    @JoinColumn(name = "id_cidade", referencedColumnName = "id_cidade", nullable = false)
    private Cidade cidade;

    private String telefone;
    private Date dtNascimento;
   /* private Usuario usuario;
    private Dispositivo dispositivo;
    private Grupo grupo;*/

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
                Objects.equals(dtNascimento, pessoa.dtNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, cpfCnpj, logradouro, cidade, telefone, dtNascimento);
    }


}
