package br.com.seguirapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cidade")
public class Cidade {

    /**
     * CIDADE
     * @author João F. F. Nascimento
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade", nullable = false)
    private int idCidade;

    @Basic
    @Column(name = "nome", nullable = true, length = 45)
    private String nome;

    // Muitos para um, minha classe vai estar N em ...
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    private Estado estado;

    //Para fins didaticos estou adicionando esse relacionamento, mapeando o objeto cidade da classe pessoa
    @OneToMany(mappedBy = "cidade")
    private Collection<Pessoa> pessoasByIdCidade;

    //Getters and Setters

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Collection<Pessoa> getPessoasByIdCidade() {
        return pessoasByIdCidade;
    }

    public void setPessoasByIdCidade(Collection<Pessoa> pessoasByIdCidade) {
        this.pessoasByIdCidade = pessoasByIdCidade;
    }

    //Para auxiliar, equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return idCidade == cidade.idCidade &&
                Objects.equals(nome, cidade.nome) &&
                Objects.equals(estado, cidade.estado) &&
                Objects.equals(pessoasByIdCidade, cidade.pessoasByIdCidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCidade, nome, estado, pessoasByIdCidade);
    }

    @Override
    public String toString() {
        return "Cidade {" +
                "nome='" + nome + '\'' +
                ", estado=" + estado +
                '}';
    }
}
