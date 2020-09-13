package br.edu.ifsc.aluno.victor;

import br.edu.ifsc.aluno.victor.controller.CidadeController;
import br.edu.ifsc.aluno.victor.controller.EnderecoController;
import br.edu.ifsc.aluno.victor.enuns.EnumModalidade;
import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.dao.CidadeDAO;
import br.edu.ifsc.aluno.victor.model.dao.EnderecoDAO;
import br.edu.ifsc.aluno.victor.model.dao.jdbc.CidadeDAOJdbc;
import br.edu.ifsc.aluno.victor.model.dao.jdbc.EnderecoDAOJdbc;
import br.edu.ifsc.aluno.victor.service.CidadeService;
import br.edu.ifsc.aluno.victor.service.EnderecoService;
import br.edu.ifsc.aluno.victor.service.impl.CidadeServiceImpl;
import br.edu.ifsc.aluno.victor.service.impl.EnderecoServiceImpl;

public class App {

    public static void main(String[] args) {
        CidadeDAO cidadeDAO = new CidadeDAOJdbc();
        CidadeService cidadeService = new CidadeServiceImpl(cidadeDAO);
        EnderecoDAO enderecoDAO = new EnderecoDAOJdbc();
        EnderecoService enderecoService = new EnderecoServiceImpl(enderecoDAO, cidadeService);
        EnderecoController enderecoController = new EnderecoController(enderecoService);
//        consultarEnderecoPorId(enderecoController);
        System.out.println(EnumModalidade.EAD.toString());
    }

    private static void cadastrarEndereco(EnderecoController enderecoController) {
        Cidade cidade = new Cidade(276, null);
        Endereco endereco = new Endereco(null, "88702801", "Rua Silvio Burigo", 1299, "Monte Castelo", cidade);
        enderecoController.cadastrar(endereco);
    }

    private static void consultarEnderecoPorId(EnderecoController enderecoController) {
        System.out.println(enderecoController.consultarPorId(1));
    }

    private static void alterarEndereco(EnderecoController enderecoController) {
        Cidade cidade = new Cidade(248, null);
        Endereco endereco = new Endereco(null, "88519801", "Rua da ovelhinha", 1299, "H", cidade);
        enderecoController.alterar(1, endereco);
    }

    private static void deletarEndereco(EnderecoController enderecoController) {
        enderecoController.deletar(1);
    }
}
