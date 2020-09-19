package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.model.Ambiente;
import br.edu.ifsc.aluno.victor.model.Bloco;
import br.edu.ifsc.aluno.victor.model.dao.AmbienteDAO;
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
public class AmbienteDAOJdbc implements AmbienteDAO {

    @Override
    public void create(Ambiente object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO ambiente (descricao, sigla, foto, chave_acesso, bloco_id) VALUES (?, ?, ?, ?, ?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getDescricao());
            pstm.setString(2, object.getSigla());
            pstm.setString(3, object.getFoto());
            pstm.setString(4, object.getChaveAcesso());
            pstm.setInt(5, object.getBloco().getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<Ambiente> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT\n" +
                "    a.id as ambiente_id,\n" +
                "    a.descricao as ambiente_descricao,\n" +
                "    sigla,\n" +
                "    a.foto as ambiente_foto,\n" +
                "    chave_acesso,\n" +
                "    bloco_id,\n" +
                "    b.descricao as bloco_descricao,\n" +
                "    b.foto as bloco_foto\n" +
                "FROM\n" +
                "    ambiente a\n" +
                "    join bloco b on a.bloco_id = b.id\n" +
                "WHERE\n" +
                "   a.id = ?";

        try {
            Ambiente ambiente = null;
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Bloco bloco = new Bloco(rs.getInt("bloco_id"), rs.getString("bloco_descricao"), rs.getString("bloco_foto"));
                ambiente = new Ambiente(
                        rs.getInt("id"),
                        rs.getString("ambiente_descricao"),
                        rs.getString("sigla"),
                        rs.getString("ambiente_foto"),
                        rs.getString("chave_acesso"),
                        bloco);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(ambiente)) {
                return Optional.of(ambiente);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Ambiente> findAll(){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT\n" +
                "    a.id as ambiente_id,\n" +
                "    a.descricao as ambiente_descricao,\n" +
                "    sigla,\n" +
                "    a.foto as ambiente_foto,\n" +
                "    chave_acesso,\n" +
                "    bloco_id,\n" +
                "    b.descricao as bloco_descricao,\n" +
                "    b.foto as bloco_foto\n" +
                "FROM\n" +
                "    ambiente a\n" +
                "    join bloco b on a.bloco_id = b.id\n";

        try {
            ArrayList<Ambiente> ambientes = new ArrayList<>();
            pstm = connection.prepareStatement(query);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Bloco bloco = new Bloco(rs.getInt("bloco_id"), rs.getString("bloco_descricao"), rs.getString("bloco_foto"));
                Ambiente ambiente = new Ambiente(
                        rs.getInt("id"),
                        rs.getString("ambiente_descricao"),
                        rs.getString("sigla"),
                        rs.getString("ambiente_foto"),
                        rs.getString("chave_acesso"),
                        bloco);
                ambientes.add(ambiente);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            return ambientes;
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void update(Ambiente object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE ambiente SET descricao = ?, sigla = ?, foto = ?, chave_acesso = ?, bloco_id = ? WHERE id = ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getDescricao());
            pstm.setString(2, object.getSigla());
            pstm.setString(3, object.getFoto());
            pstm.setString(4, object.getChaveAcesso());
            pstm.setInt(5, object.getBloco().getId());
            pstm.setInt(6, object.getId());
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

        String query = "DELETE FROM ambiente WHERE id = ?";

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
