package com.example.demo.mappers;

import com.example.demo.dtos.ProdutoRequestDTO;
import com.example.demo.dtos.ProdutoResponseDTO;
import com.example.demo.models.entities.Produto;
import com.example.demo.models.enums.ProdutoCategoria;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequestDTO dto){
        if(dto == null) return null;

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(ProdutoCategoria.valueOf(dto.getCategoria()));
        return produto;
    }

    public static ProdutoResponseDTO toDTO(Produto produto){
        if(produto == null) return null;
        ProdutoResponseDTO produtoDTO = new ProdutoResponseDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setDisponivel(produto.isDisponivel());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setCategoria(produto.getCategoria().toString());
        return produtoDTO;
    }

    // Atualizar entidade existente a partir do DTO
    public static void updateEntity(Produto produto, ProdutoRequestDTO dto) {
        if (produto == null || dto == null) return;

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(ProdutoCategoria.valueOf(dto.getCategoria()));

    }


    // Lista de entidades → Lista de DTO
    public static List<ProdutoResponseDTO> toDTOList(List<Produto> produtos) {
        if (produtos == null) return null;

        return produtos.stream()
                .map(ProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
