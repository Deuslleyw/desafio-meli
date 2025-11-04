package com.deusleydev.api_desafio_meli.service.impl;

import com.deusleydev.api_desafio_meli.domain.Produto;
import com.deusleydev.api_desafio_meli.dto.ProdutoDTO;
import com.deusleydev.api_desafio_meli.exeptions.ProdutoNotFoundException;
import com.deusleydev.api_desafio_meli.mapper.ProdutoMapper;
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

    @Autowired
    private ProdutoMapper produtoMapper;


    @Override
    public Produto create(ProdutoDTO produtoDto) {
        var convertedProduto = produtoMapper.toProduto(produtoDto);
        var produtoCriado = produtoRepository.save(convertedProduto);
        return produtoCriado;
    }

    @Override
    public Produto update(UUID id, ProdutoDTO produtoDto) {
        var produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado! ID: " + id));
        var convertedProduto = produtoMapper.toProduto(produtoDto);
        var produtoAtualizado = produtoRepository.save(convertedProduto);
        return produtoAtualizado;
    }

    @Override
    public ProdutoDTO findById(UUID id) {
        var produto = produtoRepository.findById(id)
        .orElseThrow(()-> new ProdutoNotFoundException(
                "Ops! Produto não encontrado com esse ID: " + id));
        var convertedProduto = produtoMapper.fromProduto(produto);
        return convertedProduto;
    }

    @Override
    public List<ProdutoDTO> findAll() {
        var todosProdutos = produtoRepository.findAll();
        var convertedProduto = produtoMapper.toDtoList(todosProdutos);
        return convertedProduto;
    }

    @Override
    public void delete(UUID id) {
        var produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(
                        " Erro ao deletar, Produto não encontrado com esse id: " + id));
        produtoRepository.deleteById(id);

    }
}
