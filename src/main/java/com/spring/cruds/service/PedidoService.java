package com.spring.cruds.service;

import com.spring.cruds.entity.Pedido;
import com.spring.cruds.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
    }

    public Pedido buscarPedido(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

}
