package br.com.seguirapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Basic
    @Column(name = "senha", nullable = false, length = 32)
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("email='").append(getEmail()).append('\'');
        sb.append(", senha='").append(getSenha()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getEmail(), usuario.getEmail()) &&
                Objects.equals(getSenha(), usuario.getSenha());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
