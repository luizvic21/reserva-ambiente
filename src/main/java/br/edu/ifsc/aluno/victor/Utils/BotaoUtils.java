package br.edu.ifsc.aluno.victor.Utils;

import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.view.system.MenuView;

import java.awt.*;

public class BotaoUtils {

    public static void VoltarMenu(Window window, MenuController menuController) {
        window.dispose();
        MenuView menuView = new MenuView();
        menuController.init(menuView);
        menuController.abrirMenu();
    }
}
