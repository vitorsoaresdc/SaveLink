package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class fabricaConexao {
    public static Connection getConexao() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            final String stringConexao = "jdbc:mysql://localhost:8889/savelink";
            final String usuario = "root";
            final String senha = "root";

            return DriverManager.getConnection(stringConexao, usuario, senha);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
