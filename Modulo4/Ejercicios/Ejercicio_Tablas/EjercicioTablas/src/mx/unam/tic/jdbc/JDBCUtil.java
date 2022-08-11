package mx.unam.tic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection obtenConexion() {
        Connection conn = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/test";
            String user = "root";
            String pwd = "MaPassw";
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR: No fue posible cargar la clase.");
            System.exit(1);
        }

        return conn;
    }
}
