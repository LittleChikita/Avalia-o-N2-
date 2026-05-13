package com.example.demo.controller;

import com.example.demo.dtos.PedidoRequestDTO;
import com.example.demo.dtos.PedidoResponseDTO;
import com.example.demo.models.entities.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public PedidoResponseDTO salvar(@RequestBody PedidoRequestDTO pedido) {
        return service.salvar(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
