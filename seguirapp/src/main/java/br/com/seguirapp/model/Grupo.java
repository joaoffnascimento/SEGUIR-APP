package br.com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo", nullable = false)
    private int idGrupo;

    @Basic
    @Column(name = "empresa", nullable = false, length = 45)
    private String empresa;

    public Grupo(String empresa){
        this.empresa = empresa;
    }

    public Grupo(){

    }

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
    public String toString() {
        final StringBuffer sb = new StringBuffer("Grupo{");
        sb.append("idGrupo=").append(getIdGrupo());
        sb.append(", empresa='").append(getEmpresa()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return getIdGrupo() == grupo.getIdGrupo() &&
                Objects.equals(getEmpresa(), grupo.getEmpresa());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
