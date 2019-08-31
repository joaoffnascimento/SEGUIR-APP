package com.seguirapp.model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author João Felipe Fonseca Nascimento
 * @since 25/08/2019
 */
public class Empresa {
    private int idEmpresa;
    private String nome;
    private String cnpj;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idEmpresa;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (this.idEmpresa != other.idEmpresa) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nome=" + nome + ", cnpj=" + cnpj + '}';
    } 
}
