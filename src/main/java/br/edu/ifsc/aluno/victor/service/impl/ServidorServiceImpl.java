package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.model.dao.ServidorDAO;
import br.edu.ifsc.aluno.victor.service.EnderecoService;
import br.edu.ifsc.aluno.victor.service.ServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServidorServiceImpl implements ServidorService {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ServidorDAO servidorDAO;

    @Override
    public void cadastrar(Servidor servidor) {
        Integer idEndereco = enderecoService.cadastrarRetornandoId(servidor.getEndereco());
        Endereco endereco = enderecoService.consultar(idEndereco);
        servidorDAO.create(new Servidor(endereco, servidor));
    }

    @Override
    public Servidor consultar(Integer id) {
        return servidorDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Servidor %d não encontrada", id)));
    }

    @Override
    public List<Servidor> consultar() {
        return servidorDAO.findAll();
    }

    @Override
    public void alterar(Integer id, Servidor servidor) {
        Servidor servidorAtual = consultar(id);
        Endereco endereco = enderecoService.consultar(servidorAtual.getEndereco().getId());
        enderecoService.alterar(servidorAtual.getEndereco().getId(), servidor.getEndereco());
        servidorDAO.update(servidorAtual.editar(endereco, servidor));
    }

    @Override
    public void deletar(Integer id) {
        Servidor servidor = consultar(id);
        servidorDAO.delete(id);
        enderecoService.deletar(servidor.getEndereco().getId());
    }

    @Override
    public Servidor consultar(String nome) {
        return servidorDAO.findByDescricao(nome);
    }

    @Override
    public List<Servidor> consultar(EnumTipoServidor tipoServidor) {
        return servidorDAO.findByTipo(tipoServidor);
    }
}
