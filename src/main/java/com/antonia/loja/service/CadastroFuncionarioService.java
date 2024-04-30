package com.antonia.loja.service;

import com.antonia.loja.domain.CadastroFuncionario;
import com.antonia.loja.domain.dto.CadastroFuncionarioDtoResponse;

import java.util.List;

public interface CadastroFuncionarioService {

    CadastroFuncionario salvarFuncionario(CadastroFuncionario funcionario);

    List<CadastroFuncionarioDtoResponse> listarFuncionarios();

    CadastroFuncionarioDtoResponse buscarFuncionarioPorId(Long id);


    CadastroFuncionario excluirFuncionarioPorId(Long id);

    CadastroFuncionario editarFuncionarioPorId(Long id, CadastroFuncionario funcionarioAtualizado);
}
