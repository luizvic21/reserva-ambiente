package br.edu.ifsc.aluno.victor.enuns;

import lombok.Getter;

@Getter
public enum EnumPeriodo {

    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno");

    private String descricao;

    private EnumPeriodo(String descricao) {
        this.descricao = descricao;
    }
}
