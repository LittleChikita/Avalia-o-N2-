package com.example.demo.service;

import com.example.demo.dtos.ProdutoRequestDTO;
import com.example.demo.dtos.ProdutoResponseDTO;
import com.example.demo.models.entities.Produto;
import com.example.demo.models.enums.ProdutoCategoria;
import com.example.demo.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ProdutoServiceTest {

    @Test
    void deveFalharQuandoNomeEstiverVazio() {

        ProdutoRepository repository = Mockito.mock(ProdutoRepository.class);
        ProdutoService service = new ProdutoService(repository);

        ProdutoRequestDTO dto = new ProdutoRequestDTO();
        dto.setNome("");
        dto.setDescricao("Grande");
        dto.setPreco(new BigDecimal("50.00"));
        dto.setCategoria("COMIDA");

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.salvar(dto)
        );
        System.out.println("Exceção capturada: " + ex.getMessage());

        assertEquals("Nome inválido", ex.getMessage());

        System.out.println("Teste finalizado com sucesso");
    }
}