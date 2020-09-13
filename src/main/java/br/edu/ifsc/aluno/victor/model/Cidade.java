package br.edu.ifsc.aluno.victor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cidade {

    private Integer id;
    private String descricao;

    public Cidade alterar(Cidade cidade) {
        this.descricao = cidade.getDescricao();
        return this;
    }
}
