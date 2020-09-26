package br.edu.ifsc.aluno.victor.Utils;

import javax.swing.*;

public class MensagensUtils {

    public static void CadastroSucesso(String titulo) {
        JOptionPane.showMessageDialog(null, String.format("%s cadastrado com sucesso", titulo));
    }

    public static void EditarSucesso(String titulo) {
        JOptionPane.showMessageDialog(null, String.format("%s editado com sucesso", titulo));
    }

    public static void ErroRemover() {
        JOptionPane.showMessageDialog(null, "Você deve selecionar um registro para remover!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void ErroEditar() {
        JOptionPane.showMessageDialog(null, "Você deve selecionar um registro para editar!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static int RemoverMensagem(String objeto, String descricao) {
        return JOptionPane.showConfirmDialog(null, String.format("Deseja remover o %s: %s", objeto, descricao), "Remover", JOptionPane.OK_CANCEL_OPTION);
    }
}
