package com.example.demo.mappers;

import com.example.demo.dtos.PedidoRequestDTO;
import com.example.demo.dtos.PedidoResponseDTO;
import com.example.demo.models.entities.Pedido;
import com.example.demo.models.enums.PedidoStatus;


import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {
    public static Pedido toEntity(PedidoRequestDTO dto){
        if(dto == null) return null;

        Pedido pedido = new Pedido();
        pedido.setMesa(dto.getMesa());
        pedido.setStatusPedido(PedidoStatus.valueOf(dto.getStatusPedido()));
        pedido.setItens(dto.getItens());
        return pedido;
    }

    public static PedidoResponseDTO toDTO(Pedido pedido){
        if(pedido == null) return null;
        PedidoResponseDTO pedidoDTO = new PedidoResponseDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setMesa(pedido.getMesa());
        pedidoDTO.setStatusPedido(pedido.getStatusPedido().toString());
        pedidoDTO.setDataHora(pedido.getDataHora());
        pedidoDTO.setTotal(pedido.getValorTotal());
        pedidoDTO.setItens(pedido.getItens());
        return pedidoDTO;
    }

    // Atualizar entidade existente a partir do DTO
    public static void updateEntity(Pedido pedido, PedidoRequestDTO dto) {
        if (pedido == null || dto == null) return;

        pedido.setMesa(dto.getMesa());
        pedido.setStatusPedido(PedidoStatus.valueOf(dto.getStatusPedido()));
        pedido.setItens(dto.getItens());

    }


    // Lista de entidades → Lista de DTO
    public static List<PedidoResponseDTO> toDTOList(List<Pedido> pedidos) {
        if (pedidos == null) return null;

        return pedidos.stream()
                .map(PedidoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
