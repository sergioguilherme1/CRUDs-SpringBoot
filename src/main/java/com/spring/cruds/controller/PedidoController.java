package com.spring.cruds.controller;

import com.spring.cruds.entity.Pedido;
import com.spring.cruds.service.PedidoService;
import jakarta.servlet.Servlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> request = pedidoService.listarPedidos();
        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id){
        Pedido pedido = pedidoService.buscarPedido(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(Pedido pedido){
        Pedido request = pedidoService.criarPedido(pedido);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedido.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping
    public ResponseEntity<?> deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
