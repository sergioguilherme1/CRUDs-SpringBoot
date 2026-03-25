package com.spring.cruds.controller;

import com.spring.cruds.entity.Departamento;
import com.spring.cruds.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> listarTodos() {
        List<Departamento> request = departamentoService.listarDepartamentos();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Departamento> criarDepartamento(@RequestBody Departamento departamento) {
        Departamento request = departamentoService.criarDepartamento(departamento);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id) {
        Departamento departamento = departamentoService.buscarDepartamentos(id);
        return (departamento != null) ? ResponseEntity.ok(departamento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        if (departamentoService.buscarDepartamentos(id) == null) {
            return ResponseEntity.notFound().build();
        }
        departamentoService.deletarDepartamentos(id);
        return ResponseEntity.noContent().build();
    }
}