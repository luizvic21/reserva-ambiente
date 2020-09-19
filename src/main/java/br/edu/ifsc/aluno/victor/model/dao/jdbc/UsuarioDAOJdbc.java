package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.model.Cidade;
import br.edu.ifsc.aluno.victor.model.Endereco;
import br.edu.ifsc.aluno.victor.model.Usuario;
import br.edu.ifsc.aluno.victor.model.dao.ConnectionFactory;
import br.edu.ifsc.aluno.victor.model.dao.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioDAOJdbc implements UsuarioDAO {

    @Override
    public void create(Usuario object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO usuario (nome, data_nascimento, fone, fone2, email, cpf, rg, username, senha, endereco_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getNome());
            pstm.setDate(2, Date.valueOf(object.getDataNascimento()));
            pstm.setString(3, object.getFone());
            pstm.setString(4, object.getFone2());
            pstm.setString(5, object.getEmail());
            pstm.setString(6, object.getCpf());
            pstm.setString(7, object.getRg());
            pstm.setString(8, object.getUsername());
            pstm.setString(9, object.getSenha());
            pstm.setInt(10, object.getEndereco().getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT\n" +
                "  u.id as servidor_id,\n" +
                "       u.nome,\n" +
                "       u.data_nascimento,\n" +
                "       u.fone,\n" +
                "       u.fone2,\n" +
                "       u.email,\n" +
                "       u.cpf,\n" +
                "       u.rg,\n" +
                "       u.username,\n" +
                "       u.senha,\n" +
                "       e.cep,\n" +
                "       e.descricao as endereco_descricao,\n" +
                "       e.numero,\n" +
                "       e.bairro,\n" +
                "       cidade_id,\n" +
                "       c.descricao as cidade_descricao " +
                "FROM\n" +
                "     usuario u" +
                "     JOIN endereco e on u.endereco = e.id\n" +
                "     JOIN cidade c on e.cidade_id = c.id\n" +
                "WHERE\n" +
                "   e.id = ?";

        try {
            Usuario usuario = null;
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
                usuario = new Usuario(
                        rs.getInt("servidor_id"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("fone"),
                        rs.getString("fone2"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        endereco,
                        rs.getString( "username"),
                        rs.getString("senha")
                );
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(usuario)) {
                return Optional.of(usuario);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Usuario> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT\n" +
                "  u.id as servidor_id,\n" +
                "       u.nome,\n" +
                "       u.data_nascimento,\n" +
                "       u.fone,\n" +
                "       u.fone2,\n" +
                "       u.email,\n" +
                "       u.cpf,\n" +
                "       u.rg,\n" +
                "       u.username,\n" +
                "       u.senha,\n" +
                "       e.cep,\n" +
                "       e.descricao as endereco_descricao,\n" +
                "       e.numero,\n" +
                "       e.bairro,\n" +
                "       cidade_id,\n" +
                "       c.descricao as cidade_descricao " +
                "FROM\n" +
                "     usuario u" +
                "     JOIN endereco e on u.endereco = e.id\n" +
                "     JOIN cidade c on e.cidade_id = c.id\n";

        try {
            List<Usuario> usuarios = new ArrayList<>();
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
                Usuario usuario = new Usuario(
                        rs.getInt("servidor_id"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("fone"),
                        rs.getString("fone2"),
                        rs.getString("email"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        endereco,
                        rs.getString( "username"),
                        rs.getString("senha")
                );
                usuarios.add(usuario);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            return usuarios;
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void update(Usuario object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE usuario SET nome = ?, data_nascimento = ?, fone = ?, fone2 = ?, email = ?, cpf = ?, rg = ?, username = ?, senha = ?, endereco_id = ? WHERE id =  ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setString(1, object.getNome());
            pstm.setDate(2, Date.valueOf(object.getDataNascimento()));
            pstm.setString(3, object.getFone());
            pstm.setString(4, object.getFone2());
            pstm.setString(5, object.getEmail());
            pstm.setString(6, object.getCpf());
            pstm.setString(7, object.getRg());
            pstm.setString(8, object.getUsername());
            pstm.setString(9, object.getSenha());
            pstm.setInt(10, object.getEndereco().getId());
            pstm.setInt(11, object.getId());
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

        String query = "DELETE FROM usuario WHERE id = ?";

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
