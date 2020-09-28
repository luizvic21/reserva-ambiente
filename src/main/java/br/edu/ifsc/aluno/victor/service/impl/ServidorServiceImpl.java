package br.edu.ifsc.aluno.victor.service.impl;

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
        Endereco endereco = enderecoService.consultar(servidor.getEndereco().getId());
        enderecoService.alterar(servidor.getEndereco().getId(), servidor.getEndereco());
        Servidor servidorAtual = consultar(id);
        servidorDAO.update(servidorAtual.editar(endereco, servidor));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        servidorDAO.delete(id);
    }

    @Override
    public Servidor consultar(String nome) {
        return servidorDAO.findByDescricao(nome);
    }
}
