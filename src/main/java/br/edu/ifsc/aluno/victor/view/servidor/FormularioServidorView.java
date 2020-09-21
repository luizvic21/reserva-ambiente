/*
 * Created by JFormDesigner on Sun Sep 20 21:47:54 BRT 2020
 */

package br.edu.ifsc.aluno.victor.view.servidor;

import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.Servidor;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * @author unknown
 */
public class FormularioServidorView extends JDialog {
    public FormularioServidorView(Window owner) {
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

    public Servidor getDados() {
        Integer id = idLbl.getText().isEmpty() ? null : Integer.parseInt(idLbl.getText());
        String nome = this.nomeTxt.getText();
        String email = this.emailTxt.getText();
        Integer dia = Integer.parseInt(this.diaTxt.getText());
        Integer mes = Integer.parseInt(this.mesTxt.getText());
        Integer ano = Integer.parseInt(this.anoTxt.getText());
        String fone = this.foneTxt.getText();
        String fone2 = this.fone2Txt.getText();
        String cpf = this.cpfTxt.getText();
        String rg = this.rgTxt.getText();
        String siape = this.siapeTxt.getText();
        String cep = this.cepTxt.getText();
        String descricao = this.descricaoTxt.getText();
        String bairro = this.bairroTxt.getText();
        Integer numero = Integer.parseInt(this.numeroTxt.getText());
        EnumTipoServidor tipoServidor = EnumTipoServidor.valueOf(this.tipoServidorCbx.getItemAt(this.tipoServidorCbx.getSelectedIndex()));
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        Endereco endereco = new Endereco(null, cep, descricao, numero, bairro, null);
        return new Servidor(id, nome, dataNascimento, fone, fone2, email, cpf, rg, endereco, siape, tipoServidor, null);
    }

    public void resetar() {
        if (idLbl.getText().isEmpty()) {
            this.nomeTxt.setText("");
            this.emailTxt.setText("");
            this.diaTxt.setText("");
            this.mesTxt.setText("");
            this.anoTxt.setText("");
            this.foneTxt.setText("");
            this.fone2Txt.setText("");
            this.cpfTxt.setText("");
            this.rgTxt.setText("");
            this.siapeTxt.setText("");
            this.cepTxt.setText("");
            this.descricaoTxt.setText("");
            this.bairroTxt.setText("");
            this.numeroTxt.setText("");
            this.tipoServidorCbx.setSelectedIndex(0);
            this.cidadeCbx.setSelectedIndex(0);
        }
    }

    public void setDados(Servidor servidor) {
        this.idLbl.setText(String.valueOf(servidor.getId()));
        this.nomeTxt.setText(servidor.getNome());
        this.emailTxt.setText(servidor.getEmail());
        this.diaTxt.setText(String.valueOf(servidor.getDataNascimento().getDayOfMonth()));
        this.mesTxt.setText(String.valueOf(servidor.getDataNascimento().getMonthValue()));
        this.anoTxt.setText(String.valueOf(servidor.getDataNascimento().getYear()));
        this.foneTxt.setText(servidor.getFone());
        this.fone2Txt.setText(servidor.getFone2());
        this.cpfTxt.setText(servidor.getCpf());
        this.rgTxt.setText(servidor.getRg());
        this.siapeTxt.setText(servidor.getSiape());
        this.cepTxt.setText(servidor.getSiape());
        this.descricaoTxt.setText(servidor.getEndereco().getDescricao());
        this.bairroTxt.setText(servidor.getEndereco().getBairro());
        this.numeroTxt.setText(String.valueOf(servidor.getEndereco().getNumero()));
        this.tipoServidorCbx.setSelectedIndex(0);
        this.cidadeCbx.setSelectedIndex(0);
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
        WindowUtils.AtivaInputs(estadoInputs, this.dadosEnderecoPanel);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        tituloLbl = new JLabel();
        dadosPanel = new JPanel();
        label2 = new JLabel();
        nomeTxt = new JTextField();
        emailTxt = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        label1 = new JLabel();
        label5 = new JLabel();
        diaTxt = new JTextField();
        mesTxt = new JTextField();
        anoTxt = new JTextField();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        tipoServidorCbx = new JComboBox<>();
        label13 = new JLabel();
        dadosEnderecoPanel = new JPanel();
        label14 = new JLabel();
        cepTxt = new JTextField();
        bairroTxt = new JTextField();
        label15 = new JLabel();
        descricaoTxt = new JTextField();
        label16 = new JLabel();
        label17 = new JLabel();
        numeroTxt = new JTextField();
        label18 = new JLabel();
        cidadeCbx = new JComboBox<>();
        foneTxt = new JTextField();
        fone2Txt = new JTextField();
        cpfTxt = new JTextField();
        rgTxt = new JTextField();
        siapeTxt = new JTextField();
        buttonBar = new JPanel();
        novoBtn = new JButton();
        cancelarBtn = new JButton();
        gravarBtn = new JButton();
        buscarBtn = new JButton();
        sairBtn = new JButton();
        idLbl = new JLabel();

        //======== this ========
        setTitle("IFSC - Servidores");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,dialogPane. getBorder () ) ); dialogPane. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
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

                    //---- label2 ----
                    label2.setText("Nome");

                    //---- label3 ----
                    label3.setText("E-mail");

                    //---- label4 ----
                    label4.setText("Data Nascimento");

                    //---- label1 ----
                    label1.setText("Dia");

                    //---- label5 ----
                    label5.setText("M\u00eas");

                    //---- label6 ----
                    label6.setText("Ano");

                    //---- label7 ----
                    label7.setText("Telefone");

                    //---- label8 ----
                    label8.setText("Telefone 2");

                    //---- label9 ----
                    label9.setText("RG");

                    //---- label10 ----
                    label10.setText("CPF");

