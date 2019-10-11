package br.com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "veiculo")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return idVeiculo == veiculo.idVeiculo &&
                Objects.equals(marca, veiculo.marca) &&
                Objects.equals(modelo, veiculo.modelo) &&
                Objects.equals(cor, veiculo.cor) &&
                Objects.equals(placa, veiculo.placa) &&
                Objects.equals(dispositivo, veiculo.dispositivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVeiculo, marca, modelo, cor, placa, dispositivo);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", placa='" + placa + '\'' +
                ", dispositivo=" + dispositivo +
                '}';
    }
}
