package com.spring.cruds.service;

import com.spring.cruds.entity.Categoria;
import com.spring.cruds.entity.Livro;
import com.spring.cruds.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria buscarCategoria(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }
}

