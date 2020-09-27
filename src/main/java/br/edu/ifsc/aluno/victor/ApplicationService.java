package br.edu.ifsc.aluno.victor;

import br.edu.ifsc.aluno.victor.controller.AmbienteController;
import br.edu.ifsc.aluno.victor.controller.system.LoginController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.view.system.MenuView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private LoginController loginController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private AmbienteController ambienteController;

    public void execute() {
//        TelaLoginView telaLoginView = new TelaLoginView(null);
//        loginController.init(telaLoginView);
//        loginController.abrirTelaLogin();
        MenuView menuView = new MenuView();
        menuController.init(menuView);
        menuController.abrirMenu();
//        ListaTempleteView listaTempleteView = new ListaTempleteView();
//        listaTempleteView.setVisible(true);
//        FormularioServidorView formularioServidorView = new FormularioServidorView(null);
//        formularioServidorView.setVisible(true);
//        System.out.println(ambienteController.consultarPorId(1));
    }
}
