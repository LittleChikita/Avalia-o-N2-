package com.example.demo.controller;

import com.example.demo.dtos.PedidoRequestDTO;
import com.example.demo.dtos.PedidoResponseDTO;
import com.example.demo.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
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
    public List<PedidoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PedidoResponseDTO atualizarStatus(
            @PathVariable Long id,
            @RequestBody PedidoRequestDTO pedido) {

        return service.atualizar(id, pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
