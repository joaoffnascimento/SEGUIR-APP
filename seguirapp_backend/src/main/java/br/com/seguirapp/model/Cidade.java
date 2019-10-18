package br.com.seguirapp.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity(name = "cidade")
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
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    // Muitos para um, minha classe vai estar N em ...
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado", nullable = false)
    private Estado estado;

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

    public int getEstado() {
        return estado.getIdEstado();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //Para auxiliar, equals and hashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return getIdCidade() == cidade.getIdCidade() &&
                Objects.equals(getNome(), cidade.getNome()) &&
                Objects.equals(getEstado(), cidade.getEstado());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cidade{");
        sb.append("idCidade=").append(getIdCidade());
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", estado=").append(getEstado());
        sb.append('}');
        return sb.toString();
    }
}
