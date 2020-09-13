package br.edu.ifsc.aluno.victor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Ambiente {

    private Integer id;
    private String descricao;
    private String sigla;
    private String foto;
    private String chaveAcesso;
    private Bloco bloco;

    public Ambiente (Bloco bloco, Ambiente ambiente) {
        this.preencher(bloco, ambiente);
    }

    private void preencher(Bloco bloco, Ambiente ambiente) {
        this.descricao = ambiente.getDescricao();
        this.sigla = ambiente.getSigla();
        this.foto = ambiente.getFoto();
        this.chaveAcesso = ambiente.getChaveAcesso();
        this.bloco = bloco;
    }

    public Ambiente editar(Bloco bloco, Ambiente ambiente) {
        this.preencher(bloco, ambiente);
        return this;
    }
}
