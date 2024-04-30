package com.antonia.loja.controller;

import com.antonia.loja.domain.CadastroFuncionario;
import com.antonia.loja.domain.dto.CadastroFuncionarioDtoResponse;
import com.antonia.loja.service.CadastroFuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/funcionario")

public class CadastroFuncionarioController {

    @Autowired
    private CadastroFuncionarioService cadastroFuncionarioService;

    @PostMapping("/salvar")
    public ResponseEntity<CadastroFuncionario> salvarFuncionario(@RequestBody @Valid CadastroFuncionario funcionario) {
        cadastroFuncionarioService.salvarFuncionario(funcionario);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    @GetMapping("/funcionarios")
    public ResponseEntity<List<CadastroFuncionarioDtoResponse>> listarFuncionarios() {
        List<CadastroFuncionarioDtoResponse> funcionarios = cadastroFuncionarioService.listarFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<CadastroFuncionarioDtoResponse> buscarFuncionarioPorId(@PathVariable Long id) {
        CadastroFuncionarioDtoResponse funcionario = cadastroFuncionarioService.buscarFuncionarioPorId(id);
        if (funcionario != null) {
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Void> excluirFuncionarioPorId(@PathVariable Long id) {
        cadastroFuncionarioService.excluirFuncionarioPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastroFuncionario> editarFuncionarioPorId(@PathVariable Long id, @RequestBody @Valid CadastroFuncionario funcionarioAtualizado) {

        CadastroFuncionario funcionarioEditado = cadastroFuncionarioService.editarFuncionarioPorId(id, funcionarioAtualizado);
        return new ResponseEntity<>(funcionarioEditado, HttpStatus.OK);
    }
}

