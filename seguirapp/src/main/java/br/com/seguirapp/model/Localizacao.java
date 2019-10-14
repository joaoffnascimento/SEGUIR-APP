package br.com.seguirapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Column(name = "latitude", nullable = false, length = 45)
    private String latitude;

    @Basic
    @Column(name = "longitude", nullable = false, length = 45)
    private String longitude;

    @Basic
    @Column(name = "velocidade", nullable = false, length = 45)
    private String velocidade;

    @Basic
    @Column(name = "horario", nullable = false)
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private Date horario;

    public Localizacao(){

    }

    public Localizacao(String latitude, String longitude, String velocidade, Date horario) {
        this.horario = horario;
        this.latitude = latitude;
        this.longitude = longitude;
        this.velocidade = velocidade;
    }

    public int getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(int idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(String velocidade) {
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
