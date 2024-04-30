package com.antonia.loja.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Atividade {
    VENDEDOR("Vendedor"),
    GERENTE("Gerente"),
    ADMINISTRADOR("Administrador"),
    RECURSOS_HUMANOS("Recursos Humanos"),
    OPERADOR_DE_CAIXA("Operador de Caixa"),
    VITRINISTA("Vitrinista"),
    ESTOQUISTA("Estoquista"),
    LIMPEZA_MANUTENCAO("Limpeza e manutenção");

    private final String descricao;

    public static String getDescricao(Atividade atividade) {
        for (Atividade atividadeFor : Atividade.values()) {
            if (atividadeFor.equals(atividade)) {
                return atividadeFor.descricao;
            }
        }
        return null;
    }

}
