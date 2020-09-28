/*
 * Created by JFormDesigner on Sun Sep 20 21:47:54 BRT 2020
 */

package br.edu.ifsc.aluno.victor.view.usuario;

import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.Usuario;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

/**
 * @author unknown
 */
public class FormularioUsuarioView extends JDialog {
    public FormularioUsuarioView(Window owner) {
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

    public Usuario getDados() {
        Integer id = idLbl.getText().isEmpty() ? null : Integer.parseInt(idLbl.getText());
        String nome = this.nomeTxt.getText();
        String email = this.emailTxt.getText();
        String username = this.usernameTxt.getText();
        String senha = this.senhaTxt.getText();
        Integer dia = Integer.parseInt(this.diaTxt.getText());
        Integer mes = Integer.parseInt(this.mesTxt.getText());
        Integer ano = Integer.parseInt(this.anoTxt.getText());
        String fone = this.foneTxt.getText();
        String fone2 = this.fone2Txt.getText();
        String cpf = this.cpfTxt.getText();
        String rg = this.rgTxt.getText();
        String cep = this.cepTxt.getText();
        String descricao = this.descricaoTxt.getText();
        String bairro = this.bairroTxt.getText();
        Integer numero = Integer.parseInt(this.numeroTxt.getText());
        LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
        Cidade cidade = new Cidade(null,(String) cidadeCbx.getSelectedItem());
        Endereco endereco = new Endereco(null, cep, descricao, numero, bairro, cidade);
        return new Usuario(id, nome, dataNascimento, fone, fone2, email, cpf, rg, endereco, username, senha);
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
            this.usernameTxt.setText("");
            this.senhaTxt.setText("");
            this.cepTxt.setText("");
            this.descricaoTxt.setText("");
            this.bairroTxt.setText("");
            this.numeroTxt.setText("");
            cidadeCbx.removeAllItems();
        }
    }

