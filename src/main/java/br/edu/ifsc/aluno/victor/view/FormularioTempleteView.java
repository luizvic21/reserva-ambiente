/*
 * Created by JFormDesigner on Sun Sep 20 21:47:54 BRT 2020
 */

package br.edu.ifsc.aluno.victor.view;

import br.edu.ifsc.aluno.victor.Utils.WindowUtils;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class FormularioTempleteView extends JDialog {
    public FormularioTempleteView(Window owner) {
        super(owner);
        initComponents();
        idLbl.setText("");
    }

    public JPanel getButtonBar() {
        return buttonBar;
    }

    public JButton getNovoBtn() {
        return novoBtn;
    }

    public JButton getCancelarBtn() {
        return cancelarBtn;
    }

    public JButton getGravarBtn() {
        return gravarBtn;
    }

    public JButton getBuscarBtn() {
        return buscarBtn;
    }

    public JButton getSairBtn() {
        return sairBtn;
    }

    public JLabel getIdLbl() {
        return idLbl;
    }

    public void setTituloLbl(String titulo) {
        this.tituloLbl.setText(titulo);
    }

    public Object getDados() {
        Integer id = idLbl.getText().isEmpty() ? null : Integer.parseInt(idLbl.getText());
        return null;
    }

    public void resetar() {
        if (idLbl.getText().isEmpty()) {

        }
    }

    public void setDados(Object object) {
        idLbl.setText(String.valueOf(object));
    }

    public void initButtons(ActionListener actionListener) {
        getNovoBtn().addActionListener(actionListener);
        getGravarBtn().addActionListener(actionListener);
        getCancelarBtn().addActionListener(actionListener);
        getNovoBtn().addActionListener(actionListener);
        getSairBtn().addActionListener(actionListener);
    }

    public void ativarBotoes(boolean estadoBotoes) {
        this.novoBtn.setEnabled(estadoBotoes);
        this.gravarBtn.setEnabled(!estadoBotoes);
        this.cancelarBtn.setEnabled(!estadoBotoes);
        this.buscarBtn.setEnabled(estadoBotoes);
        this.sairBtn.setEnabled(estadoBotoes);
    }

    public void ativaInputs(boolean estadoInputs) {
        WindowUtils.AtivaInputs(estadoInputs, this.dadosPanel);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        centerPanel = new JPanel();
        panel1 = new JPanel();
        tituloLbl = new JLabel();
        dadosPanel = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label3 = new JLabel();
        buttonBar = new JPanel();
        novoBtn = new JButton();
        cancelarBtn = new JButton();
        gravarBtn = new JButton();
        buscarBtn = new JButton();
        sairBtn = new JButton();
        idLbl = new JLabel();

        //======== this ========
        setTitle("IFSC - ");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.
            EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing
            .border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),
            java.awt.Color.red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener()
            {@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))
            throw new RuntimeException();}});
            dialogPane.setLayout(new BorderLayout());

            //======== centerPanel ========
            {
                centerPanel.setLayout(new BorderLayout());

                //======== panel1 ========
                {
                    panel1.setBorder(new BevelBorder(BevelBorder.RAISED));
                    panel1.setLayout(new FlowLayout());

                    //---- tituloLbl ----
                    tituloLbl.setText("Titulo");
                    panel1.add(tituloLbl);
                }
                centerPanel.add(panel1, BorderLayout.NORTH);

                //======== dadosPanel ========
                {
                    dadosPanel.setBorder(new BevelBorder(BevelBorder.RAISED));

                    //---- label2 ----
                    label2.setText("Nome");

                    //---- label3 ----
                    label3.setText("Descricao");

                    GroupLayout dadosPanelLayout = new GroupLayout(dadosPanel);
                    dadosPanel.setLayout(dadosPanelLayout);
                    dadosPanelLayout.setHorizontalGroup(
                        dadosPanelLayout.createParallelGroup()
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dadosPanelLayout.createParallelGroup()
                                    .addComponent(textField1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                                    .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                                    .addGroup(dadosPanelLayout.createSequentialGroup()
                                        .addGroup(dadosPanelLayout.createParallelGroup()
                                            .addComponent(label2)
                                            .addComponent(label3))
                                        .addGap(0, 416, Short.MAX_VALUE)))
                                .addContainerGap())
                    );
                    dadosPanelLayout.setVerticalGroup(
                        dadosPanelLayout.createParallelGroup()
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label2)
                                .addGap(14, 14, 14)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label3)
                                .addGap(12, 12, 12)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
                    );
                }
                centerPanel.add(dadosPanel, BorderLayout.CENTER);
            }
            dialogPane.add(centerPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new BevelBorder(BevelBorder.RAISED));
                buttonBar.setLayout(new FlowLayout());

                //---- novoBtn ----
                novoBtn.setText("Novo");
                buttonBar.add(novoBtn);

                //---- cancelarBtn ----
                cancelarBtn.setText("Cancelar");
                cancelarBtn.setEnabled(false);
                buttonBar.add(cancelarBtn);

                //---- gravarBtn ----
                gravarBtn.setText("Gravar");
                gravarBtn.setEnabled(false);
                buttonBar.add(gravarBtn);

                //---- buscarBtn ----
                buscarBtn.setText("Buscar");
                buttonBar.add(buscarBtn);

                //---- sairBtn ----
                sairBtn.setText("Sair");
                buttonBar.add(sairBtn);
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel centerPanel;
    private JPanel panel1;
    private JLabel tituloLbl;
    private JPanel dadosPanel;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label3;
    private JPanel buttonBar;
    private JButton novoBtn;
    private JButton cancelarBtn;
    private JButton gravarBtn;
    private JButton buscarBtn;
    private JButton sairBtn;
    private JLabel idLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
