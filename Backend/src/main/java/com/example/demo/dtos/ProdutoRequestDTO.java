package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class ProdutoRequestDTO {

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    private String descricao;

    @NotBlank(message = "Preço é obrigatorio")
    private BigDecimal preco;

    @NotBlank(message = "Categoria é obrigatorio")
    private String categoria;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, String descricao, BigDecimal preco, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
