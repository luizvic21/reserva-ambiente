package br.edu.ifsc.aluno.victor.model;

import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Servidor extends Pessoa {

    private String siape;
    private EnumTipoServidor tipoServidor;
    private String foto;

    public Servidor(Integer id, String nome, LocalDate dataNascimento, String fone, String fone2, String email, String cpf, String rg, Endereco endereco, String siape, EnumTipoServidor tipoServidor, String foto) {
        super(id, nome, dataNascimento, fone, fone2, email, cpf, rg, endereco);
        this.siape = siape;
        this.tipoServidor = tipoServidor;
        this.foto = foto;
    }

    public Servidor(Endereco endereco, Servidor servidor) {
        preencher(endereco, servidor);
    }

    private void preencher(Endereco endereco, Servidor servidor) {
        super.preencher(endereco, servidor);
        this.siape = servidor.getSiape();
        this.tipoServidor = servidor.getTipoServidor();
        this.foto = servidor.getFoto();
    }

    public Servidor editar(Endereco endereco, Servidor servidor) {
        preencher(endereco, servidor);
        return this;
    }

}
