package br.edu.ifsc.aluno.victor.model.dao;

import java.sql.*;

public class ConnectionFactory {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String banco = "jdbc:mysql://localhost:3306/reserva_ambiente";
    private static final String usuario = "admin";
    private static final String senha = "admin123";

    public static Connection getConnection() {
        StringBuilder connection = new StringBuilder(banco).append("?allowPublicKeyRetrieval=true")
                                                    .append("&useSSL=false")
                                                    .append("&requireSSL=false")
                                                    .append("&USER=").append(usuario).append("&password=").append(senha).append("&serverTimezone=UTC");
        try {
            return DriverManager.getConnection(connection.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement pstm) {
        try {
            pstm.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement pstm, ResultSet rs) {
        try {
            rs.close();
            pstm.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
