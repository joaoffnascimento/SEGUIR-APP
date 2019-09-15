package com.seguirapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Auth {
    private int idAuth;
    private String login;
    private String senha;
    private Collection<Pessoa> pessoasByIdAuth;

    @Id
    @Column(name = "id_auth", nullable = false)
    public int getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(int idAuth) {
        this.idAuth = idAuth;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "senha", nullable = false, length = 45)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auth auth = (Auth) o;
        return idAuth == auth.idAuth &&
                Objects.equals(login, auth.login) &&
                Objects.equals(senha, auth.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuth, login, senha);
    }

    @OneToMany(mappedBy = "authByIdAuth")
    public Collection<Pessoa> getPessoasByIdAuth() {
        return pessoasByIdAuth;
    }

    public void setPessoasByIdAuth(Collection<Pessoa> pessoasByIdAuth) {
        this.pessoasByIdAuth = pessoasByIdAuth;
    }
}
