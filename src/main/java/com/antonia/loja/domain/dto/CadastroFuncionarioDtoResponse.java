package com.antonia.loja.domain.dto;

import com.antonia.loja.domain.CadastroFuncionario;
import com.antonia.loja.enums.Atividade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastroFuncionarioDtoResponse {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String telefone;
    private String atividade;
    private String loja;



    public static CadastroFuncionarioDtoResponse fromCadastroFuncionario(CadastroFuncionario funcionario) {
        CadastroFuncionarioDtoResponse dto = new CadastroFuncionarioDtoResponse();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setEmail(funcionario.getEmail());
        dto.setCpf(funcionario.getCpf());
        dto.setRg(funcionario.getRg());
        dto.setTelefone(funcionario.getTelefone());
        dto.setAtividade(Atividade.getDescricao(funcionario.getAtividade()));
        dto.setLoja(funcionario.getLoja());

        return dto;
    }

    public static List<CadastroFuncionarioDtoResponse> fromCadastroFuncionarios(List<CadastroFuncionario> funcionarios) {
        return funcionarios.stream()
                .map(CadastroFuncionarioDtoResponse::fromCadastroFuncionario)
                .collect(Collectors.toList());
    }
}
