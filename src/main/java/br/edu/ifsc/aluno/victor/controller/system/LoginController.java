package br.edu.ifsc.aluno.victor.controller.system;

import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.UsuarioController;
import br.edu.ifsc.aluno.victor.view.system.MenuView;
import br.edu.ifsc.aluno.victor.view.system.TelaLoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Service
public class LoginController implements ActionListener {

    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    private MenuController menuController;

    private TelaLoginView telaLoginView;

    public void init(TelaLoginView telaLoginView) {
        this.telaLoginView = telaLoginView;
        this.telaLoginView.getEntrarBtn().addActionListener(this);
        this.telaLoginView.getCancelarBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.telaLoginView.getEntrarBtn())) {
            this.logar();
        } else if (e.getSource().equals(this.telaLoginView.getCancelarBtn())) {
            this.fechar();
        }
    }

    public void abrirTelaLogin() {
        telaLoginView.setVisible(true);
    }

    private void logar() {
        String username = this.telaLoginView.getUsernameTxt().getText();
        String senha = this.telaLoginView.getSenhaTxt().getText();
        boolean isLogado = usuarioController.logar(username, senha);
        telaLoginView.dispose();
        if (isLogado) {
            JOptionPane.showMessageDialog(null, String.format("Usuário %s logado com sucesso!", username));
            MenuView menuView = new MenuView();
            menuController.init(menuView);
            menuController.abrirMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao logar!", "Erro", JOptionPane.ERROR_MESSAGE);
            abrirTelaLogin();
        }
    }

    private void fechar() {
        WindowUtils.Exit(telaLoginView);
    }
}
