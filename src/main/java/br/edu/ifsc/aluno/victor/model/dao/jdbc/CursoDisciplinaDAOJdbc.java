package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.enuns.EnumModalidade;
import br.edu.ifsc.aluno.victor.enuns.EnumPeriodo;
import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import br.edu.ifsc.aluno.victor.model.*;
import br.edu.ifsc.aluno.victor.model.dao.ConnectionFactory;
import br.edu.ifsc.aluno.victor.model.dao.CursoDisciplinaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CursoDisciplinaDAOJdbc implements CursoDisciplinaDAO {

    @Override
    public void create(CursoDisciplina object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO curso_disciplina (sigla_curso, fase_curso, carga_horaria, docente_id, curso_id, disciplina_id) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getSiglaCurso());
            pstm.setInt(2, object.getFaseCurso());
            pstm.setInt(3, object.getCargaHoraria());
            pstm.setInt(4, object.getDocente().getId());
            pstm.setInt(5, object.getCurso().getId());
            pstm.setInt(6, object.getDisciplina().getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<CursoDisciplina> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT \n" +
                "    cd.id AS id,\n" +
                "       cd.sigla_curso,\n" +
                "       cd.fase_curso,\n" +
                "       cd.carga_horaria,\n" +
                "       cd.curso_id,\n" +
                "       cd.disciplina_id,\n" +
                "       cd.docente_id,\n" +
                "       cur.descricao AS curso_descricao,\n" +
                "       cur.modalidade,\n" +
                "       cur.periodo,\n" +
                "       cur.email AS curso_email,\n" +
                "       d.descricao AS disciplina_descricao,\n" +
                "       s.nome,\n" +
                "       s.data_nascimento,\n" +
                "       s.fone,\n" +
                "       s.fone2,\n" +
                "       s.email AS docente_email,\n" +
                "       s.cpf,\n" +
                "       s.rg,\n" +
                "       s.siape,\n" +
                "       s.tipo_servidor,\n" +
                "       s.foto,\n" +
                "       s.pessoa_id,\n" +
                "       s.endereco,\n" +
                "       e.cep,\n" +
                "       e.descricao AS endereco_descricao,\n" +
                "       e.numero,\n" +
                "       e.bairro,\n" +
                "       e.cidade_id,\n" +
                "       cid.descricao AS cidade_descricao\n" +
                "FROM\n" +
                "    curso_disciplina cd\n" +
                "    JOIN curso cur ON cd.curso_id = cur.id\n" +
                "    JOIN disciplina d ON cd.disciplina_id = d.id\n" +
                "    JOIN servidor s ON cd.docente_id = s.id\n" +
                "    JOIN endereco e ON s.endereco = e.id\n" +
                "    JOIN cidade cid ON e.cidade_id = cid.id\n" +
                "WHERE\n" +
                "  cd.id = ?";

        try {
            CursoDisciplina cursoDisciplina = null;
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade(
                        rs.getInt("cidade_id"),
                        rs.getString("cidade_descricao")
                );
                Endereco endereco = new Endereco(
                        rs.getInt("endereco_id"),
                        rs.getString("cep"),
                        rs.getString("endereco_descricao"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        cidade);
                Curso curso = new Curso(
                        rs.getInt("curso_id"),
                        rs.getString("curso_descricao"),
                        rs.getString("curso_email"),
                        EnumModalidade.valueOf(rs.getString("modalidade")),
                        EnumPeriodo.valueOf(rs.getString("periodo"))
                );
                Servidor docente = new Servidor(
                        rs.getInt("servidor_id"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("fone"),
                        rs.getString("fone2"),
                        rs.getString("docente_email"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        endereco,
                        rs.getString("siape"),
                        EnumTipoServidor.valueOf(rs.getString("tipo_servidor")),
                        rs.getString("foto")
                );
                Disciplina disciplina = new Disciplina(rs.getInt("disciplina_id"), rs.getString("disciplina_descricao"));
                cursoDisciplina = new CursoDisciplina(
                    rs.getInt("id"),
                    rs.getString("sigla_curso"),
                    rs.getInt("fase_curso"),
                    rs.getInt("carga_horaria"),
                    docente,
                    curso,
                    disciplina
                );
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(cursoDisciplina)) {
                return Optional.of(cursoDisciplina);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<CursoDisciplina> findAll() {
        {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            String query = "SELECT \n" +
                    "    cd.id AS id,\n" +
                    "       cd.sigla_curso,\n" +
                    "       cd.fase_curso,\n" +
                    "       cd.carga_horaria,\n" +
                    "       cd.curso_id,\n" +
                    "       cd.disciplina_id,\n" +
                    "       cd.docente_id,\n" +
                    "       cur.descricao AS curso_descricao,\n" +
                    "       cur.modalidade,\n" +
                    "       cur.periodo,\n" +
                    "       cur.email AS curso_email,\n" +
                    "       d.descricao AS disciplina_descricao,\n" +
                    "       s.nome,\n" +
                    "       s.data_nascimento,\n" +
                    "       s.fone,\n" +
                    "       s.fone2,\n" +
                    "       s.email AS docente_email,\n" +
                    "       s.cpf,\n" +
                    "       s.rg,\n" +
                    "       s.siape,\n" +
                    "       s.tipo_servidor,\n" +
                    "       s.foto,\n" +
                    "       s.pessoa_id,\n" +
                    "       s.endereco,\n" +
                    "       e.cep,\n" +
                    "       e.descricao AS endereco_descricao,\n" +
                    "       e.numero,\n" +
                    "       e.bairro,\n" +
                    "       e.cidade_id,\n" +
                    "       cid.descricao AS cidade_descricao\n" +
                    "FROM\n" +
                    "    curso_disciplina cd\n" +
                    "    JOIN curso cur ON cd.curso_id = cur.id\n" +
                    "    JOIN disciplina d ON cd.disciplina_id = d.id\n" +
                    "    JOIN servidor s ON cd.docente_id = s.id\n" +
                    "    JOIN endereco e ON s.endereco = e.id\n" +
                    "    JOIN cidade cid ON e.cidade_id = cid.id";

            try {
                List<CursoDisciplina> cursosDisciplinas = new ArrayList<>();
                pstm = connection.prepareStatement(query);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    Cidade cidade = new Cidade(
                            rs.getInt("cidade_id"),
                            rs.getString("cidade_descricao")
                    );
                    Endereco endereco = new Endereco(
                            rs.getInt("endereco_id"),
                            rs.getString("cep"),
                            rs.getString("endereco_descricao"),
                            rs.getInt("numero"),
                            rs.getString("bairro"),
                            cidade);
                    Curso curso = new Curso(
                            rs.getInt("curso_id"),
                            rs.getString("curso_descricao"),
                            rs.getString("curso_email"),
                            EnumModalidade.valueOf(rs.getString("modalidade")),
                            EnumPeriodo.valueOf(rs.getString("periodo"))
                    );
                    Servidor docente = new Servidor(
                            rs.getInt("servidor_id"),
                            rs.getString("nome"),
                            rs.getDate("data_nascimento").toLocalDate(),
                            rs.getString("fone"),
                            rs.getString("fone2"),
                            rs.getString("docente_email"),
                            rs.getString("cpf"),
                            rs.getString("rg"),
                            endereco,
                            rs.getString("siape"),
                            EnumTipoServidor.valueOf(rs.getString("tipo_servidor")),
                            rs.getString("foto")
                    );
                    Disciplina disciplina = new Disciplina(rs.getInt("disciplina_id"), rs.getString("disciplina_descricao"));
                    CursoDisciplina cursoDisciplina = new CursoDisciplina(
                            rs.getInt("id"),
                            rs.getString("sigla_curso"),
                            rs.getInt("fase_curso"),
                            rs.getInt("carga_horaria"),
                            docente,
                            curso,
                            disciplina
                    );
                    cursosDisciplinas.add(cursoDisciplina);
                }

                ConnectionFactory.closeConnection(connection, pstm, rs);

                return cursosDisciplinas;
            } catch (SQLException ex) {
                ConnectionFactory.closeConnection(connection);
                ex.printStackTrace();
            }

            return new ArrayList<>();
        }
    }

    @Override
    public void update(CursoDisciplina object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE curso_disciplina SET sigla_curso = ?, fase_curso = ?, carga_horaria = ?, docente_id = ?, curso_id = ?, disciplina_id = ? WHERE id = ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getSiglaCurso());
            pstm.setInt(2, object.getFaseCurso());
            pstm.setInt(3, object.getCargaHoraria());
            pstm.setInt(4, object.getDocente().getId());
            pstm.setInt(5, object.getCurso().getId());
            pstm.setInt(6, object.getDisciplina().getId());
            pstm.setInt(7, object.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "DELETE FROM curso_disciplina WHERE id = ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }
}
