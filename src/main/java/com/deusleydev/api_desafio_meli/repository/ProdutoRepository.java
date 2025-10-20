package com.deusleydev.api_desafio_meli.repository;

import com.deusleydev.api_desafio_meli.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, UUID>{
}
