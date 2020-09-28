package br.edu.ifsc.aluno.victor.enuns;

import lombok.Getter;

@Getter
public enum EnumModalidade {

    PRESENCIAL("Presencial"),
    EAD("EAD");

    private String descricao;

    private EnumModalidade(String descricao) {
        this.descricao = descricao;
    }

    public EnumModalidade valueOfByDescricao(String descricao) {
        switch (descricao) {
            case "Presencial":
                return EnumModalidade.PRESENCIAL;
            case "EAD":
                return EnumModalidade.EAD;
        }
        return null;
    }
}
