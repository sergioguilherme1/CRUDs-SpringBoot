package com.spring.cruds.service;

import com.spring.cruds.entity.Departamento;
import com.spring.cruds.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento criarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento buscarDepartamentos(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public void deletarDepartamentos(Long id) {
        departamentoRepository.deleteById(id);
    }
}