package com.antonia.loja.exception;

public class FuncionarioNaoEncontradoException extends RuntimeException {

    public FuncionarioNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
