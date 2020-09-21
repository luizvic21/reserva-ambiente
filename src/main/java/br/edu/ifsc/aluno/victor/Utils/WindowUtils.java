package br.edu.ifsc.aluno.victor.Utils;

import javax.swing.*;
import java.awt.*;

public class WindowUtils {

    public static void Exit(Window window) {
        window.dispose();
        System.exit(0);
    }

    public static void AtivaInputs(boolean estadoInputs, JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                component.setEnabled(!estadoInputs);
            }

            if (component instanceof JFormattedTextField) {
                component.setEnabled(!estadoInputs);
            }

            if (component instanceof JComboBox) {
                component.setEnabled(!estadoInputs);
            }

            if (component instanceof JPasswordField) {
                component.setEnabled(!estadoInputs);
            }
        }
    }

}
