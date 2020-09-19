package br.edu.ifsc.aluno.victor.model.dao.jdbc;

import br.edu.ifsc.aluno.victor.enuns.EnumModalidade;
import br.edu.ifsc.aluno.victor.enuns.EnumPeriodo;
import br.edu.ifsc.aluno.victor.enuns.EnumTipoServidor;
import br.edu.ifsc.aluno.victor.model.*;
import br.edu.ifsc.aluno.victor.model.dao.ConnectionFactory;
import br.edu.ifsc.aluno.victor.model.dao.CoordenadorDAO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CoordenadorDAOJdbc implements CoordenadorDAO {

    @Override
    public void create(Coordenador object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "INSERT INTO coordenador (data_inicio, data_fim, ativo, servidor_id, curso_id) VALUES (?, ?, ?, ?, ?)";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setDate(1, Date.valueOf(object.getDataInicio()));
            pstm.setDate(2, Date.valueOf(object.getDataFim()));
            pstm.setBoolean(3, object.getAtivo());
            pstm.setInt(4, object.getServidor().getId());
            pstm.setInt(5, object.getCurso().getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, pstm);
    }

    @Override
    public Optional<Coordenador> findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT \n" +
                "       coor.id,\n" +
                "       coor.data_inicio,\n" +
                "       coor.data_fim,\n" +
                "       coor.ativo,\n" +
                "       coor.servidor_id,\n" +
                "       coor.curso_id,\n" +
                "       cur.descricao as curso_descricao,\n" +
                "       cur.email as curso_email,\n" +
                "       modalidade,\n" +
                "       periodo," +
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
                "       e.cidade_id,\n" +
                "       cid.descricao as cidade_descricao\n" +
                "FROM\n" +
                "    coordenador coor\n" +
                "    JOIN curso cur ON coor.curso_id = cur.id" +
                "    JOIN servidor s ON coor.servidor_id = s.id\n" +
                "    JOIN endereco e ON s.endereco = e.id\n" +
                "    JOIN cidade cid ON e.cidade_id = coor.id\n" +
                "WHERE \n" +
                "    coor.id = ?";

        try {
            Coordenador coordenador = null;
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

                coordenador = new Coordenador(
                        rs.getInt("id"),
                        rs.getDate("data_inicio").toLocalDate(),
                        rs.getDate("data_fim").toLocalDate(),
                        rs.getBoolean("ativo"),
                        servidor,
                        curso
                );
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            if (Objects.nonNull(coordenador)) {
                return Optional.of(coordenador);
            }

            return Optional.empty();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Coordenador> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm;
        ResultSet rs;

        String query = "SELECT \n" +
                "       coor.id,\n" +
                "       coor.data_inicio,\n" +
                "       coor.data_fim,\n" +
                "       coor.ativo,\n" +
                "       coor.servidor_id,\n" +
                "       coor.curso_id,\n" +
                "       cur.descricao as curso_descricao,\n" +
                "       cur.email as curso_email,\n" +
                "       modalidade,\n" +
                "       periodo," +
                "       s.nome,\n" +
                "       s.data_nascimento,\n" +
                "       s.fone,\n" +
                "       s.fone2,\n" +
                "       s.email AS servidor_email,\n" +
                "       s.cpf,\n" +
                "       s.rg,\n" +
                "       s.siape,\n" +
                "       s.tipo_servidor,\n" +
                "       s.foto,\n" +
                "       e.cep,\n" +
                "       e.descricao as endereco_descricao,\n" +
                "       e.numero,\n" +
                "       e.bairro,\n" +
                "       e.cidade_id,\n" +
                "       cid.descricao as cidade_descricao\n" +
                "FROM\n" +
                "    coordenador coor\n" +
                "    JOIN curso cur ON coor.curso_id = cur.id" +
                "    JOIN servidor s ON coor.servidor_id = s.id\n" +
                "    JOIN endereco e ON s.endereco = e.id\n" +
                "    JOIN cidade cid ON e.cidade_id = coor.id\n";

        try {
            List<Coordenador> coordenadores = new ArrayList<>();
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
                Servidor servidor = new Servidor(
                        rs.getInt("servidor_id"),
                        rs.getString("nome"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("fone"),
                        rs.getString("fone2"),
                        rs.getString("servidor_email"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        endereco,
                        rs.getString("siape"),
                        EnumTipoServidor.valueOf(rs.getString("tipo_servidor")),
                        rs.getString("foto")
                );
                Coordenador coordenador = new Coordenador(
                        rs.getInt("id"),
                        rs.getDate("data_inicio").toLocalDate(),
                        rs.getDate("data_fim").toLocalDate(),
                        rs.getBoolean("ativo"),
                        servidor,
                        curso
                );

                coordenadores.add(coordenador);
            }

            ConnectionFactory.closeConnection(connection, pstm, rs);

            return coordenadores;
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection);
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void update(Coordenador object) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;

        String query = "UPDATE coordenador SET data_inicio = ?, data_fim = ?, ativo = ?, servidor_id = ?, curso_id = ? WHERE id = ?";

        try {
            pstm = connection.prepareStatement(query);
            pstm.setDate(1, Date.valueOf(object.getDataInicio()));
            pstm.setDate(2, Date.valueOf(object.getDataFim()));
            pstm.setBoolean(3, object.getAtivo());
            pstm.setInt(4, object.getServidor().getId());
            pstm.setInt(5, object.getCurso().getId());
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

        String query = "DELETE FROM coordenador WHERE id = ?";

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
