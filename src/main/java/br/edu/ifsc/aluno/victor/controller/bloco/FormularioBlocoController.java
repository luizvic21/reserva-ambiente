package br.edu.ifsc.aluno.victor.controller.bloco;

import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.BlocoController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Bloco;
import br.edu.ifsc.aluno.victor.view.bloco.FormularioBlocoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Service
public class FormularioBlocoController implements ActionListener {

    @Autowired
    private BlocoController blocoController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private ListaBlocoController listaBlocoController;

    private FormularioBlocoView formularioBlocoView;

    private Integer id;

    public void init(FormularioBlocoView formularioBlocoView) {
        this.formularioBlocoView = formularioBlocoView;
        this.formularioBlocoView.initButtons(this);
        this.formularioBlocoView.ativarBotoes(true);
        this.formularioBlocoView.ativaInputs(true);
        this.formularioBlocoView.setTituloLbl("Cadastrar bloco");
    }

    public void init(FormularioBlocoView formularioBlocoView, Bloco bloco) {
        this.formularioBlocoView = formularioBlocoView;
        this.formularioBlocoView.initButtons(this);
        this.formularioBlocoView.ativaInputs(false);
        this.formularioBlocoView.ativarBotoes(false);
        this.formularioBlocoView.setDados(bloco);
        this.id = bloco.getId();
        this.formularioBlocoView.setTituloLbl("Editar bloco");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioBlocoView.getNovoBtn())) {
            this.clickNovo();
        } else if (e.getSource().equals(formularioBlocoView.getGravarBtn())) {
            this.clickGravar();
        } else if (e.getSource().equals(formularioBlocoView.getCancelarBtn())) {
            this.clickCancelar();
        } else if (e.getSource().equals(formularioBlocoView.getBuscarBtn())) {
            WindowUtils.Exit(formularioBlocoView);
        } else if (e.getSource().equals(formularioBlocoView.getSairBtn())) {
            this.clickSair();
        }
    }

    private void clickGravar() {
        if (Objects.isNull(id)) {
            blocoController.cadastrar(formularioBlocoView.getDados());
            MensagensUtils.CadastroSucesso("Bloco");
        } else {
            blocoController.alterar(id, formularioBlocoView.getDados());
            MensagensUtils.EditarSucesso("Bloco");
        }
        this.formularioBlocoView.ativarBotoes(true);
        this.formularioBlocoView.ativaInputs(true);
        this.formularioBlocoView.resetar();
    }

    public void abrir() {
        this.formularioBlocoView.setVisible(true);
    }

    private void clickNovo() {
        this.formularioBlocoView.ativarBotoes(false);
        this.formularioBlocoView.ativaInputs(false);
    }

    private void clickCancelar() {
        this.formularioBlocoView.ativarBotoes(true);
        this.formularioBlocoView.ativaInputs(true);
        formularioBlocoView.resetar();
    }

    private void clickSair() {
        this.listaBlocoController.carregaLista();
        this.formularioBlocoView.dispose();
    }
}
