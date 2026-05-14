package com.example.demo.service;

import com.example.demo.dtos.ProdutoRequestDTO;
import com.example.demo.dtos.ProdutoResponseDTO;
import com.example.demo.mappers.ProdutoMapper;
import com.example.demo.models.entities.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoResponseDTO salvar(ProdutoRequestDTO produto) {

        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (produto.getPreco() == null || produto.getPreco().doubleValue() <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }

        Produto entity = ProdutoMapper.toEntity(produto);
        entity = repository.save(entity);
        return ProdutoMapper.toDTO(entity);
    }

    public List<ProdutoResponseDTO> listarTodos() {
        List<ProdutoResponseDTO> dtos = ProdutoMapper.toDTOList(repository.findAll());
        return dtos;
    }

    public ProdutoResponseDTO buscarPorId(Long id) {

        Produto produto = buscarEntidadePorId(id);

        return ProdutoMapper.toDTO(produto);
    }

    public Produto buscarEntidadePorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO produtoAtualizado) {
        Produto produto = buscarEntidadePorId(id);

        ProdutoMapper.updateEntity(produto,produtoAtualizado);
        produto = repository.save(produto);
        return ProdutoMapper.toDTO(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
