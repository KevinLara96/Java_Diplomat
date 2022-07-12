package dgtic.basedatos.servicio.borrado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Borrado {
    private static String usuario = "root";
    private static String contrasena = "MaPass";
    private static String cadenaConexion = "jdbc:mariadb://localhost/modulo03";

    /*
     * Elimina administrador de la base de datos.
     */
    public static boolean bajaAdministrador(String claveEmpleado) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "DELETE FROM Administrador WHERE" +
                    "claveEmpleado = " + claveEmpleado;
            oStatement.executeUpdate(instruccionSQL);

            instruccionSQL = "";
            instruccionSQL += "DELETE FROM Empleado WHERE" +
                    "claveEmpleado = " + claveEmpleado;
            oStatement.executeUpdate(instruccionSQL);

            oStatement.close();
            oConnection.close();
            status = true;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    /*
     * Elimina conductor de la base de datos.
     */
    public static boolean bajaConductor(String claveEmpleado) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "DELETE FROM Conductor_Viaje " +
                    "WHERE claveConductor = " + claveEmpleado;
            oStatement.executeUpdate(instruccionSQL);

            instruccionSQL = "";
            instruccionSQL += "DELETE FROM Conductor_Autobus " +
                    "WHERE claveConductor = " + claveEmpleado;
            oStatement.executeUpdate(instruccionSQL);

            instruccionSQL = "";
            instruccionSQL += "DELETE FROM Conductor " +
                    "WHERE claveEmpleado = " + claveEmpleado;
            oStatement.executeUpdate(instruccionSQL);

            instruccionSQL = "";
            instruccionSQL += "DELETE FROM Empleado" +
                    "WHERE claveEmpleado = " + claveEmpleado;
            oStatement.executeUpdate(instruccionSQL);

            oStatement.close();
            oConnection.close();
            status = true;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    /*
     * Elimina viaje de la base de datos.
     */
    public static boolean bajaViaje(int idViaje) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "DELETE FROM Conductor_Viaje " +
                    "WHERE idViaje = " + idViaje;
            oStatement.executeUpdate(instruccionSQL);

            instruccionSQL = "";
            instruccionSQL += "DELETE FROM Viaje " +
                    "WHERE idViaje = " + idViaje;
            oStatement.executeUpdate(instruccionSQL);

            oStatement.close();
            oConnection.close();
            status = true;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    /*
     * Elimin viaje de la base de datos.
     */
    public static boolean bajaAutobus(int claveAutobus) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "DELETE FROM Conductor_Autobus " +
                    "WHERE claveAutobus = " + claveAutobus;
            oStatement.executeUpdate(instruccionSQL);

            instruccionSQL = "";
            instruccionSQL += "DELETE FROM Autobus " +
                    "WHERE claveAutobus = " + claveAutobus;
            oStatement.executeUpdate(instruccionSQL);

            oStatement.close();
            oConnection.close();
            status = true;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    /*
     * Elimina la asignación de un autobús a un conductor.
     */
    public static boolean removerAutobusConductor(String claveConductor, int claveAutobus) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "DELETE FROM Conductor_Autobus " +
                    "WHERE claveAutobus = " + claveAutobus;
            oStatement.executeUpdate(instruccionSQL);

            oStatement.close();
            oConnection.close();
            status = true;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    /*
     * Elimina la asignación de un viaje a un conductor.
     */
    public static boolean removerViajeConductor(String claveConductor, int idViaje) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "DELETE FROM Conductor_Autobus " +
                    "WHERE idViaje = " + idViaje;
            oStatement.executeUpdate(instruccionSQL);

            oStatement.close();
            oConnection.close();
            status = true;
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}
