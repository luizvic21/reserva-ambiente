package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.model.Disciplina;
import br.edu.ifsc.aluno.victor.model.dao.ConnectionFactory;
import br.edu.ifsc.aluno.victor.model.dao.DisciplinaDAO;
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
public class DisciplinaDAOJdbc implements DisciplinaDAO {

    @Override
    public void create(Disciplina object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO disciplina (descricao) VALUES (?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getDescricao());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<Disciplina> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT id, descricao FROM disciplina WHERE id = ?";

        try {
            Disciplina disciplina = null;
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                disciplina = new Disciplina(rs.getInt("id"), rs.getString("descricao"));
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(disciplina)) {
                return Optional.of(disciplina);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Disciplina> findAll(){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT id, descricao FROM disciplina";

        try {
            List<Disciplina> disciplinas = new ArrayList<>();
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina(rs.getInt("id"), rs.getString("descricao"));
                disciplinas.add(disciplina);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);
            return disciplinas;
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void update(Disciplina object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE disciplina SET descricao = ? WHERE id = ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getDescricao());
            pstm.setInt(2, object.getId());
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

        String query = "DELETE FROM disciplina WHERE id = ?";

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

    @Override
    public Integer createReturnId(Disciplina disciplina) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Integer id = null;

        String query = "INSERT INTO disciplina (descricao) VALUES (?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, disciplina.getDescricao());
            pstm.executeUpdate();
            rs = pstm.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                id = rs.getInt("LAST_INSERT_ID()");
            }
            ConnectionFactory.closeConnection(connection, pstm, rs);
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return id;
    }
}
