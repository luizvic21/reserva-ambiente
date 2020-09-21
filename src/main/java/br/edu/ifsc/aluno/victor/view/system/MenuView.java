/*
 * Created by JFormDesigner on Sun Sep 20 20:37:57 BRT 2020
 */

package br.edu.ifsc.aluno.victor.view.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author unknown
 */
public class MenuView extends JFrame {
    public MenuView() {
        initComponents();
    }

    public JButton getBlocosBtn() {
        return blocosBtn;
    }

    public JButton getAmbientesBtn() {
        return ambientesBtn;
    }

    public JButton getServidoresBtn() {
        return servidoresBtn;
    }

    public JButton getCursosBtn() {
        return cursosBtn;
    }

    public JButton getDisciplinasBtn() {
        return disciplinasBtn;
    }

    public JButton getUsuariosBtn() {
        return usuariosBtn;
    }

    public JButton getSairBtn() {
        return sairBtn;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        blocosBtn = new JButton();
        ambientesBtn = new JButton();
        servidoresBtn = new JButton();
        cursosBtn = new JButton();
        disciplinasBtn = new JButton();
        usuariosBtn = new JButton();
        buttonBar = new JPanel();
        sairBtn = new JButton();

        //======== this ========
        setTitle("Menu");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(500, 0));

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
            dialogPane.setLayout(new BorderLayout(500, 0));

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout(500, 0));

                //======== panel1 ========
                {
                    panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));
                    ((FlowLayout)panel1.getLayout()).setAlignOnBaseline(true);

                    //---- label1 ----
                    label1.setText("Menu Principal");
                    panel1.add(label1);
                }
                contentPanel.add(panel1, BorderLayout.NORTH);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout(6, 1));

                    //---- blocosBtn ----
                    blocosBtn.setText("Blocos");
                    panel2.add(blocosBtn);

                    //---- ambientesBtn ----
                    ambientesBtn.setText("Ambientes");
                    panel2.add(ambientesBtn);

                    //---- servidoresBtn ----
                    servidoresBtn.setText("Servidores");
                    panel2.add(servidoresBtn);

                    //---- cursosBtn ----
                    cursosBtn.setText("Cursos");
                    panel2.add(cursosBtn);

                    //---- disciplinasBtn ----
                    disciplinasBtn.setText("Disciplinas");
                    panel2.add(disciplinasBtn);

                    //---- usuariosBtn ----
                    usuariosBtn.setText("Usuarios");
                    panel2.add(usuariosBtn);
                }
                contentPanel.add(panel2, BorderLayout.CENTER);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- sairBtn ----
                sairBtn.setText("Sair");
                buttonBar.add(sairBtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
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
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JButton blocosBtn;
    private JButton ambientesBtn;
    private JButton servidoresBtn;
    private JButton cursosBtn;
    private JButton disciplinasBtn;
    private JButton usuariosBtn;
    private JPanel buttonBar;
    private JButton sairBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
