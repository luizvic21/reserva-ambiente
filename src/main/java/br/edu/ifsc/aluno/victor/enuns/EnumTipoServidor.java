package br.edu.ifsc.aluno.victor.enuns;

import lombok.Getter;

@Getter
public enum EnumTipoServidor {

    DOCENTE("Docente"),
    TAE("TAE");

    private String descricao;

    private EnumTipoServidor(String descricao) {
        this.descricao = descricao;
    }
}
