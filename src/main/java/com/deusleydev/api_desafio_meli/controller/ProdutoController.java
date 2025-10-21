package com.deusleydev.api_desafio_meli.controller;

import com.deusleydev.api_desafio_meli.domain.Produto;
import com.deusleydev.api_desafio_meli.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create (@RequestBody Produto produto){
        var produtoCriado = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);

    }


}
