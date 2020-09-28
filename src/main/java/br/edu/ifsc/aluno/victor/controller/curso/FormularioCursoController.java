package br.edu.ifsc.aluno.victor.controller.curso;

import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.CursoController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.view.curso.FormularioCursoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Service
public class FormularioCursoController implements ActionListener {

    @Autowired
    private CursoController cursoController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private ListaCursoController listaCursoController;

    private FormularioCursoView formularioCursoView;

    private Integer id;

    public void init(FormularioCursoView formularioCursoView) {
        this.formularioCursoView = formularioCursoView;
        this.formularioCursoView.initButtons(this);
        this.formularioCursoView.ativarBotoes(true);
        this.formularioCursoView.ativaInputs(true);
        this.formularioCursoView.setTituloLbl("Cadastrar curso");
    }

    public void init(FormularioCursoView formularioCursoView, Curso curso) {
        this.formularioCursoView = formularioCursoView;
        this.formularioCursoView.initButtons(this);
        this.formularioCursoView.ativaInputs(false);
        this.formularioCursoView.ativarBotoes(false);
        this.formularioCursoView.setDados(curso);
        this.id = curso.getId();
        this.formularioCursoView.setTituloLbl("Editar curso");
        this.formularioCursoView.setModalidadeCbx();
        this.formularioCursoView.setPeriodoCbx();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioCursoView.getNovoBtn())) {
            this.clickNovo();
        } else if (e.getSource().equals(formularioCursoView.getGravarBtn())) {
            this.clickGravar();
        } else if (e.getSource().equals(formularioCursoView.getCancelarBtn())) {
            this.clickCancelar();
        } else if (e.getSource().equals(formularioCursoView.getBuscarBtn())) {
            WindowUtils.Exit(formularioCursoView);
        } else if (e.getSource().equals(formularioCursoView.getSairBtn())) {
            this.clickSair();
        }
    }

    private void clickGravar() {
        if (Objects.isNull(id)) {
            cursoController.cadastrar(formularioCursoView.getDados());
            MensagensUtils.CadastroSucesso("Curso");
        } else {
            cursoController.alterar(id, formularioCursoView.getDados());
            MensagensUtils.EditarSucesso("Curso");
        }
        this.formularioCursoView.ativarBotoes(true);
        this.formularioCursoView.ativaInputs(true);
        this.formularioCursoView.resetar();
    }

    public void abrir() {
        this.formularioCursoView.setVisible(true);
    }

    private void clickNovo() {
        this.formularioCursoView.setModalidadeCbx();
        this.formularioCursoView.setPeriodoCbx();
        this.formularioCursoView.ativarBotoes(false);
        this.formularioCursoView.ativaInputs(false);
    }

    private void clickCancelar() {
        this.formularioCursoView.ativarBotoes(true);
        this.formularioCursoView.ativaInputs(true);
        formularioCursoView.resetar();
    }

    private void clickSair() {
        this.listaCursoController.carregaLista();
        this.formularioCursoView.dispose();
    }
}
