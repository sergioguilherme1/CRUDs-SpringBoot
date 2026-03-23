package com.spring.cruds.service;

import com.spring.cruds.entity.Livro;
import com.spring.cruds.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro criarLivros(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }

    public void deletarLivros(Long id){
        livroRepository.deleteById(id);
    }

    public Livro buscarLivros(Long id){
        return livroRepository.findById(id).orElse(null);
    }
}
