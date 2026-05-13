package com.example.demo.models.entities;

import com.example.demo.models.enums.ProdutoCategoria;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(nullable = false, name = "Nome")
    private String nome;

    @Column(nullable = false, name = "Descrição")
    private String descricao;

    @Column(nullable = false, name = "Valor")
    private BigDecimal preco;;

    @Enumerated(EnumType.STRING)
    private ProdutoCategoria categoria;

    @Column(nullable = false, name = "Disponivel")
    private boolean disponivel = true;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, BigDecimal preco, ProdutoCategoria categoria, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProdutoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ProdutoCategoria categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
