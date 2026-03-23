package com.spring.cruds.service;

import com.spring.cruds.entity.Autor;
import com.spring.cruds.entity.Livro;
import com.spring.cruds.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public Autor criarAutor(Autor autor){
        return autorRepository.save(autor);
    }

    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }

    public void deletarAutores(Long id){
        autorRepository.deleteById(id);
    }

    public Autor buscarAutores(Long id){
        return autorRepository.findById(id).orElse(null);
    }
}
