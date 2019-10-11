package br.com.seguirapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estado")
public class Estado {

    /**
     * CIDADE
     * @author João F. F. Nascimento
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", nullable = false)
    private int idEstado;

    @Basic
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Basic
    @Column(name = "sigla", nullable = false, length = 2)
    private String sigla;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private Collection<Cidade> cidades;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Collection<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Collection<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return idEstado == estado.idEstado &&
                Objects.equals(nome, estado.nome) &&
                Objects.equals(sigla, estado.sigla) &&
                Objects.equals(cidades, estado.cidades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstado, nome, sigla, cidades);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
