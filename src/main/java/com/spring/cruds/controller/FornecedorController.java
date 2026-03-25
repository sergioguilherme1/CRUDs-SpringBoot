package com.spring.cruds.controller;

import com.spring.cruds.entity.Fornecedor;
import com.spring.cruds.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarTodos() {
        List<Fornecedor> request = fornecedorService.listarFornecedores();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor request = fornecedorService.criarFornecedor(fornecedor);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedor(id);
        return (fornecedor != null) ? ResponseEntity.ok(fornecedor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        if (fornecedorService.buscarFornecedor(id) == null) {
            return ResponseEntity.notFound().build();
        }
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}