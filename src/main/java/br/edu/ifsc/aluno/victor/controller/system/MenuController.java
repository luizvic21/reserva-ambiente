package br.edu.ifsc.aluno.victor.controller.system;

import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.bloco.ListaBlocoController;
import br.edu.ifsc.aluno.victor.controller.servidor.ListaServidorController;
import br.edu.ifsc.aluno.victor.view.bloco.ListaBlocoView;
import br.edu.ifsc.aluno.victor.view.servidor.ListaServidorView;
import br.edu.ifsc.aluno.victor.view.system.MenuView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Service
public class MenuController implements ActionListener {

    private MenuView menuView;

    @Autowired
    private ListaBlocoController listaBlocoController;

    @Autowired
    private ListaServidorController listaServidorController;

    public void init(MenuView menuView) {
        this.menuView = menuView;
        this.menuView.getBlocosBtn().addActionListener(this);
        this.menuView.getAmbientesBtn().addActionListener(this);
        this.menuView.getServidoresBtn().addActionListener(this);
        this.menuView.getCursosBtn().addActionListener(this);
        this.menuView.getDisciplinasBtn().addActionListener(this);
        this.menuView.getUsuariosBtn().addActionListener(this);
        this.menuView.getSairBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.menuView.dispose();
        if (e.getSource().equals(menuView.getBlocosBtn())) {
            this.abrirListagemBloco();
        } else if (e.getSource().equals(menuView.getAmbientesBtn())) {

        } else if (e.getSource().equals(menuView.getServidoresBtn())) {
            this.abrirListagemServidor();
        } else if (e.getSource().equals(menuView.getCursosBtn())) {

        } else if (e.getSource().equals(menuView.getDisciplinasBtn())) {

        } else if (e.getSource().equals(menuView.getUsuariosBtn())) {

        } else if (e.getSource().equals(menuView.getSairBtn())) {
            WindowUtils.Exit(menuView);
        }
    }

    public void abrirMenu() {
        menuView.setVisible(true);
    }

    private void abrirListagemBloco() {
        ListaBlocoView listaBlocoView = new ListaBlocoView();
        listaBlocoController.init(listaBlocoView);
        listaBlocoController.abrir();
    }

    private void abrirListagemServidor() {
        ListaServidorView listaServidorView = new ListaServidorView();
        listaServidorController.init(listaServidorView);
        listaServidorController.abrir();
    }
}
