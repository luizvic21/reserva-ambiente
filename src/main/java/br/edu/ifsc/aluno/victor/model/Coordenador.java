package br.edu.ifsc.aluno.victor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Coordenador {

    private Integer id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Boolean ativo;
    private Servidor servidor;
    private Curso curso;

    public Coordenador (Servidor servidor, Curso curso, Coordenador coordenador) {
        this.preencher(servidor, curso, coordenador);
    }

    private void preencher(Servidor servidor, Curso curso, Coordenador coordenador) {
        this.dataInicio = coordenador.getDataInicio();
        this.dataFim = coordenador.getDataFim();
        this.ativo = coordenador.getAtivo();
        this.servidor = servidor;
        this.curso = curso;
    }

    public Coordenador editar(Servidor servidor, Curso curso, Coordenador coordenador) {
        this.preencher(servidor, curso, coordenador);
        return this;
    }

    public Coordenador desativar(){
        this.dataFim = LocalDate.now();
        this.ativo = false;
        return this;
    }
}
