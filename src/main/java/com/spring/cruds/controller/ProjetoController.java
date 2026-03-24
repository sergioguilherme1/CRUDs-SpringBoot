package com.spring.cruds.controller;

import com.spring.cruds.entity.Projeto;
import com.spring.cruds.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<Projeto>> listarTodos() {
        List<Projeto> request = projetoService.listarProjetos();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Projeto> criarProjeto(@RequestBody Projeto projeto) {
        Projeto request = projetoService.criarProjeto(projeto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id) {
        Projeto projeto = projetoService.buscarProjetos(id);
        return (projeto != null) ? ResponseEntity.ok(projeto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        if (projetoService.buscarProjetos(id) == null) {
            return ResponseEntity.notFound().build();
        }
        projetoService.deletarProjetos(id);
        return ResponseEntity.noContent().build();
    }
}