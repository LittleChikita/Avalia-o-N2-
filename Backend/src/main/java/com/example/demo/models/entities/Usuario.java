package com.example.demo.models.entities;

import com.example.demo.models.enums.UsuarioCargo;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "Nome")
    private String nome;

    @Column(unique = true, nullable = false, name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    private UsuarioCargo cargo;

    @Column(nullable = false, name = "Senha")
    private String senha;

    public Usuario(long id, String nome, String email, UsuarioCargo cargo, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioCargo getCargo() {
        return cargo;
    }

    public void setCargo(UsuarioCargo cargo) {
        this.cargo = cargo;
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
}
