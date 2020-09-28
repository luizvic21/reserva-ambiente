package br.edu.ifsc.aluno.victor.controller.ambiente;

import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.AmbienteController;
import br.edu.ifsc.aluno.victor.controller.BlocoController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Ambiente;
import br.edu.ifsc.aluno.victor.model.Bloco;
import br.edu.ifsc.aluno.victor.view.ambiente.FormularioAmbienteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Service
public class FormularioAmbienteController implements ActionListener {

    @Autowired
    private AmbienteController ambienteController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private ListaAmbienteController listaAmbienteController;

    @Autowired
    private BlocoController blocoController;

    private FormularioAmbienteView formularioAmbienteView;

    private Integer id;

    public void init(FormularioAmbienteView formularioAmbienteView) {
        this.formularioAmbienteView = formularioAmbienteView;
        this.formularioAmbienteView.initButtons(this);
        this.formularioAmbienteView.ativarBotoes(true);
        this.formularioAmbienteView.ativaInputs(true);
        this.formularioAmbienteView.setTituloLbl("Cadastrar bloco");
    }

    public void init(FormularioAmbienteView formularioAmbienteView, Ambiente bloco) {
        this.formularioAmbienteView = formularioAmbienteView;
        this.formularioAmbienteView.initButtons(this);
        this.formularioAmbienteView.ativaInputs(false);
        this.formularioAmbienteView.ativarBotoes(false);
        this.formularioAmbienteView.setDados(bloco);
        this.id = bloco.getId();
        this.formularioAmbienteView.setTituloLbl("Editar bloco");
        this.formularioAmbienteView.setBlocoCbx(blocoController.consultar());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioAmbienteView.getNovoBtn())) {
            this.clickNovo();
        } else if (e.getSource().equals(formularioAmbienteView.getGravarBtn())) {
            this.clickGravar();
        } else if (e.getSource().equals(formularioAmbienteView.getCancelarBtn())) {
            this.clickCancelar();
        } else if (e.getSource().equals(formularioAmbienteView.getBuscarBtn())) {
            WindowUtils.Exit(formularioAmbienteView);
        } else if (e.getSource().equals(formularioAmbienteView.getSairBtn())) {
            this.clickSair();
        }
    }

    private void clickGravar() {
        Ambiente ambiente = formularioAmbienteView.getDados();
        Bloco bloco = blocoController.consultarPorDescricao(ambiente.getBloco().getDescricao());
        ambiente = new Ambiente(bloco, ambiente);
        if (Objects.isNull(id)) {
            ambienteController.cadastrar(ambiente);
            MensagensUtils.CadastroSucesso("Ambiente");
        } else {
            ambienteController.alterar(id, ambiente);
            MensagensUtils.EditarSucesso("Ambiente");
        }
        this.formularioAmbienteView.ativarBotoes(true);
        this.formularioAmbienteView.ativaInputs(true);
        this.formularioAmbienteView.resetar();
    }

    public void abrir() {
        this.formularioAmbienteView.setVisible(true);
    }

    private void clickNovo() {
        this.formularioAmbienteView.setBlocoCbx(blocoController.consultar());
        this.formularioAmbienteView.ativarBotoes(false);
        this.formularioAmbienteView.ativaInputs(false);
    }

    private void clickCancelar() {
        this.formularioAmbienteView.ativarBotoes(true);
        this.formularioAmbienteView.ativaInputs(true);
        formularioAmbienteView.resetar();
    }

    private void clickSair() {
        this.listaAmbienteController.carregaLista();
        this.formularioAmbienteView.dispose();
    }
}
