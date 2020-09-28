package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.model.Bloco;
import br.edu.ifsc.aluno.victor.model.dao.BlocoDAO;
import br.edu.ifsc.aluno.victor.model.dao.ConnectionFactory;
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
public class BlocoDAOJdbc implements BlocoDAO {

    @Override
    public void create(Bloco object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO bloco (descricao, foto) VALUES (?, ?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getDescricao());
            pstm.setString(2, object.getFoto());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<Bloco> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT id, descricao, foto FROM bloco WHERE id = ?";

        try {
            Bloco bloco = null;
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                bloco = new Bloco(rs.getInt("id"), rs.getString("descricao"), rs.getString("foto"));
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(bloco)) {
                return Optional.of(bloco);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Bloco> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT id, descricao, foto FROM bloco";

        try {
            List<Bloco> blocos = new ArrayList<>();
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Bloco bloco = new Bloco(rs.getInt("id"), rs.getString("descricao"), rs.getString("foto"));
                blocos.add(bloco);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);
            return blocos;
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void update(Bloco object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE bloco SET descricao = ?, foto = ? WHERE id = ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getDescricao());
            pstm.setString(2, object.getFoto());
            pstm.setInt(3, object.getId());
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

        String query = "DELETE FROM bloco WHERE id = ?";

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
    public Bloco findByDescricao(String descricao) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT id, descricao, foto FROM bloco WHERE descricao = ?";

        try {
            Bloco bloco = null;
            pstm = connection.prepareStatement(query);
            pstm.setString(1, descricao);
            rs = pstm.executeQuery();

            while (rs.next()) {
                bloco = new Bloco(rs.getInt("id"), rs.getString("descricao"), rs.getString("foto"));
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            return bloco;
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return null;
    }
}
