package com.spring.cruds.controller;

import com.spring.cruds.entity.Livro;
import com.spring.cruds.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros(){
        List<Livro> request = livroService.listarLivros();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Livro> criarLivros(@RequestBody Livro livro){
        Livro request = livroService.criarLivros(livro);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livro.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
        Livro livro = livroService.buscarLivros(id);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id){
        livroService.deletarLivros(id);
        return ResponseEntity.noContent().build();
    }
}
