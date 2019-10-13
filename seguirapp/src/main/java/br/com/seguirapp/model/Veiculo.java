package br.com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo", nullable = false)
    private int idVeiculo;

    @Basic
    @Column(name = "marca", nullable = false, length = 45)
    private String marca;

    @Basic
    @Column(name = "modelo", nullable = false, length = 45)
    private String modelo;

    @Basic
    @Column(name = "cor", nullable = false, length = 45)
    private String cor;

    @Basic
    @Column(name = "placa", nullable = false, length = 45)
    private String placa;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private Dispositivo dispositivo;

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Veiculo{");
        sb.append("idVeiculo=").append(getIdVeiculo());
        sb.append(", marca='").append(getMarca()).append('\'');
        sb.append(", modelo='").append(getModelo()).append('\'');
        sb.append(", cor='").append(getCor()).append('\'');
        sb.append(", placa='").append(getPlaca()).append('\'');
        sb.append(", dispositivo=").append(getDispositivo());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return getIdVeiculo() == veiculo.getIdVeiculo() &&
                Objects.equals(getMarca(), veiculo.getMarca()) &&
                Objects.equals(getModelo(), veiculo.getModelo()) &&
                Objects.equals(getCor(), veiculo.getCor()) &&
                Objects.equals(getPlaca(), veiculo.getPlaca()) &&
                Objects.equals(getDispositivo(), veiculo.getDispositivo());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
