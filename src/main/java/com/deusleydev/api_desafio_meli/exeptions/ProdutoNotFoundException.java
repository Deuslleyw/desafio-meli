package com.deusleydev.api_desafio_meli.exeptions;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(String message){
        super(message);
    }
}
