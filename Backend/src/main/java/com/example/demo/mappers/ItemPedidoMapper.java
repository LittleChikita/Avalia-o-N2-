package com.example.demo.mappers;

import com.example.demo.dtos.ItemPedidoRequestDTO;
import com.example.demo.dtos.ItemPedidoResponseDTO;
import com.example.demo.models.entities.ItemPedido;
import com.example.demo.models.entities.Produto;
import java.util.List;
import java.util.stream.Collectors;

public class ItemPedidoMapper {

    public static ItemPedido toEntity(ItemPedidoRequestDTO dto) {

        ItemPedido item = new ItemPedido();

        item.setQuantidade(dto.getQuantidade());

        Produto produto = new Produto();
        produto.setId(dto.getProdutoId());

        item.setProduto(produto);

        return item;
    }

    public static ItemPedidoResponseDTO toDTO(ItemPedido item) {

        ItemPedidoResponseDTO dto =
                new ItemPedidoResponseDTO();

        dto.setId(item.getId());

        dto.setQuantidade(item.getQuantidade());

        dto.setSubtotal(item.getSubTotal());

        if(item.getProduto() != null) {

            dto.setProdutoId(item.getProduto().getId());

            dto.setNomeProduto(item.getProduto().getNome());

            dto.setPrecoUnitario(item.getProduto().getPreco());
        }

        return dto;
    }

    public static List<ItemPedido> toEntityList(
            List<ItemPedidoRequestDTO> itensDTO) {

        return itensDTO.stream()
                .map(ItemPedidoMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static List<ItemPedidoResponseDTO> toDTOList(
            List<ItemPedido> itens) {

        return itens.stream()
                .map(ItemPedidoMapper::toDTO)
                .collect(Collectors.toList());
    }
}