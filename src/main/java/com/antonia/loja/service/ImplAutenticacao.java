package com.antonia.loja.service;

import com.antonia.loja.domain.CadastroFuncionario;
import com.antonia.loja.domain.dto.LoginDto;
import com.antonia.loja.exception.FuncionarioNaoEncontradoException;
import com.antonia.loja.exception.SenhaInvalidaException;
import com.antonia.loja.repository.CadastroFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplAutenticacao implements AutenticacaoService {
    @Autowired
    private CadastroFuncionarioRepository cadastroFuncionarioRepository;

    @Override
    public CadastroFuncionario login(LoginDto loginDto) {
        CadastroFuncionario cadastroFuncionario = cadastroFuncionarioRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Não foi Localizado Funcionário para o e-mail:" + loginDto.getEmail()));

        if (!loginDto.getSenha().equalsIgnoreCase(cadastroFuncionario.getSenha())) {
            throw new SenhaInvalidaException("Senha incorreta");
        }
        return cadastroFuncionario;
    }
}
