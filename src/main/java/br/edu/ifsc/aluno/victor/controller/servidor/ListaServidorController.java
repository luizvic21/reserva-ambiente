package br.edu.ifsc.aluno.victor.controller.servidor;

import br.edu.ifsc.aluno.victor.Utils.BotaoUtils;
import br.edu.ifsc.aluno.victor.Utils.DateUtils;
import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.ServidorController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.view.servidor.FormularioServidorView;
import br.edu.ifsc.aluno.victor.view.servidor.ListaServidorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Service
public class ListaServidorController implements ActionListener {

    @Autowired
    private ServidorController servidorController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private FormularioServidorController formularioServidorController;

    private ListaServidorView listaServidorView;

    public void init(ListaServidorView listaServidorView) {
        this.listaServidorView = listaServidorView;
        this.listaServidorView.initButtons(this);
        this.definirTabela();
        this.carregaLista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(listaServidorView.getCadastrarBtn())) {
            this.abrirFormularioCadastro();
        } else  if (e.getSource().equals(listaServidorView.getEditarBtn())) {
            this.clickEditar();
        } else  if (e.getSource().equals(listaServidorView.getDeletarBtn())) {
            this.clickRemover();
        } else  if (e.getSource().equals(listaServidorView.getFecharBtn())) {
            WindowUtils.Exit(listaServidorView);
        } else  if (e.getSource().equals(listaServidorView.getMenuBtn())) {
            BotaoUtils.VoltarMenu(listaServidorView, menuController);
        }
    }

    public void abrir() {
        this.listaServidorView.setVisible(true);
    }

    private void abrirFormularioCadastro() {
        FormularioServidorView formularioServidorView = new FormularioServidorView(listaServidorView);
        this.formularioServidorController.init(formularioServidorView);
        this.formularioServidorController.abrir();
    }

    private void definirTabela() {
        String[] colunas = {"Id", "Nome", "Data nascimento", "E-mail", "Siape", "Tipo servidor", "Telefone", "Telefone 2", "CPF", "RG", "Cidade", "Endereco", "Bairro", "CEP"};
        this.listaServidorView.setColumnsNameListagem(colunas);
    }

    public void carregaLista() {
        DefaultTableModel tabela = (DefaultTableModel) this.listaServidorView.getListagemTbt().getModel();
        for (int i = 0; i < tabela.getRowCount(); i++) {
            tabela.removeRow(i);
            this.listaServidorView.getListagemTbt().repaint();
        }
        if (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        List<Servidor> servidores = servidorController.consultar();
        servidores.forEach(servidor -> {
            String endereco = String.format("%s, %d", servidor.getEndereco().getDescricao(), servidor.getEndereco().getNumero());
            tabela.addRow(new Object[]{
                    servidor.getId(),
                    servidor.getNome(),
                    DateUtils.toStringFormatBrasil(servidor.getDataNascimento()),
                    servidor.getEmail(),
                    servidor.getSiape(),
                    servidor.getTipoServidor().getDescricao(),
                    servidor.getFone(),
                    servidor.getFone2(),
                    servidor.getCpf(),
                    servidor.getRg(),
                    servidor.getEndereco().getCidade().getDescricao(),
                    endereco,
                    servidor.getEndereco().getBairro(),
                    servidor.getEndereco().getCep()
            });
        });
    }

    private void clickRemover() {
        JTable listagem = this.listaServidorView.getListagemTbt();
        if(listagem.getSelectedRow() > -1){
            this.remover(listagem);
        }else{
            MensagensUtils.ErroRemover();
        }
    }

    private void remover(JTable tabela) {
        int codigoLinha = tabela.getSelectedRow();
        String descricao = tabela.getValueAt(codigoLinha, 1).toString();
        int isRemover = MensagensUtils.RemoverMensagem("Servidor", descricao);
        if (isRemover == 0) {
            Integer id = Integer.valueOf(tabela.getValueAt(codigoLinha, 0).toString());
            this.servidorController.deletar(id);
            DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
            dtm.removeRow(codigoLinha);
        }
    }

    private void clickEditar() {
        JTable listagem = this.listaServidorView.getListagemTbt();
        if(listagem.getSelectedRow() > -1){
            int codigoLinha = listagem.getSelectedRow();
            Integer id = Integer.parseInt(listagem.getValueAt(codigoLinha, 0).toString());

            Servidor servidor = servidorController.consultarPorId(id);
            FormularioServidorView formularioServidorView = new FormularioServidorView(null);
            formularioServidorController.init(formularioServidorView, servidor);
            formularioServidorController.abrir();
        }else{
            MensagensUtils.ErroEditar();
        }
    }
}
