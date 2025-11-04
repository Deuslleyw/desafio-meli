package com.deusleydev.api_desafio_meli.service;

import com.deusleydev.api_desafio_meli.domain.Produto;
import com.deusleydev.api_desafio_meli.dto.ProdutoDTO;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

   Produto create (ProdutoDTO produtoDto);

   Produto update (UUID id, ProdutoDTO produtoDto);

   ProdutoDTO findById (UUID id);

   List<ProdutoDTO> findAll();

   void delete(UUID id);
}
