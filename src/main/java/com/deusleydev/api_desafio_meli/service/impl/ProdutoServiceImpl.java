package com.deusleydev.api_desafio_meli.service.impl;

import com.deusleydev.api_desafio_meli.domain.Produto;
import com.deusleydev.api_desafio_meli.repository.ProdutoRepository;
import com.deusleydev.api_desafio_meli.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public Produto create(Produto produto) {
        var produtoCriado = produtoRepository.save(produto);
        return produtoCriado;
    }

    @Override
    public Produto update(UUID id, Produto produto) {
        return null;
    }

    @Override
    public Produto findById(UUID id) {
        return null;
    }

    @Override
    public List<Produto> findAll() {
        return List.of();
    }

    @Override
    public void delete(UUID id) {

    }
}
