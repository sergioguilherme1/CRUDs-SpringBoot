package com.spring.cruds.service;

import com.spring.cruds.entity.Tarefa;
import com.spring.cruds.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa buscarTarefas(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public void deletarTarefas(Long id) {
        tarefaRepository.deleteById(id);
    }
}