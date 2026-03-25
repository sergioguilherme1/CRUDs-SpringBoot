package com.spring.cruds.service;

import com.spring.cruds.entity.Fornecedor;
import com.spring.cruds.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor buscarFornecedor(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}