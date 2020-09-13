package br.edu.ifsc.aluno.victor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Bloco {

    private Integer id;
    private String descricao;
    private String foto;

    public Bloco editar(Bloco bloco) {
        this.preencher(bloco);
        return this;
    }

    private void preencher(Bloco bloco) {
        this.descricao = bloco.getDescricao();
        this.foto = bloco.getFoto();
    }
}
