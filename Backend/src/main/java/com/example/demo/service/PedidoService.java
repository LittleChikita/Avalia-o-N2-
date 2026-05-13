package com.example.demo.service;

import com.example.demo.dtos.ItemPedidoRequestDTO;
import com.example.demo.dtos.PedidoRequestDTO;
import com.example.demo.dtos.PedidoResponseDTO;
import com.example.demo.mappers.PedidoMapper;
import com.example.demo.models.entities.ItemPedido;
import com.example.demo.models.entities.Pedido;
import com.example.demo.models.entities.Produto;
import com.example.demo.models.enums.PedidoStatus;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository repository, ProdutoRepository produtoRepository) {

        this.repository = repository;
        this.produtoRepository = produtoRepository;
    }

    public PedidoResponseDTO salvar(PedidoRequestDTO dto) {

        Pedido pedido = new Pedido();

        pedido.setMesa(dto.getMesa());

        List<ItemPedido> itens = new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;

        for(ItemPedidoRequestDTO itemDTO : dto.getItens()) {

            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() ->
                            new RuntimeException("Produto não encontrado"));

            ItemPedido item = new ItemPedido();

            item.setProduto(produto);

            item.setQuantidade(itemDTO.getQuantidade());

            BigDecimal subtotal =
                    produto.getPreco()
                            .multiply(BigDecimal.valueOf(itemDTO.getQuantidade()));

            item.setSubTotal(subtotal);

            item.setPedido(pedido);

            itens.add(item);

            total = total.add(subtotal);
        }

        pedido.setStatusPedido(PedidoStatus.valueOf(dto.getStatusPedido()));

        pedido.setItens(itens);

        pedido.setValorTotal(total);

        repository.save(pedido);

        return PedidoMapper.toDTO(pedido);
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
