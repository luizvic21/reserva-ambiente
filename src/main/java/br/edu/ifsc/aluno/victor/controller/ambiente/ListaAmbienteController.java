package br.edu.ifsc.aluno.victor.controller.ambiente;

import br.edu.ifsc.aluno.victor.Utils.BotaoUtils;
import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.AmbienteController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Ambiente;
import br.edu.ifsc.aluno.victor.view.ambiente.FormularioAmbienteView;
import br.edu.ifsc.aluno.victor.view.ambiente.ListaAmbienteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Service
public class ListaAmbienteController implements ActionListener {

    @Autowired
    private AmbienteController ambienteController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private FormularioAmbienteController formularioAmbienteController;

    private ListaAmbienteView listaAmbienteView;

    public void init(ListaAmbienteView listaAmbienteView) {
        this.listaAmbienteView = listaAmbienteView;
        this.listaAmbienteView.initButtons(this);
        this.definirTabela();
        this.carregaLista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(listaAmbienteView.getCadastrarBtn())) {
            this.abrirFormularioCadastro();
        } else  if (e.getSource().equals(listaAmbienteView.getEditarBtn())) {
            this.clickEditar();
        } else  if (e.getSource().equals(listaAmbienteView.getDeletarBtn())) {
            this.clickRemover();
        } else  if (e.getSource().equals(listaAmbienteView.getFecharBtn())) {
            WindowUtils.Exit(listaAmbienteView);
        } else  if (e.getSource().equals(listaAmbienteView.getMenuBtn())) {
            BotaoUtils.VoltarMenu(listaAmbienteView, menuController);
        }
    }

    public void abrir() {
        this.listaAmbienteView.setVisible(true);
    }

    private void abrirFormularioCadastro() {
        FormularioAmbienteView formularioBlocoView = new FormularioAmbienteView(listaAmbienteView);
        this.formularioAmbienteController.init(formularioBlocoView);
        this.formularioAmbienteController.abrir();
    }

    private void definirTabela() {
        String[] colunas = {"Id", "Descricao", "Sigla", "Chave acesso", "Bloco"};
        this.listaAmbienteView.setColumnsNameListagem(colunas);
    }

    public void carregaLista() {
        DefaultTableModel tabela = (DefaultTableModel) this.listaAmbienteView.getListagemTbt().getModel();
        for (int i = 0; i < tabela.getRowCount(); i++) {
            tabela.removeRow(i);
            this.listaAmbienteView.getListagemTbt().repaint();
        }
        if (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        List<Ambiente> ambientes = ambienteController.consultar();
        ambientes.forEach(ambiente -> tabela.addRow(new Object[]{
                ambiente.getId(),
                ambiente.getDescricao(),
                ambiente.getSigla(),
                ambiente.getChaveAcesso(),
                ambiente.getBloco().getDescricao()
        }));
    }

    private void clickRemover() {
        JTable listagem = this.listaAmbienteView.getListagemTbt();
        if(listagem.getSelectedRow() > -1){
            this.remover(listagem);
        }else{
            MensagensUtils.ErroRemover();
        }
    }

    private void remover(JTable tabela) {
        int codigoLinha = tabela.getSelectedRow();
        String descricao = tabela.getValueAt(codigoLinha, 1).toString();
        int isRemover = MensagensUtils.RemoverMensagem("Ambiente", descricao);
        if (isRemover == 0) {
            Integer id = Integer.valueOf(tabela.getValueAt(codigoLinha, 0).toString());
            this.ambienteController.deletar(id);
            DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
            dtm.removeRow(codigoLinha);
        }
    }

    private void clickEditar() {
        JTable listagem = this.listaAmbienteView.getListagemTbt();
        if(listagem.getSelectedRow() > -1){
            int codigoLinha = listagem.getSelectedRow();
            Integer id = Integer.parseInt(listagem.getValueAt(codigoLinha, 0).toString());

            Ambiente ambiente = ambienteController.consultarPorId(id);
            FormularioAmbienteView formularioBlocoView = new FormularioAmbienteView(listaAmbienteView);
            formularioAmbienteController.init(formularioBlocoView, ambiente);
            formularioAmbienteController.abrir();
        }else{
            MensagensUtils.ErroEditar();
        }
    }
}
