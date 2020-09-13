package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.dao.ConnectionFactory;
import br.edu.ifsc.aluno.victor.model.dao.EnderecoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EnderecoDAOJdbc implements EnderecoDAO {

    @Override
    public void create(Endereco object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO endereco (cep, descricao, numero, bairro, cidade_id) VALUES (?, ?, ?, ?, ?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getCep());
            pstm.setString(2, object.getDescricao());
            pstm.setInt(3, object.getNumero());
            pstm.setString(4, object.getBairro());
            pstm.setInt(5, object.getCidade().getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<Endereco> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT\n" +
                "    e.id as endereco_id,\n" +
                "    cep,\n" +
                "    e.descricao as endereco_descricao,\n" +
                "    numero,\n" +
                "    bairro,\n" +
                "    cidade_id,\n" +
                "    c.descricao as cidade_descricao\n" +
                "FROM\n" +
                "    endereco e\n" +
                "    inner join cidade c on e.cidade_id = c.id\n" +
                "WHERE\n" +
                "   e.id = ?";

        try {
            Endereco endereco = null;
            pstm = connection.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade(
                        rs.getInt("cidade_id"),
                        rs.getString("cidade_descricao")
                );
                endereco = new Endereco(
                        rs.getInt("endereco_id"),
                        rs.getString("cep"),
                        rs.getString("endereco_descricao"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        cidade);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(endereco)) {
                return Optional.of(endereco);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Endereco> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT\n" +
                "    e.id as endereco_id,\n" +
                "    cep,\n" +
                "    e.descricao as endereco_descricao,\n" +
                "    numero,\n" +
                "    bairro,\n" +
                "    cidade_id,\n" +
                "    c.descricao as cidade_descricao\n" +
                "FROM\n" +
                "    endereco e\n" +
                "    inner join cidade c on e.cidade_id = c.id;\n";

        try {
            List<Endereco> enderecos = new ArrayList<>();
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
                enderecos.add(endereco);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);
            return enderecos;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void update(Endereco object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE endereco SET cep = ?, descricao= ?, numero = ?, bairro = ?, cidade_id = ? WHERE id = ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getCep());
            pstm.setString(2, object.getDescricao());
            pstm.setInt(3, object.getNumero());
            pstm.setString(4, object.getBairro());
            pstm.setInt(5, object.getCidade().getId());
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

        String query = "DELETE FROM endereco WHERE id = ?";

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
