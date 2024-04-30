package com.antonia.loja.exception;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
