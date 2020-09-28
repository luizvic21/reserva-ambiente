/*
 * Created by JFormDesigner on Sun Sep 20 21:47:54 BRT 2020
 */

package br.edu.ifsc.aluno.victor.view.curso;

import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.enuns.EnumModalidade;
import br.edu.ifsc.aluno.victor.enuns.EnumPeriodo;
import br.edu.ifsc.aluno.victor.model.Curso;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author unknown
 */
public class FormularioCursoView extends JDialog {
    public FormularioCursoView(Window owner) {
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

    public Curso getDados() {
        Integer id = idLbl.getText().isEmpty() ? null : Integer.parseInt(idLbl.getText());
        String descricao = descricaoTxt.getText();
        String email = descricaoTxt.getText();
        EnumModalidade modalidade = EnumModalidade.valueOf((String) modalidadeCbx.getSelectedItem());
        EnumPeriodo periodo = EnumPeriodo.valueOf((String) periodoCbx.getSelectedItem());
        return new Curso(id, descricao, email, modalidade, periodo);
    }

    public void resetar() {
        if (idLbl.getText().isEmpty()) {
            descricaoTxt.setText("");
            emailTxt.setText("");
            modalidadeCbx.removeAllItems();
            periodoCbx.removeAllItems();
        }
    }

    public void setDados(Curso curso) {
        descricaoTxt.setText(curso.getDescricao());
        emailTxt.setText(curso.getEmail());
        modalidadeCbx.addItem(curso.getModalidade().toString());
        periodoCbx.addItem(curso.getPeriodo().toString());
    }

    public void setTituloLbl(String titulo) {
        this.tituloLbl.setText(titulo);
    }

    public void ativaInputs(boolean estadoInputs) {
        WindowUtils.AtivaInputs(estadoInputs, this.dadosPanel);
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

    public void setModalidadeCbx() {
        for (EnumModalidade modalidade : EnumModalidade.values()) {
            modalidadeCbx.addItem(modalidade.toString());
        }
    }

    public void setPeriodoCbx() {
        for (EnumPeriodo periodo : EnumPeriodo.values()) {
            periodoCbx.addItem(periodo.toString());
        }
        return;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        tituloLbl = new JLabel();
        dadosPanel = new JPanel();
        descricaoTxt = new JTextField();
        label3 = new JLabel();
        emailTxt = new JTextField();
        label4 = new JLabel();
        label1 = new JLabel();
        modalidadeCbx = new JComboBox();
        label2 = new JLabel();
        periodoCbx = new JComboBox();
        buttonBar = new JPanel();
        novoBtn = new JButton();
        cancelarBtn = new JButton();
        gravarBtn = new JButton();
        buscarBtn = new JButton();
        sairBtn = new JButton();
        idLbl = new JLabel();

        //======== this ========
        setTitle("IFSC - Cursos");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,dialogPane. getBorder () ) )
            ; dialogPane. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());

                //======== panel1 ========
                {
                    panel1.setBorder(new BevelBorder(BevelBorder.RAISED));
                    panel1.setLayout(new FlowLayout());

                    //---- tituloLbl ----
                    tituloLbl.setText("Titulo");
                    panel1.add(tituloLbl);
                }
                contentPanel.add(panel1, BorderLayout.NORTH);

                //======== dadosPanel ========
                {
                    dadosPanel.setBorder(new BevelBorder(BevelBorder.RAISED));

                    //---- label3 ----
                    label3.setText("Descricao");

                    //---- label4 ----
                    label4.setText("E-mail");

                    //---- label1 ----
                    label1.setText("Modalidade");

                    //---- label2 ----
                    label2.setText("Periodo");

                    GroupLayout dadosPanelLayout = new GroupLayout(dadosPanel);
                    dadosPanel.setLayout(dadosPanelLayout);
                    dadosPanelLayout.setHorizontalGroup(
                        dadosPanelLayout.createParallelGroup()
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dadosPanelLayout.createParallelGroup()
                                    .addComponent(descricaoTxt)
                                    .addGroup(GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(dadosPanelLayout.createParallelGroup()
                                            .addComponent(label4)
                                            .addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(dadosPanelLayout.createSequentialGroup()
                                        .addGroup(dadosPanelLayout.createParallelGroup()
                                            .addComponent(label3)
                                            .addComponent(label1)
                                            .addComponent(modalidadeCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2)
                                            .addComponent(periodoCbx, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                    );
                    dadosPanelLayout.setVerticalGroup(
                        dadosPanelLayout.createParallelGroup()
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label3)
                                .addGap(12, 12, 12)
                                .addComponent(descricaoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label4)
                                .addGap(12, 12, 12)
                                .addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(label1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modalidadeCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label2)
                                .addGap(18, 18, 18)
                                .addComponent(periodoCbx, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }
                contentPanel.add(dadosPanel, BorderLayout.CENTER);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

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
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel tituloLbl;
    private JPanel dadosPanel;
    private JTextField descricaoTxt;
    private JLabel label3;
    private JTextField emailTxt;
    private JLabel label4;
    private JLabel label1;
    private JComboBox modalidadeCbx;
    private JLabel label2;
    private JComboBox periodoCbx;
    private JPanel buttonBar;
    private JButton novoBtn;
    private JButton cancelarBtn;
    private JButton gravarBtn;
    private JButton buscarBtn;
    private JButton sairBtn;
    private JLabel idLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
