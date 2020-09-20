package br.edu.ifsc.aluno.victor.controller.login;

import br.edu.ifsc.aluno.victor.controller.UsuarioController;
import br.edu.ifsc.aluno.victor.view.TelaLoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Service
public class LoginController implements ActionListener {

    @Autowired
    private UsuarioController usuarioController;

    private TelaLoginView telaLoginView;

    public void init(TelaLoginView telaLoginView) {
        this.telaLoginView = telaLoginView;
        this.telaLoginView.getEntrarBtn().addActionListener(this);
        this.telaLoginView.getCancelarBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaLoginView.getEntrarBtn()) {
            usuarioController.logar(this.telaLoginView.getUsernameTxt().getText(), this.telaLoginView.getSenhaTxt().getText());
        }
    }

    public void abrirTelaLogin() {
        telaLoginView.setVisible(true);
    }
}
