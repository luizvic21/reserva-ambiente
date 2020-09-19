package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.enuns.EnumModalidade;
import br.edu.ifsc.aluno.victor.enuns.EnumPeriodo;
import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Curso;
import br.edu.ifsc.aluno.victor.model.dao.ConnectionFactory;
import br.edu.ifsc.aluno.victor.model.dao.CursoDAO;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CursoDAOJdbc implements CursoDAO {

    @Override
    public void create(Curso object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO curso (descricao, email, modalidade, periodo) VALUES (?, ?, ?, ?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getDescricao());
            pstm.setString(2, object.getEmail());
            pstm.setString(3, object.getModalidade().toString());
            pstm.setString(4, object.getPeriodo().toString());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<Curso> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT id, descricao, email, modalidade, periodo FROM curso WHERE id = ?";

        try {
            Curso curso = null;
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("email"),
                        EnumModalidade.valueOf(rs.getString("modalidade")),
                        EnumPeriodo.valueOf(rs.getString("periodo"))
                );
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(curso)) {
                return Optional.of(curso);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Curso> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT id, descricao, email, modalidade, periodo FROM curso";

        try {
            List<Curso> cursos = new ArrayList<>();
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getString("email"),
                        EnumModalidade.valueOf(rs.getString("modalidade")),
                        EnumPeriodo.valueOf(rs.getString("periodo"))
                );
                cursos.add(curso);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);
            return cursos;
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void update(Curso object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE curso SET descricao = ?, email = ?, modalidade = ?, periodo = ? WHERE id = ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getDescricao());
            pstm.setString(2, object.getEmail());
            pstm.setString(3, object.getModalidade().toString());
            pstm.setString(4, object.getPeriodo().toString());
            pstm.setInt(5, object.getId());
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

        String query = "DELETE FROM curso WHERE id = ?";

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
