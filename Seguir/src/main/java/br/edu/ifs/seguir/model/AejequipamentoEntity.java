package br.edu.ifs.seguir.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AEJEQUIPAMENTO", schema = "DBIFS", catalog = "")
public class AejequipamentoEntity {
    private int idEquipamento;
    private String marca;
    private String identificador;

    @Id
    @Column(name = "idEquipamento")
    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @Basic
    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "identificador")
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
        AejequipamentoEntity that = (AejequipamentoEntity) o;
        return idEquipamento == that.idEquipamento &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipamento, marca, identificador);
    }
}
