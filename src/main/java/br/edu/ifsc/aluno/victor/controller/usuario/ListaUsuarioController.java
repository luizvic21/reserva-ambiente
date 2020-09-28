package br.edu.ifsc.aluno.victor.controller.usuario;

import br.edu.ifsc.aluno.victor.Utils.BotaoUtils;
import br.edu.ifsc.aluno.victor.Utils.DateUtils;
import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.UsuarioController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Usuario;
import br.edu.ifsc.aluno.victor.view.usuario.FormularioUsuarioView;
import br.edu.ifsc.aluno.victor.view.usuario.ListaUsuarioView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

@Service
public class ListaUsuarioController implements ActionListener {

    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private FormularioUsuarioController formularioUsuarioController;

    private ListaUsuarioView listaUsuarioView;

    public void init(ListaUsuarioView listaUsuarioView) {
        this.listaUsuarioView = listaUsuarioView;
        this.listaUsuarioView.initButtons(this);
        this.definirTabela();
        this.carregaLista();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(listaUsuarioView.getCadastrarBtn())) {
            this.abrirFormularioCadastro();
        } else  if (e.getSource().equals(listaUsuarioView.getEditarBtn())) {
            this.clickEditar();
        } else  if (e.getSource().equals(listaUsuarioView.getDeletarBtn())) {
            this.clickRemover();
        } else  if (e.getSource().equals(listaUsuarioView.getFecharBtn())) {
            WindowUtils.Exit(listaUsuarioView);
        } else  if (e.getSource().equals(listaUsuarioView.getMenuBtn())) {
            BotaoUtils.VoltarMenu(listaUsuarioView, menuController);
        }
    }

    public void abrir() {
        this.listaUsuarioView.setVisible(true);
    }

    private void abrirFormularioCadastro() {
        FormularioUsuarioView formularioUsuarioView = new FormularioUsuarioView(listaUsuarioView);
        this.formularioUsuarioController.init(formularioUsuarioView);
        this.formularioUsuarioController.abrir();
    }

    private void definirTabela() {
        String[] colunas = {"Id", "Nome", "Username", "Data nascimento", "E-mail", "Telefone", "Telefone 2", "CPF", "RG", "Cidade", "Endereco", "Bairro", "CEP"};
        this.listaUsuarioView.setColumnsNameListagem(colunas);
    }

    public void carregaLista() {
        DefaultTableModel tabela = (DefaultTableModel) this.listaUsuarioView.getListagemTbt().getModel();
        for (int i = 0; i < tabela.getRowCount(); i++) {
            tabela.removeRow(i);
            this.listaUsuarioView.getListagemTbt().repaint();
        }
        if (tabela.getRowCount() > 0) {
            tabela.removeRow(0);
        }
        List<Usuario> usuarios = usuarioController.consultar();
        usuarios.forEach(usuario -> {
            String endereco = String.format("%s, %d", usuario.getEndereco().getDescricao(), usuario.getEndereco().getNumero());
            tabela.addRow(new Object[]{
                    usuario.getId(),
                    usuario.getNome(),
                    DateUtils.toStringFormatBrasil(usuario.getDataNascimento()),
                    usuario.getEmail(),
                    usuario.getUsername(),
                    usuario.getFone(),
                    usuario.getFone2(),
                    usuario.getCpf(),
                    usuario.getRg(),
                    usuario.getEndereco().getCidade().getDescricao(),
                    endereco,
                    usuario.getEndereco().getBairro(),
                    usuario.getEndereco().getCep()
            });
        });
    }

    private void clickRemover() {
        JTable listagem = this.listaUsuarioView.getListagemTbt();
        if(listagem.getSelectedRow() > -1){
            this.remover(listagem);
        }else{
            MensagensUtils.ErroRemover();
        }
    }

    private void remover(JTable tabela) {
        int codigoLinha = tabela.getSelectedRow();
        String descricao = tabela.getValueAt(codigoLinha, 2).toString();
        int isRemover = MensagensUtils.RemoverMensagem("Usuario", descricao);
        if (isRemover == 0) {
            Integer id = Integer.valueOf(tabela.getValueAt(codigoLinha, 0).toString());
            this.usuarioController.deletar(id);
            DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
            dtm.removeRow(codigoLinha);
        }
    }

    private void clickEditar() {
        JTable listagem = this.listaUsuarioView.getListagemTbt();
        if(listagem.getSelectedRow() > -1){
            int codigoLinha = listagem.getSelectedRow();
            Integer id = Integer.parseInt(listagem.getValueAt(codigoLinha, 0).toString());

            Usuario servidor = usuarioController.consultarPorId(id);
            FormularioUsuarioView formularioUsuarioView = new FormularioUsuarioView(null);
            formularioUsuarioController.init(formularioUsuarioView, servidor);
            formularioUsuarioController.abrir();
        }else{
            MensagensUtils.ErroEditar();
        }
    }

    public boolean isAtivo() {
        return Objects.nonNull(this.listaUsuarioView);
    }
}
