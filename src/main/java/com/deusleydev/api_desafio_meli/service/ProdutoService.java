package com.deusleydev.api_desafio_meli.service;

import com.deusleydev.api_desafio_meli.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

   Produto create (Produto produto);

   Produto update (UUID id, Produto produto);

   Produto findById (UUID id);

   List<Produto> findAll();

   void delete(UUID id);
}
