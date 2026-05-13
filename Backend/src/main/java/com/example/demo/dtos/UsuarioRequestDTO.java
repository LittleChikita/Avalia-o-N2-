package com.example.demo.dtos;

import com.example.demo.models.enums.UsuarioCargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;
    @Email(message = "Para ser valido deve conter (@exemplo.com)")
    @NotBlank(message = "E-mail é obrigatorio")
    private String email;
    @NotBlank(message = "Cargo é obrigatorio")
    private UsuarioCargo cargo;
    @NotBlank(message = "Senha é obrigatroia")
    private String senha;

    public UsuarioRequestDTO() {}

    public UsuarioRequestDTO(String nome, String email, UsuarioCargo cargo, String senha) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioCargo getCargo() {
        return cargo;
    }

    public void setCargo(UsuarioCargo cargo) {
        this.cargo = cargo;
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
