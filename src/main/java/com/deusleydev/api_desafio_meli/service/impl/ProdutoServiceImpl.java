package com.deusleydev.api_desafio_meli.service.impl;

import com.deusleydev.api_desafio_meli.domain.Produto;
import com.deusleydev.api_desafio_meli.exeptions.ProdutoNotFoundException;
import com.deusleydev.api_desafio_meli.repository.ProdutoRepository;
import com.deusleydev.api_desafio_meli.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        var produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado! ID: " + id));
        var produtoAtualizado = produtoRepository.save(produto);

        return produtoAtualizado;
    }

    @Override
    public Produto findById(UUID id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(()-> new ProdutoNotFoundException(
                "Ops! Produto não encontrado com esse ID: " + id));
    }

    @Override
    public List<Produto> findAll() {
        var todosProdutos = produtoRepository.findAll();
        return todosProdutos;
    }

    @Override
    public void delete(UUID id) {
        var produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(
                        " Erro ao deletar, Produto não encontrado com esse id: " + id));
        produtoRepository.deleteById(id);

    }
}
