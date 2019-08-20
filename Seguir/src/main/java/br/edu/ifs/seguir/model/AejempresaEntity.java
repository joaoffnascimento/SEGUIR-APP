package br.edu.ifs.seguir.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AEJEMPRESA", schema = "DBIFS", catalog = "")
public class AejempresaEntity {
    private int idEmpresa;
    private String nome;
    private String cnpj;

    @Id
    @Column(name = "idEmpresa")
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "cnpj")
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AejempresaEntity that = (AejempresaEntity) o;
        return idEmpresa == that.idEmpresa &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, nome, cnpj);
    }
}
