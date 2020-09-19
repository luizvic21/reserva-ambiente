package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Bloco;
import br.edu.ifsc.aluno.victor.model.dao.BlocoDAO;
import br.edu.ifsc.aluno.victor.service.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocoServiceImpl implements BlocoService {

    @Autowired
    BlocoDAO blocoDAO;

    @Override
    public void cadastrar(Bloco bloco) {
        blocoDAO.create(bloco);
    }

    @Override
    public Bloco consultar(Integer id) {
        return blocoDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Bloco %d não encontrada", id)));
    }

    @Override
    public List<Bloco> consultar() {
        return blocoDAO.findAll();
    }

    @Override
    public void alterar(Integer id, Bloco bloco) {
        Bloco blocoAtual = consultar(id);
        blocoDAO.update(blocoAtual.editar(bloco));
    }

    @Override
    public void deletar(Integer id) {
        consultar(id);
        blocoDAO.delete(id);
    }
}
