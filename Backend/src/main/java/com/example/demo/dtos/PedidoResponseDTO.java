package com.example.demo.dtos;

import com.example.demo.models.entities.ItemPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDTO {
    private Long id;
    private Integer mesa;
    private String statusPedido;
    private LocalDateTime dataHora;
    private BigDecimal total;
    private List<ItemPedido> itens;

    public PedidoResponseDTO() {
    }

    public PedidoResponseDTO(Long id, Integer mesa, String statusPedido, LocalDateTime dataHora, BigDecimal total, List<ItemPedido> itens) {
        this.id = id;
        this.mesa = mesa;
        this.statusPedido = statusPedido;
        this.dataHora = dataHora;
        this.total = total;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
