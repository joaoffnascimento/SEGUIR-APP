package br.com.seguirapp.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Basic
    @Column(name = "senha", nullable = false, length = 32)
    private String senha;
}
