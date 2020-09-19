package br.edu.ifsc.aluno.victor.service.impl;

import br.edu.ifsc.aluno.victor.model.Ambiente;
import br.edu.ifsc.aluno.victor.model.Bloco;
import br.edu.ifsc.aluno.victor.model.dao.AmbienteDAO;
import br.edu.ifsc.aluno.victor.service.AmbienteService;
import br.edu.ifsc.aluno.victor.service.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbienteServiceImpl implements AmbienteService {

    @Autowired
    private BlocoService blocoService;

    @Autowired
    private AmbienteDAO ambienteDAO;

    @Override
    public void cadastrar(Ambiente ambiente) {
        Bloco bloco = blocoService.consultar(ambiente.getBloco().getId());
        ambienteDAO.create(new Ambiente(bloco, ambiente));
    }

    @Override
    public Ambiente consultar(Integer id) {
        return ambienteDAO.findById(id).orElseThrow(() -> new RuntimeException(String.format("Ambiente %d não encontrada", id)));
    }

    @Override
    public List<Ambiente> consultar() {
        return ambienteDAO.findAll();
    }

    @Override
    public void alterar(Integer id, Ambiente ambiente) {
        Bloco bloco = blocoService.consultar(ambiente.getBloco().getId());
        Ambiente ambienteAtual = consultar(id);
        ambienteDAO.create(ambienteAtual.editar(bloco, ambiente));
    }

    @Override
    public void deletar(Integer id) {
        ambienteDAO.delete(id);
    }
}
