package br.edu.ifsc.aluno.victor.controller;

import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.service.ServidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    public void cadastrar(Servidor servidor) {
        servidorService.cadastrar(servidor);
    }

    public void alterar(Integer id, Servidor servidor){
        servidorService.alterar(id, servidor);
    }

    public Servidor consultarPorId(Integer id) {
        return servidorService.consultar(id);
    }

    public List<Servidor> consultar() {
        return servidorService.consultar();
    }

    public void deletar(Integer id) {
        servidorService.deletar(id);
    }
}
