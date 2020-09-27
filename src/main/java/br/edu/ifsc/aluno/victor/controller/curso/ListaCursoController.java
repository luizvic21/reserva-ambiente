package br.edu.ifsc.aluno.victor.controller.curso;

import br.edu.ifsc.aluno.victor.Utils.BotaoUtils;
import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.CursoController;
import br.edu.ifsc.aluno.victor.controller.bloco.FormularioBlocoController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.view.bloco.FormularioBlocoView;
import br.edu.ifsc.aluno.victor.view.curso.ListaCursoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Service
public class ListaCursoController implements ActionListener {

    @Autowired
    private CursoController cursoController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private FormularioBlocoController formularioBlocoController;

    private ListaCursoView listaCursoView;

    public void init(ListaCursoView listaCursoView) {
        this.listaCursoView = listaCursoView;
        this.listaCursoView.initButtons(this);
        this.definirTabela();
        this.carregaLista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(listaCursoView.getCadastrarBtn())) {
            this.abrirFormularioCadastro();
        } else  if (e.getSource().equals(listaCursoView.getEditarBtn())) {
            this.clickEditar();
        } else  if (e.getSource().equals(listaCursoView.getDeletarBtn())) {
            this.clickRemover();
        } else  if (e.getSource().equals(listaCursoView.getFecharBtn())) {
            WindowUtils.Exit(listaCursoView);
        } else  if (e.getSource().equals(listaCursoView.getMenuBtn())) {
            BotaoUtils.VoltarMenu(listaCursoView, menuController);
        }
    }

    public void abrir() {
        this.listaCursoView.setVisible(true);
    }

    private void abrirFormularioCadastro() {
        FormularioBlocoView formularioBlocoView = new FormularioBlocoView(listaCursoView);
        this.formularioBlocoController.init(formularioBlocoView);
        this.formularioBlocoController.abrir();
    }

    private void definirTabela() {
        String[] colunas = {"Id", "Descricao", "Modalidade", "Periodo", "E-mail"};
        this.listaCursoView.setColumnsNameListagem(colunas);
    }

    public void carregaLista() {
        DefaultTableModel tabela = (DefaultTableModel) this.listaCursoView.getListagemTbt().getModel();
        for (int i = 0; i < tabela.getRowCount(); i++) {
            tabela.removeRow(i);
            this.listaCursoView.getListagemTbt().repaint();
        }
        if (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        List<Curso> cursos = cursoController.consultar();
        cursos.forEach(curso -> {
            tabela.addRow(new Object[]{
                    curso.getId(),
                    curso.getDescricao(),
                    curso.getModalidade().getDescricao(),
                    curso.getPeriodo().getDescricao(),
                    curso.getEmail()
            });
        });
    }

    private void clickRemover() {
        JTable listagem = this.listaCursoView.getListagemTbt();
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
            this.cursoController.deletar(id);
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
