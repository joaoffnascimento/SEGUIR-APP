package br.com.seguirapp.model;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity(name = "estado")
public class Estado {

    /**
     * CIDADE
     *
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return getIdEstado() == estado.getIdEstado() &&
                Objects.equals(getNome(), estado.getNome()) &&
                Objects.equals(getSigla(), estado.getSigla());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Estado{");
        sb.append("idEstado=").append(getIdEstado());
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", sigla='").append(getSigla()).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
