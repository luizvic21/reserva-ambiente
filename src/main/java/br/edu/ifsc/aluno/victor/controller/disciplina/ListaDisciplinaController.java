package br.edu.ifsc.aluno.victor.controller.disciplina;

import br.edu.ifsc.aluno.victor.Utils.BotaoUtils;
import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.CursoDisciplinaController;
import br.edu.ifsc.aluno.victor.controller.bloco.FormularioBlocoController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.CursoDisciplina;
import br.edu.ifsc.aluno.victor.view.bloco.FormularioBlocoView;
import br.edu.ifsc.aluno.victor.view.disciplina.ListaDisciplinaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Service
public class ListaDisciplinaController implements ActionListener {

    @Autowired
    private CursoDisciplinaController cursoDisciplinaController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private FormularioBlocoController formularioBlocoController;

    private ListaDisciplinaView listaDisciplinaView;

    public void init(ListaDisciplinaView listaDisciplinaView) {
        this.listaDisciplinaView = listaDisciplinaView;
        this.listaDisciplinaView.initButtons(this);
        this.definirTabela();
        this.carregaLista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(listaDisciplinaView.getCadastrarBtn())) {
            this.abrirFormularioCadastro();
        } else  if (e.getSource().equals(listaDisciplinaView.getEditarBtn())) {
            this.clickEditar();
        } else  if (e.getSource().equals(listaDisciplinaView.getDeletarBtn())) {
            this.clickRemover();
        } else  if (e.getSource().equals(listaDisciplinaView.getFecharBtn())) {
            WindowUtils.Exit(listaDisciplinaView);
        } else  if (e.getSource().equals(listaDisciplinaView.getMenuBtn())) {
            BotaoUtils.VoltarMenu(listaDisciplinaView, menuController);
        }
    }

    public void abrir() {
        this.listaDisciplinaView.setVisible(true);
    }

    private void abrirFormularioCadastro() {
        FormularioBlocoView formularioBlocoView = new FormularioBlocoView(listaDisciplinaView);
        this.formularioBlocoController.init(formularioBlocoView);
        this.formularioBlocoController.abrir();
    }

    private void definirTabela() {
        String[] colunas = {"Id", "Disciplina", "Curso", "Sigla", "Fase do curso", "Carga Horaria", "Docente"};
        this.listaDisciplinaView.setColumnsNameListagem(colunas);
    }

    public void carregaLista() {
        DefaultTableModel tabela = (DefaultTableModel) this.listaDisciplinaView.getListagemTbt().getModel();
        for (int i = 0; i < tabela.getRowCount(); i++) {
            tabela.removeRow(i);
            this.listaDisciplinaView.getListagemTbt().repaint();
        }
        if (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        List<CursoDisciplina> disciplinas = cursoDisciplinaController.consultar();
        disciplinas.forEach(disciplina -> {
            tabela.addRow(new Object[]{
                    disciplina.getId(),
                    disciplina.getDisciplina().getDescricao(),
                    disciplina.getCurso().getDescricao(),
                    disciplina.getSiglaCurso(),
                    disciplina.getFaseCurso(),
                    disciplina.getCargaHoraria(),
                    disciplina.getDocente().getNome()
            });
        });
    }

    private void clickRemover() {
        JTable listagem = this.listaDisciplinaView.getListagemTbt();
        if(listagem.getSelectedRow() > -1){
            this.remover(listagem);
        }else{
            MensagensUtils.ErroRemover();
        }
    }

    private void remover(JTable tabela) {
        int codigoLinha = tabela.getSelectedRow();
        String descricao = tabela.getValueAt(codigoLinha, 1).toString();
        int isRemover = MensagensUtils.RemoverMensagem("Bloco", descricao);
        if (isRemover == 0) {
            Integer id = Integer.valueOf(tabela.getValueAt(codigoLinha, 0).toString());
            this.cursoDisciplinaController.deletar(id);
            DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
            dtm.removeRow(codigoLinha);
        }
    }

    private void clickEditar() {
//        JTable listagem = this.listaServidorView.getListagemTbt();
//        if(listagem.getSelectedRow() > -1){
//            int codigoLinha = listagem.getSelectedRow();
//            Integer id = Integer.parseInt(listagem.getValueAt(codigoLinha, 0).toString());
//
//            Bloco bloco = servidorController.consultarPorId(id);
//            FormularioBlocoView formularioBlocoView = new FormularioBlocoView(null);
//            formularioBlocoController.init(formularioBlocoView, bloco);
//            formularioBlocoController.abrir();
//        }else{
//            MensagensUtils.ErroEditar();
//        }
    }
}
