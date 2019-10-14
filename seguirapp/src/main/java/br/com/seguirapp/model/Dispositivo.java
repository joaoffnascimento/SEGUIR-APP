package br.com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "dispositivo")
public class Dispositivo {

    /**
     * CIDADE
     * @author João F. F. Nascimento
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo", nullable = false)
    private int idDispositivo;

    @Basic
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Basic
    @Column(name = "identificador", nullable = false, length = 10)
    private String identificador;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localizacao", referencedColumnName = "id_localizacao", nullable = false)
    private Localizacao localizacao;

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dispositivo{");
        sb.append("idDispositivo=").append(getIdDispositivo());
        sb.append(", nome='").append(getNome()).append('\'');
        sb.append(", identificador='").append(getIdentificador()).append('\'');
        sb.append(", localizacao=").append(getLocalizacao());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispositivo that = (Dispositivo) o;
        return getIdDispositivo() == that.getIdDispositivo() &&
                Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getIdentificador(), that.getIdentificador()) &&
                Objects.equals(getLocalizacao(), that.getLocalizacao());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
