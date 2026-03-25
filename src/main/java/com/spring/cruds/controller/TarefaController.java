package com.spring.cruds.controller;

import com.spring.cruds.entity.Tarefa;
import com.spring.cruds.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodas() {
        List<Tarefa> request = tarefaService.listarTarefas();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa request = tarefaService.criarTarefa(tarefa);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(request.getId())
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.buscarTarefas(id);
        return (tarefa != null) ? ResponseEntity.ok(tarefa) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPorId(@PathVariable Long id) {
        if (tarefaService.buscarTarefas(id) == null) {
            return ResponseEntity.notFound().build();
        }
        tarefaService.deletarTarefas(id);
        return ResponseEntity.noContent().build();
    }
}