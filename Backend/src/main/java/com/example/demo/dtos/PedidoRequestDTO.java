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
    private List<ItemPedidoRequestDTO> itens;

    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(Integer mesa, String statusPedido, List<ItemPedidoRequestDTO> itens) {
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


    public List<ItemPedidoRequestDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoRequestDTO> itens) {
        this.itens = itens;
    }
}
