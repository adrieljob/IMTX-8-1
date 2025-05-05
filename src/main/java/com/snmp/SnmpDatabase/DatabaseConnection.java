package com.snmp.SnmpDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de conexão com o PostgreSQL
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres"; // Usuário do PostgreSQL
    private static final String SENHA = "Admin"; // Senha do PostgreSQL

    @org.jetbrains.annotations.Nullable
    public static Connection connect() throws SQLException {
        try {
            // Carregar o driver JDBC do PostgreSQL
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver JDBC do PostgreSQL não encontrado!");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados!");
            System.err.println("Código SQLState: " + e.getSQLState());
            System.err.println("Código de erro: " + e.getErrorCode());
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        // Usando try-with-resources para garantir que a conexão seja fechada
        try (Connection conn = connect()) {
            if (conn != null) {
                System.out.println("Conexão bem-sucedida!");
            } else {
                System.out.println("Falha na conexão.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao tentar conectar ao banco de dados.");
        }
    }
}


