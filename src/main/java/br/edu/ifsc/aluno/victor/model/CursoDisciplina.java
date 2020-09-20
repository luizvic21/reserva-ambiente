package br.edu.ifsc.aluno.victor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CursoDisciplina {

    private Integer id;
    private String siglaCurso;
    private Integer faseCurso;
    private Integer cargaHoraria;
    private Servidor docente;
    private Curso curso;
    private Disciplina disciplina;

    public CursoDisciplina(Servidor docente, Curso curso, Disciplina disciplina, CursoDisciplina cursoDisciplina) {
        this.preencher(docente, curso, disciplina, cursoDisciplina);
    }

    private void preencher(Servidor docente, Curso curso, Disciplina disciplina, CursoDisciplina cursoDisciplina) {
        this.siglaCurso = cursoDisciplina.getSiglaCurso();
        this.faseCurso = cursoDisciplina.getFaseCurso();
        this.cargaHoraria = cursoDisciplina.getCargaHoraria();
        this.docente = docente;
        this.curso = curso;
        this.disciplina = disciplina;
    }

    public CursoDisciplina editar(Servidor docente, Curso curso, Disciplina disciplina, CursoDisciplina cursoDisciplina) {
        this.preencher(docente, curso, disciplina, cursoDisciplina);
        return this;
    }
}
