package br.com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo", nullable = false)
    private int idGrupo;

    @Basic
    @Column(name = "empresa", nullable = false, length = 45)
    private String empresa;

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return idGrupo == grupo.idGrupo &&
                Objects.equals(empresa, grupo.empresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrupo, empresa);
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "empresa='" + empresa + '\'' +
                '}';
    }
}
