package com.deusleydev.api_desafio_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDTO {

    private UUID id;
    private String nome;
    private String descricao;
    private Double valor;

}
