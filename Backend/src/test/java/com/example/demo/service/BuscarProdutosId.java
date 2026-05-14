package com.example.demo.service;

import com.example.demo.dtos.ProdutoResponseDTO;
import com.example.demo.models.entities.Produto;
import com.example.demo.models.enums.ProdutoCategoria;
import com.example.demo.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class buscarProdutosId {

    @Test
    void deveBuscarProdutoPorIdComSucesso() {

        System.out.println("=== INICIANDO TESTE: buscar produto por ID ===");

        ProdutoRepository repository = Mockito.mock(ProdutoRepository.class);
        ProdutoService service = new ProdutoService(repository);

        Produto produto = new Produto(
                1L,
                "Pizza",
                "Grande",
                new BigDecimal("50.00"),
                ProdutoCategoria.COMIDA,
                true
        );

        System.out.println("Produto mock criado: " + produto.getNome());

        when(repository.findById(1L))
                .thenReturn(java.util.Optional.of(produto));

        System.out.println("Mock do repository configurado para ID 1");

        ProdutoResponseDTO response = service.buscarPorId(1L);

        System.out.println("Resposta retornada do service: " + response.getNome());

        assertNotNull(response);
        assertEquals("Pizza", response.getNome());

        System.out.println("=== TESTE FINALIZADO COM SUCESSO ===");
    }
}