                    //---- label11 ----
                    label11.setText("Tipo servidor");

                    //---- tipoServidorCbx ----
                    tipoServidorCbx.setModel(new DefaultComboBoxModel<>(new String[] {
                        "TAE",
                        "Docente"
                    }));

                    //---- label13 ----
                    label13.setText("Siape");

                    //======== dadosEnderecoPanel ========
                    {
                        dadosEnderecoPanel.setBorder(new BevelBorder(BevelBorder.RAISED));

                        //---- label14 ----
                        label14.setText("CEP");

                        //---- label15 ----
                        label15.setText("Bairro");

                        //---- label16 ----
                        label16.setText("Rua");

                        //---- label17 ----
                        label17.setText("N\u00ba");

                        //---- label18 ----
                        label18.setText("Cidade");

                        //---- cidadeCbx ----
                        cidadeCbx.setModel(new DefaultComboBoxModel<>(new String[] {
                            "Tubar\u00e3o"
                        }));

                        GroupLayout dadosEnderecoPanelLayout = new GroupLayout(dadosEnderecoPanel);
                        dadosEnderecoPanel.setLayout(dadosEnderecoPanelLayout);
                        dadosEnderecoPanelLayout.setHorizontalGroup(
                            dadosEnderecoPanelLayout.createParallelGroup()
                                .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                        .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                                .addComponent(label14)
                                                .addComponent(cepTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                            .addGap(224, 248, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                                .addComponent(label18)
                                                .addComponent(cidadeCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                            .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                                .addComponent(label15)
                                                .addComponent(bairroTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                            .addGap(11, 11, 11))
                                        .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                                .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                                    .addComponent(label16)
                                                    .addGap(262, 262, 262)
                                                    .addComponent(label17))
                                                .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                                    .addComponent(descricaoTxt, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(numeroTxt, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 0, Short.MAX_VALUE))))
                        );
                        dadosEnderecoPanelLayout.setVerticalGroup(
                            dadosEnderecoPanelLayout.createParallelGroup()
                                .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label14)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cepTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                        .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(label15)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bairroTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addGap(18, 18, Short.MAX_VALUE)
                                            .addComponent(label18)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cidadeCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(24, 24, 24)
                                    .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addComponent(label16)
                                            .addGap(1, 1, 1))
                                        .addComponent(label17, GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(dadosEnderecoPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(numeroTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(descricaoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(11, Short.MAX_VALUE))
                        );
                    }

                    GroupLayout dadosPanelLayout = new GroupLayout(dadosPanel);
                    dadosPanel.setLayout(dadosPanelLayout);
                    dadosPanelLayout.setHorizontalGroup(
                        dadosPanelLayout.createParallelGroup()
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addComponent(label4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(dadosEnderecoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nomeTxt, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(emailTxt, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(GroupLayout.Alignment.LEADING, dadosPanelLayout.createSequentialGroup()
                                        .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label2, GroupLayout.Alignment.LEADING)
                                            .addComponent(label3, GroupLayout.Alignment.LEADING)
                                            .addGroup(GroupLayout.Alignment.LEADING, dadosPanelLayout.createSequentialGroup()
                                                .addComponent(label1)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(diaTxt, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mesTxt, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label6)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(anoTxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(GroupLayout.Alignment.LEADING, dadosPanelLayout.createSequentialGroup()
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addComponent(foneTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label7))
                                                .addGap(18, 18, 18)
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addComponent(label8)
                                                    .addComponent(fone2Txt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(GroupLayout.Alignment.LEADING, dadosPanelLayout.createSequentialGroup()
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addComponent(label10)
                                                    .addComponent(label11)
                                                    .addComponent(tipoServidorCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cpfTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addComponent(label9)
                                                    .addComponent(rgTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label13)
                                                    .addComponent(siapeTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 15, Short.MAX_VALUE)))
                                .addContainerGap())
                    );
                    dadosPanelLayout.setVerticalGroup(
                        dadosPanelLayout.createParallelGroup()
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label2)
                                .addGap(14, 14, 14)
                                .addComponent(nomeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label3)
                                .addGap(12, 12, 12)
                                .addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label4)
                                .addGap(18, 18, 18)
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label1)
                                    .addComponent(diaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5)
                                    .addComponent(mesTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(anoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6))
                                .addGap(18, 18, 18)
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label7)
                                    .addComponent(label8))
                                .addGap(8, 8, 8)
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(foneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fone2Txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label10)
                                    .addComponent(label9))
                                .addGap(9, 9, 9)
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(cpfTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rgTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label11)
                                    .addComponent(label13))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(tipoServidorCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(siapeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(dadosEnderecoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
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
    private JLabel label2;
    private JTextField nomeTxt;
    private JTextField emailTxt;
    private JLabel label3;
    private JLabel label4;
    private JLabel label1;
    private JLabel label5;
    private JTextField diaTxt;
    private JTextField mesTxt;
    private JTextField anoTxt;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JComboBox<String> tipoServidorCbx;
    private JLabel label13;
    private JPanel dadosEnderecoPanel;
    private JLabel label14;
    private JTextField cepTxt;
    private JTextField bairroTxt;
    private JLabel label15;
    private JTextField descricaoTxt;
    private JLabel label16;
    private JLabel label17;
    private JTextField numeroTxt;
    private JLabel label18;
    private JComboBox<String> cidadeCbx;
    private JTextField foneTxt;
    private JTextField fone2Txt;
    private JTextField cpfTxt;
    private JTextField rgTxt;
    private JTextField siapeTxt;
    private JPanel buttonBar;
    private JButton novoBtn;
    private JButton cancelarBtn;
    private JButton gravarBtn;
    private JButton buscarBtn;
    private JButton sairBtn;
    private JLabel idLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
