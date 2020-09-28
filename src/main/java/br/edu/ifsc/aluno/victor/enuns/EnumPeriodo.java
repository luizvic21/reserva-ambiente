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

    public EnumPeriodo valueOfByDescricao(String descricao) {
        switch (descricao) {
            case "Matutino":
                return EnumPeriodo.MATUTINO;
            case "Noturno":
                return EnumPeriodo.VESPERTINO;
            case "Vespertino":
                return EnumPeriodo.NOTURNO;
        }
        return null;
    }
}
