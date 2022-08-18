package dgtic.basedatos.servicio.consulta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {
    private static String usuario = "root";
    private static String contrasena = "MaPassw";
    private static String cadenaConexion = "jdbc:mariadb://localhost/modulo03";

    /*
     * Devuelve todos los administradores en la base de datos.
     */
    public static String consultaAdministradores() {
        String instruccionSQL;
        String resultado = "";
        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);

            instruccionSQL = "SELECT * FROM Empleado " +
                    "WHERE idPuesto = 2;";

            Statement oStatement = oConnection.createStatement();
            ResultSet oResultSet = oStatement.executeQuery(instruccionSQL);

            // Recorrer el ResultSet y se muestran los empleados que son administradores.
            while (oResultSet.next()) { // Mientras existan registros, lee uno a la vez
                resultado += oResultSet.getString(1);
                resultado += " / " + oResultSet.getInt(2);
                resultado += " / " + oResultSet.getString(3);
                resultado += " / " + oResultSet.getString(4);
                resultado += " / " + oResultSet.getString(5);
                resultado += " / " + oResultSet.getString(6);
                resultado += " / " + oResultSet.getFloat(7) + "\n";
            }
            oResultSet.close();
            oStatement.close();
            oConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    /*
     * Devuelve todos los conductores en la base de datos.
     */
    public static String consultaConductores() {
        String instruccionSQL;
        String resultado = "";
        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);

            instruccionSQL = "SELECT * FROM Empleado " +
                    "WHERE idPuesto = 3;";

            Statement oStatement = oConnection.createStatement();
            ResultSet oResultSet = oStatement.executeQuery(instruccionSQL);

            // Recorrer el ResultSet y se muestran los empleados que son administradores.
            while (oResultSet.next()) { // Mientras existan registros, lee uno a la vez
                resultado += oResultSet.getString(1);
                resultado += " / " + oResultSet.getInt(2);
                resultado += " / " + oResultSet.getString(3);
                resultado += " / " + oResultSet.getString(4);
                resultado += " / " + oResultSet.getString(5);
                resultado += " / " + oResultSet.getString(6);
                resultado += " / " + oResultSet.getFloat(7) + "\n";
            }
            oResultSet.close();
            oStatement.close();
            oConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    /*
     * Devuelve los datos del viaje del conductor que haya iniciado sesión.
     */
    public static String consultaConductores(String claveEmpleado) {
        String instruccionSQL;
        String resultado = "";
        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);

            instruccionSQL = "SELECT Viaje.origen, Viaje.destino " +
                    "FROM Viaje " +
                    "INNER JOIN Conductor_Viaje ON Viaje.idViaje = Conductor_Viaje.idViaje " +
                    "INNER JOIN Conductor ON Conductor_Viaje.claveEmpleado = Conductor.claveEmpleado " +
                    "WHERE Conductor.claveConductor = '" + claveEmpleado + "'";
            Statement oStatement = oConnection.createStatement();
            ResultSet oResultSet = oStatement.executeQuery(instruccionSQL);

            // Recorrer el ResultSet y se muestran los empleados que son administradores.
            while (oResultSet.next()) { // Mientras existan registros, lee uno a la vez
                resultado += oResultSet.getString(1);
                resultado += " / " + oResultSet.getString(3) + "\n";
            }
            oResultSet.close();
            oStatement.close();
            oConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    /*
     * Devuelve todos los viajes en la base de datos.
     */
    public static String consultaViajes() {
        String instruccionSQL;
        String resultado = "";
        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);

            instruccionSQL = "SELECT * FROM Viaje ";

            Statement oStatement = oConnection.createStatement();
            ResultSet oResultSet = oStatement.executeQuery(instruccionSQL);

            // Recorrer el ResultSet y se muestran los empleados que son administradores.
            while (oResultSet.next()) { // Mientras existan registros, lee uno a la vez
                resultado += oResultSet.getInt(1);
                resultado += " / " + oResultSet.getInt(2);
                resultado += " / " + oResultSet.getString(3);
                resultado += " / " + oResultSet.getString(4);
                resultado += " / " + oResultSet.getFloat(5);
                resultado += " / " + oResultSet.getInt(6);
                resultado += " / " + oResultSet.getString(7) + "\n";
            }
            oResultSet.close();
            oStatement.close();
            oConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    /*
     * Devuelve todos los autobuses en la base de datos.
     */
    public static String consultaAutobuses() {
        String instruccionSQL;
        String resultado = "";
        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);

            instruccionSQL = "SELECT * FROM Autobus ";

            Statement oStatement = oConnection.createStatement();
            ResultSet oResultSet = oStatement.executeQuery(instruccionSQL);

            // Recorrer el ResultSet y se muestran los empleados que son administradores.
            while (oResultSet.next()) { // Mientras existan registros, lee uno a la vez
                resultado += oResultSet.getInt(1);
                resultado += " / " + oResultSet.getString(2);
                resultado += " / " + oResultSet.getString(3);
                resultado += " / " + oResultSet.getInt(4);
                resultado += " / " + oResultSet.getInt(5);
                resultado += " / " + oResultSet.getInt(6);
                resultado += " / " + oResultSet.getInt(7) + "\n";
            }
            oResultSet.close();
            oStatement.close();
            oConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
