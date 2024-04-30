package com.antonia.loja.service;

import com.antonia.loja.domain.CadastroFuncionario;
import com.antonia.loja.domain.dto.CadastroFuncionarioDtoResponse;
import com.antonia.loja.exception.*;
import com.antonia.loja.repository.CadastroFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplCadastroFuncionario implements CadastroFuncionarioService {
    @Autowired
    private CadastroFuncionarioRepository cadastroFuncionarioRepository;

    @Override
    public CadastroFuncionario salvarFuncionario(CadastroFuncionario funcionario) {
        validarSenha(funcionario);

        if (cadastroFuncionarioRepository.existsByEmail(funcionario.getEmail())) {
            throw new EmailJaExisteException("E-mail do funcionario já cadastrado:" + funcionario.getEmail());
        }
        if (cadastroFuncionarioRepository.existsByCpf(funcionario.getCpf())) {
            throw new CPFJaExisteException("CPF do funcionario já cadastrado:" + funcionario.getCpf());
        }
        return cadastroFuncionarioRepository.save(funcionario);
    }

    @Override
    public List<CadastroFuncionarioDtoResponse> listarFuncionarios() {
        List<CadastroFuncionario> funcionarios = cadastroFuncionarioRepository.findAll();
        return CadastroFuncionarioDtoResponse.fromCadastroFuncionarios(funcionarios);
    }

    @Override
    public CadastroFuncionarioDtoResponse buscarFuncionarioPorId(Long id) {
        CadastroFuncionario funcionario = cadastroFuncionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com o ID " + id + " não encontrado."));
        return CadastroFuncionarioDtoResponse.fromCadastroFuncionario(funcionario);
    }

    @Override
    public CadastroFuncionario excluirFuncionarioPorId(Long id) {
        Optional<CadastroFuncionario> funcionarioOptional = cadastroFuncionarioRepository.findById(id);

        if (funcionarioOptional.isPresent()) {
            CadastroFuncionario funcionario = funcionarioOptional.get();
            cadastroFuncionarioRepository.deleteById(id);
            return funcionario;
        } else {
            throw new FuncionarioNaoEncontradoException("Funcionário com o ID " + id + " não encontrado.");
        }
    }

    @Override
    public CadastroFuncionario editarFuncionarioPorId(Long id, CadastroFuncionario funcionarioAtualizado) {
        Optional<CadastroFuncionario> funcionarioOptional = cadastroFuncionarioRepository.findById(id);

        if (funcionarioOptional.isPresent()) {
            CadastroFuncionario funcionario = funcionarioOptional.get();

            String novoEmail = funcionarioAtualizado.getEmail();
            if (!funcionario.getEmail().equals(novoEmail) && cadastroFuncionarioRepository.existsByEmail(novoEmail)) {
                throw new EmailJaExisteException("O e-mail " + novoEmail + " já está sendo usado por outro funcionário.");
            }

            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setEmail(funcionarioAtualizado.getEmail());
            funcionario.setCpf(funcionarioAtualizado.getCpf());
            funcionario.setRg(funcionarioAtualizado.getRg());
            funcionario.setTelefone(funcionarioAtualizado.getTelefone());
            funcionario.setAtividade(funcionarioAtualizado.getAtividade());
            funcionario.setLoja(funcionarioAtualizado.getLoja());
            funcionario.setSenha(funcionarioAtualizado.getSenha());
            funcionario.setSenhaConfirmacao(funcionarioAtualizado.getSenhaConfirmacao());

            if (funcionarioAtualizado.getSenhaConfirmacao() != null) {
                validarSenha(funcionarioAtualizado);
            }

            return cadastroFuncionarioRepository.save(funcionario);
        } else {
            throw new FuncionarioNaoEncontradoException("Funcionário com o ID " + id + " não encontrado.");
        }
    }


    private void validarSenha(CadastroFuncionario funcionario) {
        String senha = funcionario.getSenha();
        String confirmacaoSenha = funcionario.getSenhaConfirmacao();

        // Verifica se a senha e a confirmação de senha são nulas ou vazias
        if (senha == null || senha.isEmpty() || confirmacaoSenha == null || confirmacaoSenha.isEmpty()) {
            throw new SenhaInvalidaException("Por favor insira uma senha e confirme-a.");
        }

        // Verifica se a senha e a confirmação de senha coincidem
        if (!senha.equals(confirmacaoSenha)) {
            throw new SenhaConfirmacaoInvalidaException("A senha e a confirmação de senha não coincidem.");
        }

        // Verifica se a senha atende aos critérios de validação
        if (senha.length() < 6 || !senha.matches(".*[A-Z].*") || !senha.matches(".*\\d.*")) {
            throw new SenhaInvalidaException("A senha deve conter pelo menos 6 caracteres, uma letra maiúscula e um número.");
        }
    }
}




