package com.antonia.loja.exception;

public class SenhaConfirmacaoInvalidaException extends RuntimeException {
    public SenhaConfirmacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
