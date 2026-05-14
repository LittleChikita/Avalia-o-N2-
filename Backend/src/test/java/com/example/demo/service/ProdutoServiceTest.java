package com.example.demo.service;

import com.example.demo.dtos.ProdutoRequestDTO;
import com.example.demo.dtos.ProdutoResponseDTO;
import com.example.demo.models.entities.Produto;
import com.example.demo.models.enums.ProdutoCategoria;
import com.example.demo.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class ProdutoServiceTest {

    @Test
    void deveSalvarProduto() {

        ProdutoRepository repository = Mockito.mock(ProdutoRepository.class);

        ProdutoService service = new ProdutoService(repository);

        Produto produto = new Produto(
                1L,
                "Pizza",
                "Pizza Grande",
                new BigDecimal("50.00"),
                ProdutoCategoria.COMIDA,
                true
        );

        when(repository.save(Mockito.any(Produto.class)))
                .thenReturn(produto);

        ProdutoRequestDTO dto = new ProdutoRequestDTO();

        dto.setNome("Pizza");
        dto.setDescricao("Pizza Grande");
        dto.setPreco(new BigDecimal("50.00"));
        dto.setCategoria("COMIDA");

        ProdutoResponseDTO response = service.salvar(dto);

        assertNotNull(response);
        assertEquals("Pizza", response.getNome());
        assertEquals("COMIDA", response.getCategoria());
    }
}