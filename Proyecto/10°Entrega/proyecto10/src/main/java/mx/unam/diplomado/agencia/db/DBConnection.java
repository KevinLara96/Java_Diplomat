package mx.unam.diplomado.agencia.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {

    Connection getConnection();

    void closeConnection(Connection conn) throws SQLException;

}
