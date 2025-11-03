package com.deusleydev.api_desafio_meli.controller;

import com.deusleydev.api_desafio_meli.domain.Produto;
import com.deusleydev.api_desafio_meli.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {
        var produtoCriado = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable UUID id,
                                          @RequestBody Produto produto) {
        produto.setId(id);

        var produtoAtualizado = produtoService.update(id, produto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(produtoAtualizado);

    }


    @GetMapping
    public List<Produto> findAll() {
        var todosProdutos = produtoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(todosProdutos).getBody();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Produto> delete(@PathVariable UUID id) {
        produtoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable UUID id) {
        var buscaId = produtoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(buscaId);
    }

}
