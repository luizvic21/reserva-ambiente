package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.Servidor;
import br.edu.ifsc.aluno.victor.model.dao.ConnectionFactory;
import br.edu.ifsc.aluno.victor.model.dao.ServidorDAO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServidorDAOJdbc implements ServidorDAO {

    @Override
    public void create(Servidor object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO servidor (nome, data_nascimento, fone, fone2, email, cpf, rg, siape, tipo_servidor, foto, endereco_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getNome());
            pstm.setDate(2, Date.valueOf(object.getDataNascimento()));
            pstm.setString(3, object.getFone());
            pstm.setString(4, object.getFone2());
            pstm.setString(5, object.getEmail());
            pstm.setString(6, object.getCpf());
            pstm.setString(7, object.getRg());
            pstm.setString(8, object.getSiape());
            pstm.setString(9, object.getTipoServidor().toString());
            pstm.setString(10, object.getFoto());
            pstm.setInt(11, object.getEndereco().getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<Servidor> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT\n" +
                "  s.id as servidor_id,\n" +
                "       s.nome,\n" +
                "       s.data_nascimento,\n" +
                "       s.fone,\n" +
                "       s.fone2,\n" +
                "       s.email,\n" +
                "       s.cpf,\n" +
                "       s.rg,\n" +
                "       s.siape,\n" +
                "       s.tipo_servidor,\n" +
                "       s.foto,\n" +
                "       e.cep,\n" +
                "       e.descricao as endereco_descricao,\n" +
                "       e.numero,\n" +
                "       e.bairro,\n" +
                "       cidade_id,\n" +
                "       c.descricao as cidade_descricao " +
                "FROM\n" +
                "     servido s" +
                "     JOIN endereco e on s.endereco = e.id\n" +
                "     JOIN cidade c on e.cidade_id = c.id\n" +
                "WHERE\n" +
                "   e.id = ?";

        try {
            Servidor servidor = null;
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
                servidor = new Servidor(
                        rs.getInt("servidor_id"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("fone"),
                        rs.getString("fone2"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        endereco,
                        rs.getString("siape"),
                        EnumTipoServidor.valueOf(rs.getString("tipo_servidor")),
                        rs.getString("foto")
                );
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(servidor)) {
                return Optional.of(servidor);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Servidor> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT\n" +
                "  s.id as servidor_id,\n" +
                "       s.nome,\n" +
                "       s.data_nascimento,\n" +
                "       s.fone,\n" +
                "       s.fone2,\n" +
                "       s.email,\n" +
                "       s.cpf,\n" +
                "       s.rg,\n" +
                "       s.siape,\n" +
                "       s.tipo_servidor,\n" +
                "       s.foto,\n" +
                "       e.cep,\n" +
                "       e.descricao as endereco_descricao,\n" +
                "       e.numero,\n" +
                "       e.bairro,\n" +
                "       cidade_id,\n" +
                "       c.descricao as cidade_descricao " +
                "FROM\n" +
                "     servido s" +
                "     JOIN endereco e on s.endereco = e.id\n" +
                "     JOIN cidade c on e.cidade_id = c.id\n";

        try {
            List<Servidor> servidores = new ArrayList<>();
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
                Servidor servidor = new Servidor(
                        rs.getInt("servidor_id"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("fone"),
                        rs.getString("fone2"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        endereco,
                        rs.getString("siape"),
                        EnumTipoServidor.valueOf(rs.getString("tipo_servidor")),
                        rs.getString("foto")
                );
                servidores.add(servidor);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            return servidores;
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void update(Servidor object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE servidor SET nome = ?, data_nascimento = ?, fone = ?, fone2 = ?, email = ?, cpf = ?, rg = ?, siape = ?, tipo_servidor = ?, foto = ?, endereco_id = ? WHERE id =  ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getNome());
            pstm.setDate(2, Date.valueOf(object.getDataNascimento()));
            pstm.setString(3, object.getFone());
            pstm.setString(4, object.getFone2());
            pstm.setString(5, object.getEmail());
            pstm.setString(6, object.getCpf());
            pstm.setString(7, object.getRg());
            pstm.setString(8, object.getSiape());
            pstm.setString(9, object.getTipoServidor().toString());
            pstm.setString(10, object.getFoto());
            pstm.setInt(11, object.getEndereco().getId());
            pstm.setInt(12, object.getId());
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

        String query = "DELETE FROM servidor WHERE id = ?";

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
