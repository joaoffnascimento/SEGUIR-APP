package br.com.seguirapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "dispositivo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    public Dispositivo(){

    }

    public Dispositivo(int idDispositivo){
        this.idDispositivo = idDispositivo;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispositivo that = (Dispositivo) o;
        return getIdDispositivo() == that.getIdDispositivo() &&
                Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getIdentificador(), that.getIdentificador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDispositivo(), getNome(), getIdentificador());
    }

    @Override
    public String
    toString() {
        final StringBuffer sb = new StringBuffer("Dispositivo{");
        sb.append("idDispositivo=").append(idDispositivo);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", identificador='").append(identificador).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
