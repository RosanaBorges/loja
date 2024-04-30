package com.antonia.loja.controller;

import com.antonia.loja.domain.CadastroFuncionario;
import com.antonia.loja.domain.dto.LoginDto;
import com.antonia.loja.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/autenticacao")
public class AutenticacaoController {
    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            CadastroFuncionario cadastroFuncionario = autenticacaoService.login(loginDto);
            return ResponseEntity.ok(cadastroFuncionario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
