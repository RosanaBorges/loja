package com.antonia.loja.exception;

public class CPFJaExisteException extends RuntimeException{

    public CPFJaExisteException(String mensagem) {
        super(mensagem);
    }
}
