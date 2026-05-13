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
        Produto entity = ProdutoMapper.toEntity(produto);
        entity = repository.save(entity);
        return ProdutoMapper.toDTO(entity);
    }

    public List<ProdutoResponseDTO> listarTodos() {
        List<ProdutoResponseDTO> dtos = ProdutoMapper.toDTOList(repository.findAll());
        return dtos;
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO produtoAtualizado) {
        Produto produto = buscarPorId(id);
        Produto entity = ProdutoMapper.toEntity(produtoAtualizado);
        entity = repository.save(entity);
        return ProdutoMapper.toDTO(entity);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
