package br.edu.ifsc.aluno.victor.Utils;

import javax.swing.*;

public class MensagensUtils {

    public static void CadastroSucesso(String titulo) {
        JOptionPane.showMessageDialog(null, String.format("%s cadastrado com sucesso", titulo));
    }

    public static void ErroRemover() {
        JOptionPane.showMessageDialog(null, "Você deve selecionar um registro para remover!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
