package br.edu.ifsc.aluno.victor.controller.disciplina;

import br.edu.ifsc.aluno.victor.Utils.MensagensUtils;
import br.edu.ifsc.aluno.victor.Utils.WindowUtils;
import br.edu.ifsc.aluno.victor.controller.CursoController;
import br.edu.ifsc.aluno.victor.controller.CursoDisciplinaController;
import br.edu.ifsc.aluno.victor.controller.ServidorController;
import br.edu.ifsc.aluno.victor.controller.system.MenuController;
import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.model.CursoDisciplina;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.view.disciplina.FormularioDisciplinaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Service
public class FormularioDisciplinaController implements ActionListener {

    @Autowired
    private CursoDisciplinaController cursoDisciplinaController;

    @Autowired
    private MenuController menuController;

    @Autowired
    private ListaDisciplinaController listaDisciplinaController;

    @Autowired
    private CursoController cursoController;

    @Autowired
    private ServidorController servidorController;

    private FormularioDisciplinaView formularioDisciplinaView;

    private Integer id;

    public void init(FormularioDisciplinaView formularioDisciplinaView) {
        this.formularioDisciplinaView = formularioDisciplinaView;
        this.formularioDisciplinaView.initButtons(this);
        this.formularioDisciplinaView.ativarBotoes(true);
        this.formularioDisciplinaView.ativaInputs(true);
        this.formularioDisciplinaView.setTituloLbl("Cadastrar disciplina");
    }

    public void init(FormularioDisciplinaView formularioDisciplinaView, CursoDisciplina cursoDisciplina) {
        this.formularioDisciplinaView = formularioDisciplinaView;
        this.formularioDisciplinaView.initButtons(this);
        this.formularioDisciplinaView.ativaInputs(false);
        this.formularioDisciplinaView.ativarBotoes(false);
        this.formularioDisciplinaView.setDados(cursoDisciplina);
        this.id = cursoDisciplina.getId();
        this.formularioDisciplinaView.setTituloLbl("Editar disciplina");
        this.formularioDisciplinaView.setCursoCbx(cursoController.consultar());
        this.formularioDisciplinaView.setDocenteCbx(servidorController.consultarPorTipo(EnumTipoServidor.DOCENTE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioDisciplinaView.getNovoBtn())) {
            this.clickNovo();
        } else if (e.getSource().equals(formularioDisciplinaView.getGravarBtn())) {
            this.clickGravar();
        } else if (e.getSource().equals(formularioDisciplinaView.getCancelarBtn())) {
            this.clickCancelar();
        } else if (e.getSource().equals(formularioDisciplinaView.getBuscarBtn())) {
            WindowUtils.Exit(formularioDisciplinaView);
        } else if (e.getSource().equals(formularioDisciplinaView.getSairBtn())) {
            this.clickSair();
        }
    }

    private void clickGravar() {
        CursoDisciplina cursoDisciplina = formularioDisciplinaView.getDados();
        Servidor docente = servidorController.consultarPorNome(cursoDisciplina.getDocente().getNome());
        Curso curso = cursoController.consultarPorDescricao(cursoDisciplina.getCurso().getDescricao());
        cursoDisciplina = new CursoDisciplina(docente, curso, cursoDisciplina.getDisciplina(), cursoDisciplina);
        if (Objects.isNull(id)) {
            cursoDisciplinaController.cadastrar(cursoDisciplina);
            MensagensUtils.CadastroSucesso("Disciplina");
        } else {
            cursoDisciplinaController.alterar(id, cursoDisciplina);
            MensagensUtils.EditarSucesso("Bloco");
        }
        this.formularioDisciplinaView.ativarBotoes(true);
        this.formularioDisciplinaView.ativaInputs(true);
        this.formularioDisciplinaView.resetar();
    }

    public void abrir() {
        this.formularioDisciplinaView.setVisible(true);
    }

    private void clickNovo() {
        this.formularioDisciplinaView.setCursoCbx(cursoController.consultar());
        this.formularioDisciplinaView.setDocenteCbx(servidorController.consultarPorTipo(EnumTipoServidor.DOCENTE));
        this.formularioDisciplinaView.ativarBotoes(false);
        this.formularioDisciplinaView.ativaInputs(false);
    }

    private void clickCancelar() {
        this.formularioDisciplinaView.ativarBotoes(true);
        this.formularioDisciplinaView.ativaInputs(true);
        formularioDisciplinaView.resetar();
    }

    private void clickSair() {
        this.listaDisciplinaController.carregaLista();
        this.formularioDisciplinaView.dispose();
    }
}
