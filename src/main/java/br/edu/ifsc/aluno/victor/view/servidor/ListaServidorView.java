/*
 * Created by JFormDesigner on Sun Sep 20 21:09:30 BRT 2020
 */

package br.edu.ifsc.aluno.victor.view.servidor;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class ListaServidorView extends JFrame {
    public ListaServidorView() {
        initComponents();
    }

    public JTable getListagemTbt() {
        return listagemTbt;
    }

    public JButton getCadastrarBtn() {
        return cadastrarBtn;
    }

    public JButton getEditarBtn() {
        return editarBtn;
    }

    public JButton getDeletarBtn() {
        return deletarBtn;
    }

    public JButton getFecharBtn() {
        return fecharBtn;
    }

    public JButton getMenuBtn() {
        return menuBtn;
    }

    public void initButtons(ActionListener actionListener) {
        cadastrarBtn.addActionListener(actionListener);
        editarBtn.addActionListener(actionListener);
        deletarBtn.addActionListener(actionListener);
        fecharBtn.addActionListener(actionListener);
        menuBtn.addActionListener(actionListener);
    }

    public void setColumnsNameListagem(String[] colunas) {
        TableModel tableModel = new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                colunas
        );
        this.listagemTbt.setModel(tableModel);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        listagemTbt = new JTable();
        buttonBar = new JPanel();
        cadastrarBtn = new JButton();
        editarBtn = new JButton();
        deletarBtn = new JButton();
        fecharBtn = new JButton();
        panel1 = new JPanel();
        menuBtn = new JButton();
        tituloLbl = new JLabel();

        //======== this ========
        setTitle("IFSC - Servidores");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setForeground(Color.white);
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
            , 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
            dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new FlowLayout());

                //======== panel2 ========
                {
                    panel2.setBorder(new BevelBorder(BevelBorder.RAISED));
                    panel2.setLayout(new FlowLayout());

                    //======== scrollPane1 ========
                    {

                        //---- listagemTbt ----
                        listagemTbt.setModel(new DefaultTableModel(2, 0));
                        scrollPane1.setViewportView(listagemTbt);
                    }
                    panel2.add(scrollPane1);
                }
                contentPanel.add(panel2);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new BevelBorder(BevelBorder.RAISED));
                buttonBar.setLayout(new FlowLayout());

                //---- cadastrarbtn ----
                cadastrarBtn.setText("Cadastrar");
                buttonBar.add(cadastrarBtn);

                //---- editarBtn ----
                editarBtn.setText("Editar");
                buttonBar.add(editarBtn);

                //---- deletarBtn ----
                deletarBtn.setText("Deletar");
                buttonBar.add(deletarBtn);

                //---- fecharBtn ----
                fecharBtn.setText("Fechar");
                buttonBar.add(fecharBtn);
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== panel1 ========
            {
                panel1.setBorder(new BevelBorder(BevelBorder.RAISED));
                panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

                //---- menuBtn ----
                menuBtn.setText("<- Menu");
                panel1.add(menuBtn);

                //---- tituloLbl ----
                tituloLbl.setText("Listagem de Servidores");
                panel1.add(tituloLbl);
            }
            dialogPane.add(panel1, BorderLayout.NORTH);
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
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable listagemTbt;
    private JPanel buttonBar;
    private JButton cadastrarBtn;
    private JButton editarBtn;
    private JButton deletarBtn;
    private JButton fecharBtn;
    private JPanel panel1;
    private JButton menuBtn;
    private JLabel tituloLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
