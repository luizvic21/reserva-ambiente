package br.edu.ifsc.aluno.victor.model;

import br.edu.ifsc.aluno.victor.enuns.EnumModalidade;
import br.edu.ifsc.aluno.victor.enuns.EnumPeriodo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Curso {

    private Integer id;
    private String descricao;
    private String email;
    private EnumModalidade modalidade;
    private EnumPeriodo periodo;

    public Curso editar(Curso curso) {
        this.preencher(curso);
        return this;
    }

    private void preencher(Curso curso) {
        this.descricao = curso.getDescricao();
        this.email = curso.getEmail();
        this.modalidade = curso.getModalidade();
        this.periodo = curso.getPeriodo();
    }
}
