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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dispositivo", referencedColumnName = "id_dispositivo")
    private Dispositivo dispositivo;

    public Localizacao(){

    }

    public Localizacao(String latitude, String longitude, String velocidade, Date horario) {
        this.horario = horario;
        this.latitude = latitude;
        this.longitude = longitude;
        this.velocidade = velocidade;
    }

    public Localizacao(String latitude, String longitude, String velocidade, Date horario, Dispositivo dispositivo) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.velocidade = velocidade;
        this.horario = horario;
        this.dispositivo = dispositivo;
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

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return getIdLocalizacao() == that.getIdLocalizacao() &&
                Objects.equals(getLatitude(), that.getLatitude()) &&
                Objects.equals(getLongitude(), that.getLongitude()) &&
                Objects.equals(getVelocidade(), that.getVelocidade()) &&
                Objects.equals(getHorario(), that.getHorario()) &&
                Objects.equals(getDispositivo(), that.getDispositivo());
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Localizacao{");
        sb.append("idLocalizacao=").append(getIdLocalizacao());
        sb.append(", latitude='").append(getLatitude()).append('\'');
        sb.append(", longitude='").append(getLongitude()).append('\'');
        sb.append(", velocidade='").append(getVelocidade()).append('\'');
        sb.append(", horario=").append(getHorario());
        sb.append(", dispositivo=").append(getDispositivo());
        sb.append('}');
        return sb.toString();
    }
}
