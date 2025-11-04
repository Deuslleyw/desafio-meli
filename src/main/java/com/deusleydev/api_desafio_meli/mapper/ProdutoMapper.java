package com.deusleydev.api_desafio_meli.mapper;

import com.deusleydev.api_desafio_meli.domain.Produto;
import com.deusleydev.api_desafio_meli.dto.ProdutoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoDTO fromProduto(Produto produto);
    Produto toProduto(ProdutoDTO produtoDTO);
    List<ProdutoDTO> toDtoList(List<Produto> produtos);
}
