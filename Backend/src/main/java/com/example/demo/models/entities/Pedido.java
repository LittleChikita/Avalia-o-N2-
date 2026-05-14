package com.example.demo.models.entities;

import com.example.demo.models.enums.PedidoStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "Mesa")
    private Integer mesa;

    @Enumerated(EnumType.STRING)
    private PedidoStatus statusPedido;

    @Column(name = "Data_e_Hora")
    private LocalDateTime dataHora = LocalDateTime.now();

    @Column(nullable = false, name = "Valor_Total")
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens =  new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Long id, Integer mesa, PedidoStatus statusPedido, LocalDateTime dataHora, BigDecimal valorTotal) {
        this.id = id;
        this.mesa = mesa;
        this.statusPedido = statusPedido;
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
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

    public PedidoStatus getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(PedidoStatus statusPedido) {
        this.statusPedido = statusPedido;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
