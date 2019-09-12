package com.seguirapp.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "auth", schema = "DBIFS", catalog = "")
public class AuthModel {
    private int idAuth;
    private String login;
    private String senha;
    private Collection<PessoaModel> pessoasByIdAuth;

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
        AuthModel authModel = (AuthModel) o;
        return idAuth == authModel.idAuth &&
                Objects.equals(login, authModel.login) &&
                Objects.equals(senha, authModel.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuth, login, senha);
    }

    @OneToMany(mappedBy = "authByAuth")
    public Collection<PessoaModel> getPessoasByIdAuth() {
        return pessoasByIdAuth;
    }

    public void setPessoasByIdAuth(Collection<PessoaModel> pessoasByIdAuth) {
        this.pessoasByIdAuth = pessoasByIdAuth;
    }
}
