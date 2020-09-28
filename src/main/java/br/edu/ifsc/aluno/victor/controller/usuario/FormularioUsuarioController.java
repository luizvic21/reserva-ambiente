package br.edu.ifsc.aluno.victor.controller.usuario;

import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.CidadeController;
import br.edu.ifsc.aluno.victor.controller.UsuarioController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.Usuario;
import br.edu.ifsc.aluno.victor.view.usuario.FormularioUsuarioView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Service
public class FormularioUsuarioController implements ActionListener {

    @Autowired
    private UsuarioController usuarioController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private ListaUsuarioController listaUsuarioController;

    @Autowired
    private CidadeController cidadeController;

    private FormularioUsuarioView formularioUsuarioView;

    private Integer id;

    public void init(FormularioUsuarioView formularioUsuarioView) {
        this.formularioUsuarioView = formularioUsuarioView;
        this.formularioUsuarioView.initButtons(this);
        this.formularioUsuarioView.ativarBotoes(true);
        this.formularioUsuarioView.ativaInputs(true);
        this.formularioUsuarioView.setTituloLbl("Cadastrar usuario");
    }

    public void init(FormularioUsuarioView formularioUsuarioView, Usuario usuario) {
        this.formularioUsuarioView = formularioUsuarioView;
        this.formularioUsuarioView.initButtons(this);
        this.formularioUsuarioView.ativaInputs(false);
        this.formularioUsuarioView.ativarBotoes(false);
        this.formularioUsuarioView.setDados(usuario);
        this.id = usuario.getId();
        this.formularioUsuarioView.setTituloLbl("Editar usuario");
        this.formularioUsuarioView.setCidades(cidadeController.consultar());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioUsuarioView.getNovoBtn())) {
            this.clickNovo();
        } else if (e.getSource().equals(formularioUsuarioView.getGravarBtn())) {
            this.clickGravar();
        } else if (e.getSource().equals(formularioUsuarioView.getCancelarBtn())) {
            this.clickCancelar();
        } else if (e.getSource().equals(formularioUsuarioView.getBuscarBtn())) {
            WindowUtils.Exit(formularioUsuarioView);
        } else if (e.getSource().equals(formularioUsuarioView.getSairBtn())) {
            this.clickSair();
        }
    }

    private void clickGravar() {
        Usuario usuario = formularioUsuarioView.getDados();
        Cidade cidade = cidadeController.consultarPorDescricao(usuario.getEndereco().getCidade().getDescricao());
        Endereco endereco = new Endereco(cidade, usuario.getEndereco());
        usuario = new Usuario(endereco, usuario);
        if (Objects.isNull(id)) {

            usuarioController.cadastrar(usuario);
            MensagensUtils.CadastroSucesso("Usuario");
        } else {
            usuarioController.alterar(id, usuario);
            MensagensUtils.EditarSucesso("Usuario");
        }
        this.formularioUsuarioView.ativarBotoes(true);
        this.formularioUsuarioView.ativaInputs(true);
        this.formularioUsuarioView.resetar();
    }

    public void abrir() {
        this.formularioUsuarioView.setVisible(true);
    }

    private void clickNovo() {
        this.formularioUsuarioView.ativarBotoes(false);
        this.formularioUsuarioView.ativaInputs(false);
        this.formularioUsuarioView.setCidades(cidadeController.consultar());
    }

    private void clickCancelar() {
        this.formularioUsuarioView.ativarBotoes(true);
        this.formularioUsuarioView.ativaInputs(true);
        formularioUsuarioView.resetar();
    }

    private void clickSair() {
        if (this.listaUsuarioController.isAtivo()) {
            this.listaUsuarioController.carregaLista();
        }
        this.formularioUsuarioView.dispose();
    }
}
