package com.example.demo.service;

import com.example.demo.dtos.PedidoRequestDTO;
import com.example.demo.dtos.PedidoResponseDTO;
import com.example.demo.mappers.PedidoMapper;
import com.example.demo.models.entities.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {

        this.repository = repository;
    }

    public PedidoResponseDTO salvar(PedidoRequestDTO pedido) {

        Pedido pedidoEntity = PedidoMapper.toEntity(pedido);
        repository.save(pedidoEntity);

        return PedidoMapper.toDTO(pedidoEntity);
    }

    public List<PedidoResponseDTO> listarTodos() {
        List<Pedido> pedidos = repository.findAll();
        return PedidoMapper.toDTOList(pedidos);
    }

    public PedidoResponseDTO buscarPorId(Long id) {
        Pedido pedidoEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return PedidoMapper.toDTO(pedidoEntity);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
