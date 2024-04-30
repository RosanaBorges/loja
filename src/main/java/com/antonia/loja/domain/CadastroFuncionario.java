package com.antonia.loja.domain;

import com.antonia.loja.enums.Atividade;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CadastroFuncionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Não é permitido cadastrar formulário de funcionário sem o nome")
    @Size(min = 2, message = "O Nome deve conter acima de 2 caracteres")
    private String nome;

    @Email(message = "Por favor inserir um e-mail valido")
    private String email;

    @CPF(message = "Por favor inserir um CPF válido")
    @NotBlank(message = "Não é permitido cadastrar formulário de funcionário sem o CPF")
    private String cpf;

    @NotBlank(message = "Não é permitido cadastrar formulário de funcionário sem o RG")
    private String rg;

    private String telefone;
    private Atividade atividade;

    @NotBlank(message = "Por favor insira a loja que o funcionário trabalha no momento")
    private String Loja;

    @NotBlank(message = "Por favor insira uma senha")
    private String senha;

    @Transient
    @NotBlank(message = "Por favor confirme a senha")
    private String senhaConfirmacao;

}
