package br.edu.ifsc.aluno.victor.controller.servidor;

import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.ServidorController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.view.servidor.FormularioServidorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Service
public class FormularioServidorController implements ActionListener {

    @Autowired
    private ServidorController blocoController;

    @Autowired
    private MenuController menuController;

    private FormularioServidorView formularioServidorView;

    public void init(FormularioServidorView formularioServidorView) {
        this.formularioServidorView = formularioServidorView;
        this.formularioServidorView.initButtons(this);
        this.formularioServidorView.ativarBotoes(true);
        this.formularioServidorView.ativaInputs(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioServidorView.getNovoBtn())) {
            this.clickNovo();
        } else if (e.getSource().equals(formularioServidorView.getGravarBtn())) {
            this.cadastrarServidor();
        } else if (e.getSource().equals(formularioServidorView.getCancelarBtn())) {
            this.clickCancelar();
        } else if (e.getSource().equals(formularioServidorView.getBuscarBtn())) {
            WindowUtils.Exit(formularioServidorView);
        } else if (e.getSource().equals(formularioServidorView.getSairBtn())) {
            this.formularioServidorView.dispose();
        }
    }

    private void cadastrarServidor() {
        blocoController.cadastrar(formularioServidorView.getDados());
    }

    public void abrir() {
        this.formularioServidorView.setVisible(true);
    }

    private void clickNovo() {
        this.formularioServidorView.ativarBotoes(false);
        this.formularioServidorView.ativaInputs(false);
    }

    private void clickCancelar() {
        this.formularioServidorView.ativarBotoes(true);
        this.formularioServidorView.ativaInputs(true);
        this.formularioServidorView.resetar();
    }
}
