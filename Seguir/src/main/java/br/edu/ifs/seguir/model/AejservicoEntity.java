package br.edu.ifs.seguir.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AEJSERVICO", schema = "DBIFS", catalog = "")
public class AejservicoEntity {
    private int idServico;
    private double preco;
    private String descricao;

    @Id
    @Column(name = "idServico")
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    @Basic
    @Column(name = "preco")
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Basic
    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AejservicoEntity that = (AejservicoEntity) o;
        return idServico == that.idServico &&
                Double.compare(that.preco, preco) == 0 &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServico, preco, descricao);
    }
}
