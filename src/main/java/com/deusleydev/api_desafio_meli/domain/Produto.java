package com.deusleydev.api_desafio_meli.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "PRODUTOS")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Nome do Produto")
    @Size(max = 120)
    private String nome;

    @Column(name = "Descrição do Produto")
    @Size(max = 250)
    private String descricao;

    @Column(name = "Valor do Produto")
    private Double valor;
}
