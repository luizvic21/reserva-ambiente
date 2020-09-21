package br.edu.ifsc.aluno.victor.controller.servidor;

import br.edu.ifsc.aluno.victor.Utils.BotaoUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.ServidorController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.view.servidor.FormularioServidorView;
import br.edu.ifsc.aluno.victor.view.servidor.ListaServidorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Service
public class ListaServidorController implements ActionListener {

    @Autowired
    private ServidorController servidorController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private FormularioServidorController formularioServidorController;

    private ListaServidorView listaServidorView;

    public void init(ListaServidorView listaServidorView) {
        this.listaServidorView = listaServidorView;
        this.listaServidorView.initButtons(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(listaServidorView.getCadastrarBtn())) {
            this.abrirFormularioCadastro();
        } else  if (e.getSource().equals(listaServidorView.getEditarBtn())) {

        } else  if (e.getSource().equals(listaServidorView.getDeletarBtn())) {

        } else  if (e.getSource().equals(listaServidorView.getFecharBtn())) {
            WindowUtils.Exit(listaServidorView);
        } else  if (e.getSource().equals(listaServidorView.getMenuBtn())) {
            BotaoUtils.VoltarMenu(listaServidorView, menuController);
        }
    }

    public void abrir() {
        this.listaServidorView.setVisible(true);
    }

    private void abrirFormularioCadastro() {
        FormularioServidorView formularioServidorView = new FormularioServidorView(listaServidorView);
        this.formularioServidorController.init(formularioServidorView);
        this.formularioServidorController.abrir();
    }
}
