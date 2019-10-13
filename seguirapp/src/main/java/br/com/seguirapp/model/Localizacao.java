package br.com.seguirapp.model;

import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "localizacao")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacao")
    private int idLocalizacao;

    @Basic
    @Column(name = "latitude", nullable = false, length = 255)
    private int latitude;

    @Basic
    @Column(name = "longitude", nullable = false, length = 255)
    private int longitude;

    @Basic
    @Column(name = "velocidade", nullable = false, length = 255)
    private int velocidade;

    @Basic
    @Column(name = "horario", nullable = false)
    private Date horario;

    public int getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(int idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Localizacao{");
        sb.append("idLocalizacao=").append(getIdLocalizacao());
        sb.append(", latitude=").append(getLatitude());
        sb.append(", longitude=").append(getLongitude());
        sb.append(", velocidade=").append(getVelocidade());
        sb.append(", horario=").append(getHorario());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return getIdLocalizacao() == that.getIdLocalizacao() &&
                getLatitude() == that.getLatitude() &&
                getLongitude() == that.getLongitude() &&
                getVelocidade() == that.getVelocidade() &&
                Objects.equals(getHorario(), that.getHorario());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
