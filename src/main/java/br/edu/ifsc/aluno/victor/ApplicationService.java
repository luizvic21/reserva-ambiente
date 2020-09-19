package br.edu.ifsc.aluno.victor;

import br.edu.ifsc.aluno.victor.controller.EnderecoController;
import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private EnderecoController enderecoController;

    public void execute() {
        EnderecoController enderecoController = new EnderecoController();
//        cadastrarEndereco(enderecoController);
        consultarEnderecoPorId();
    }

    private void cadastrarEndereco(EnderecoController enderecoController) {
        Cidade cidade = new Cidade(276, null);
        Endereco endereco = new Endereco(null, "88702801", "Rua Silvio Burigo", 1299, "Monte Castelo", cidade);
        enderecoController.cadastrar(endereco);
    }

    private void consultarEnderecoPorId() {
        System.out.println(enderecoController.consultarPorId(2));
    }

    private void alterarEndereco(EnderecoController enderecoController) {
        Cidade cidade = new Cidade(248, null);
        Endereco endereco = new Endereco(null, "88519801", "Rua da ovelhinha", 1299, "H", cidade);
        enderecoController.alterar(1, endereco);
    }

    private void deletarEndereco(EnderecoController enderecoController) {
        enderecoController.deletar(1);
    }
}
