package br.edu.ifsc.aluno.victor.controller.servidor;

import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.CidadeController;
import br.edu.ifsc.aluno.victor.controller.ServidorController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.view.servidor.FormularioServidorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Service
public class FormularioServidorController implements ActionListener {

    @Autowired
    private ServidorController servidorController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private ListaServidorController listaServidorController;

    @Autowired
    private CidadeController cidadeController;

    private FormularioServidorView formularioServidorView;

    private Integer id;

    public void init(FormularioServidorView formularioServidorView) {
        this.formularioServidorView = formularioServidorView;
        this.formularioServidorView.initButtons(this);
        this.formularioServidorView.ativarBotoes(true);
        this.formularioServidorView.ativaInputs(true);
        this.formularioServidorView.setTituloLbl("Cadastrar bloco");
    }

    public void init(FormularioServidorView formularioServidorView, Servidor servidor) {
        this.formularioServidorView = formularioServidorView;
        this.formularioServidorView.initButtons(this);
        this.formularioServidorView.ativaInputs(false);
        this.formularioServidorView.ativarBotoes(false);
        this.formularioServidorView.setDados(servidor);
        this.id = servidor.getId();
        this.formularioServidorView.setTituloLbl("Editar bloco");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioServidorView.getNovoBtn())) {
            this.clickNovo();
        } else if (e.getSource().equals(formularioServidorView.getGravarBtn())) {
            this.clickGravar();
        } else if (e.getSource().equals(formularioServidorView.getCancelarBtn())) {
            this.clickCancelar();
        } else if (e.getSource().equals(formularioServidorView.getBuscarBtn())) {
            WindowUtils.Exit(formularioServidorView);
        } else if (e.getSource().equals(formularioServidorView.getSairBtn())) {
            this.clickSair();
        }
    }

    private void clickGravar() {
        if (Objects.isNull(id)) {
            servidorController.cadastrar(formularioServidorView.getDados());
            MensagensUtils.CadastroSucesso("Servidor");
        } else {
            servidorController.alterar(id, formularioServidorView.getDados());
            MensagensUtils.EditarSucesso("Servidor");
        }
        this.formularioServidorView.ativarBotoes(true);
        this.formularioServidorView.ativaInputs(true);
        this.formularioServidorView.resetar();
    }

    public void abrir() {
        this.formularioServidorView.setVisible(true);
    }

    private void clickNovo() {
        this.formularioServidorView.ativarBotoes(false);
        this.formularioServidorView.ativaInputs(false);
        this.formularioServidorView.setCidades(cidadeController.consultar());
        this.formularioServidorView.setTipoServidorCbx();
    }

    private void clickCancelar() {
        this.formularioServidorView.ativarBotoes(true);
        this.formularioServidorView.ativaInputs(true);
        formularioServidorView.resetar();
    }

    private void clickSair() {
        this.listaServidorController.carregaLista();
        this.formularioServidorView.dispose();
    }
}
