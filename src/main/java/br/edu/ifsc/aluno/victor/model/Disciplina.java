package br.edu.ifsc.aluno.victor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Disciplina {

    private Integer id;
    private String descricao;

    public Disciplina editar(Disciplina disciplina) {
        this.preencher(disciplina);
        return this;
    }

    private void preencher(Disciplina disciplina) {
        this.descricao = disciplina.getDescricao();
    }
}
