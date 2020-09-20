package br.edu.ifsc.aluno.victor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Pessoa  {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String fone;
    private String fone2;
    private String email;
    private String cpf;
    private String rg;
    private Endereco endereco;

    protected void preencher(Endereco endereco, Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.fone = pessoa.getFone();
        this.fone2 = pessoa.getFone2();
        this.email = pessoa.getEmail();
        this.cpf = pessoa.getCpf();
        this.rg = pessoa.getRg();
        this.endereco = endereco;
    }
}