    public void setDados(Usuario usuario) {
        this.idLbl.setText(String.valueOf(usuario.getId()));
        this.nomeTxt.setText(usuario.getNome());
        this.emailTxt.setText(usuario.getEmail());
        this.diaTxt.setText(String.valueOf(usuario.getDataNascimento().getDayOfMonth()));
        this.mesTxt.setText(String.valueOf(usuario.getDataNascimento().getMonthValue()));
        this.anoTxt.setText(String.valueOf(usuario.getDataNascimento().getYear()));
        this.foneTxt.setText(usuario.getFone());
        this.fone2Txt.setText(usuario.getFone2());
        this.cpfTxt.setText(usuario.getCpf());
        this.rgTxt.setText(usuario.getRg());
        this.usernameTxt.setText(usuario.getUsername());
        this.senhaTxt.setText(usuario.getSenha());
        this.cepTxt.setText(usuario.getEndereco().getCep());
        this.descricaoTxt.setText(usuario.getEndereco().getDescricao());
        this.bairroTxt.setText(usuario.getEndereco().getBairro());
        this.numeroTxt.setText(String.valueOf(usuario.getEndereco().getNumero()));
        this.cidadeCbx.addItem(usuario.getEndereco().getCidade().getDescricao());
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
    
    public void setCidades(List<Cidade> cidades) {
        cidades.forEach(cidade -> cidadeCbx.addItem(cidade.getDescricao()));
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
        dadosEnderecoPanel = new JPanel();
        label14 = new JLabel();
        cepTxt = new JTextField();
        bairroTxt = new JTextField();
        label15 = new JLabel();
        label18 = new JLabel();
        cidadeCbx = new JComboBox();
        label12 = new JLabel();
        descricaoTxt = new JTextField();
        label16 = new JLabel();
        numeroTxt = new JTextField();
        foneTxt = new JTextField();
        fone2Txt = new JTextField();
        cpfTxt = new JTextField();
        rgTxt = new JTextField();
        usernameTxt = new JTextField();
        label11 = new JLabel();
        label13 = new JLabel();
        senhaTxt = new JPasswordField();
        buttonBar = new JPanel();
        novoBtn = new JButton();
        cancelarBtn = new JButton();
        gravarBtn = new JButton();
        buscarBtn = new JButton();
        sairBtn = new JButton();
        idLbl = new JLabel();

        //======== this ========
        setTitle("IFSC - Usuarios");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
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

                    //======== dadosEnderecoPanel ========
                    {
                        dadosEnderecoPanel.setBorder(new BevelBorder(BevelBorder.RAISED));

                        //---- label14 ----
                        label14.setText("CEP");

                        //---- label15 ----
                        label15.setText("Bairro");

                        //---- label18 ----
                        label18.setText("Cidade");

                        //---- label12 ----
                        label12.setText("Rua");

                        //---- label16 ----
                        label16.setText("N\u00ba");

                        GroupLayout dadosEnderecoPanelLayout = new GroupLayout(dadosEnderecoPanel);
                        dadosEnderecoPanel.setLayout(dadosEnderecoPanelLayout);
                        dadosEnderecoPanelLayout.setHorizontalGroup(
                            dadosEnderecoPanelLayout.createParallelGroup()
                                .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(dadosEnderecoPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(GroupLayout.Alignment.LEADING, dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addComponent(label14)
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.LEADING, dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                                .addComponent(cepTxt, GroupLayout.Alignment.TRAILING)
                                                .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                                    .addComponent(descricaoTxt, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(47, 47, 47)
                                                    .addComponent(numeroTxt)))
                                            .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.LEADING, dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addComponent(label12)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label16)
                                            .addGap(192, 192, 192))
                                        .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                                .addComponent(label18)
                                                .addComponent(cidadeCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                                .addComponent(label15)
                                                .addComponent(bairroTxt, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap())))
                        );
                        dadosEnderecoPanelLayout.setVerticalGroup(
                            dadosEnderecoPanelLayout.createParallelGroup()
                                .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label14)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cepTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addGroup(dadosEnderecoPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addComponent(label15)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(bairroTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(dadosEnderecoPanelLayout.createSequentialGroup()
                                            .addComponent(label18)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cidadeCbx, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(dadosEnderecoPanelLayout.createParallelGroup()
                                        .addComponent(label12)
                                        .addComponent(label16))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(dadosEnderecoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(descricaoTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(numeroTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                    }

                    //---- label11 ----
                    label11.setText("Username");

                    //---- label13 ----
                    label13.setText("Senha");

                    GroupLayout dadosPanelLayout = new GroupLayout(dadosPanel);
                    dadosPanel.setLayout(dadosPanelLayout);
                    dadosPanelLayout.setHorizontalGroup(
                        dadosPanelLayout.createParallelGroup()
                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dadosPanelLayout.createParallelGroup()
                                    .addGroup(dadosPanelLayout.createSequentialGroup()
                                        .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label2, GroupLayout.Alignment.LEADING)
                                            .addComponent(label3, GroupLayout.Alignment.LEADING))
                                        .addGap(350, 350, 350))
                                    .addGroup(dadosPanelLayout.createSequentialGroup()
                                        .addGroup(dadosPanelLayout.createParallelGroup()
                                            .addComponent(dadosEnderecoPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nomeTxt, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(emailTxt, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addComponent(label10)
                                                    .addComponent(cpfTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addComponent(rgTxt)
                                                    .addGroup(dadosPanelLayout.createSequentialGroup()
                                                        .addComponent(label9)
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addComponent(foneTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label7))
                                                .addGap(18, 18, 18)
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addGroup(dadosPanelLayout.createSequentialGroup()
                                                        .addComponent(label8)
                                                        .addGap(169, 169, 169))
                                                    .addComponent(fone2Txt)))
                                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                                .addGroup(dadosPanelLayout.createParallelGroup()
                                                    .addComponent(label4)
                                                    .addGroup(dadosPanelLayout.createSequentialGroup()
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
                                                        .addComponent(anoTxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(272, 272, 272)))
                                        .addContainerGap())
                                    .addGroup(dadosPanelLayout.createSequentialGroup()
                                        .addGroup(dadosPanelLayout.createParallelGroup()
                                            .addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label11))
                                        .addGap(18, 18, 18)
                                        .addGroup(dadosPanelLayout.createParallelGroup()
                                            .addGroup(dadosPanelLayout.createSequentialGroup()
                                                .addComponent(label13)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(senhaTxt))
                                        .addGap(6, 6, 6))))
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
                                .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addGroup(dadosPanelLayout.createSequentialGroup()
                                        .addComponent(emailTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(dadosPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label11)
                                            .addComponent(label13))
                                        .addGap(9, 9, 9)
                                        .addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(senhaTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
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
    private JPanel dadosEnderecoPanel;
    private JLabel label14;
    private JTextField cepTxt;
    private JTextField bairroTxt;
    private JLabel label15;
    private JLabel label18;
    private JComboBox cidadeCbx;
    private JLabel label12;
    private JTextField descricaoTxt;
    private JLabel label16;
    private JTextField numeroTxt;
    private JTextField foneTxt;
    private JTextField fone2Txt;
    private JTextField cpfTxt;
    private JTextField rgTxt;
    private JTextField usernameTxt;
    private JLabel label11;
    private JLabel label13;
    private JPasswordField senhaTxt;
    private JPanel buttonBar;
    private JButton novoBtn;
    private JButton cancelarBtn;
    private JButton gravarBtn;
    private JButton buscarBtn;
    private JButton sairBtn;
    private JLabel idLbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
