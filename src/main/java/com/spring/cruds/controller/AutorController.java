package com.spring.cruds.controller;

import com.spring.cruds.entity.Autor;
import com.spring.cruds.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores(){
        List<Autor> request = autorService.listarAutores();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor){
        Autor request = autorService.criarAutor(autor);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autor.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id){
        Autor autor = autorService.buscarAutores(id);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id){
        autorService.deletarAutores(id);
        return ResponseEntity.noContent().build();
    }
}

