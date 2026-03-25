package com.spring.cruds.service;

import com.spring.cruds.entity.Projeto;
import com.spring.cruds.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> listarProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto criarProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto buscarProjetos(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    public void deletarProjetos(Long id) {
        projetoRepository.deleteById(id);
    }
}