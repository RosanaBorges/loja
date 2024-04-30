package com.antonia.loja.service;

import com.antonia.loja.domain.CadastroFuncionario;
import com.antonia.loja.domain.dto.LoginDto;

public interface AutenticacaoService {
    CadastroFuncionario login(LoginDto loginDto);
}
