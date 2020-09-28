package br.edu.ifsc.aluno.victor;

import br.edu.ifsc.aluno.victor.controller.system.LoginController;
import br.edu.ifsc.aluno.victor.view.system.TelaLoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private LoginController loginController;;

    public void execute() {
        TelaLoginView telaLoginView = new TelaLoginView(null);
        loginController.init(telaLoginView);
        loginController.abrirTelaLogin();
    }
}
