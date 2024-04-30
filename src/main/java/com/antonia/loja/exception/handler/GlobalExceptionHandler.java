package com.antonia.loja.exception.handler;

import com.antonia.loja.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> tratamentoExcecaoValidacao(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String atributo = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();
            errors.put(atributo, mensagem);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FuncionarioNaoEncontradoException.class)
    public Map<String, String> funcionarioNotFoundException(FuncionarioNaoEncontradoException exception) {
        Map<String, String> errorMap = new HashMap<String, String>();
        errorMap.put("mensagem", exception.getMessage());

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SenhaConfirmacaoInvalidaException.class)
    public Map<String, String> senhaConfirmacaoInvalidaException(SenhaConfirmacaoInvalidaException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", exception.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SenhaInvalidaException.class)
    public Map<String, String> senhaInvalidaException(SenhaInvalidaException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", exception.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailJaExisteException.class)
    public Map<String, String> emailInvalidoException(EmailJaExisteException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", exception.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CPFJaExisteException.class)
    public Map<String, String> cpfJaExisteException(CPFJaExisteException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("mensagem", exception.getMessage());
        return errorMap;
    }

}
