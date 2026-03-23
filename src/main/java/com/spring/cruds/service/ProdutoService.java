package com.spring.cruds.service;

import com.spring.cruds.entity.Produto;
import com.spring.cruds.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProdutos(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public void deletarProdutos(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto buscarProduto(Long id){
        return  produtoRepository.findById(id).orElse(null);
    }
}

