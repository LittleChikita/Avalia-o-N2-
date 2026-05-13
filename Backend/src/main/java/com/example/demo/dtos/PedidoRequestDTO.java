package com.example.demo.dtos;

import com.example.demo.models.entities.ItemPedido;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

public class PedidoRequestDTO {

    @NotBlank(message = "Mesa é obrigatorio")
    private Integer mesa;

    @NotBlank(message = "Status do Pedido é obrigatorio")
    private String statusPedido;

    @NotBlank(message = "Lista de Itens é obrigatoria ")
    private List<ItemPedido> itens;

    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(Integer mesa, String statusPedido, List<ItemPedido> itens) {
        this.mesa = mesa;
        this.statusPedido = statusPedido;
        this.itens = itens;
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


    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
