package dgtic.basedatos.servicio.escritura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dgtic.modelo.autobus.Autobus;
import dgtic.modelo.empleado.administrador.Administrador;
import dgtic.modelo.empleado.conductor.Conductor;
import dgtic.modelo.viaje.Viaje;

public class Escritura {
    private static String usuario = "root";
    private static String contrasena = "MaPassw";
    private static String cadenaConexion = "jdbc:mariadb://localhost/modulo03";

    /*
     * Registra nuevo administrador en la base de datos.
     */
    public static boolean altaAdministrador(Administrador administrador) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "INSERT INTO Empleado VALUES(" +
                    "'" + administrador.getClaveEmpleado() + "'" + "," +
                    administrador.getPuesto().ID_PUESTO + "," +
                    "'" + administrador.getNombre() + "'" + "," +
                    "'" + administrador.getCorreo() + "'" + "," +
                    "'" + administrador.getContrasena() + "'" + "," +
                    "'" + administrador.getRfc() + "'" + "," +
                    administrador.getSalario() + ");";
            oStatement.executeUpdate(instruccionSQL);

            instruccionSQL = "";
            instruccionSQL += "INSERT INTO Administrador VALUES(" +
                    "'" + administrador.getClaveEmpleado() + "'" + "," +
                    administrador.getClaveAdministrador() + ");";
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
     * Registra nuevo conductor en la base de datos.
     */
    public static boolean altaConductor(Conductor conductor) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "INSERT INTO Empleado VALUES(" +
                    "'" + conductor.getClaveEmpleado() + "'" + "," +
                    conductor.getPuesto().ID_PUESTO + "," +
                    "'" + conductor.getNombre() + "'" + "," +
                    "'" + conductor.getCorreo() + "'" + "," +
                    "'" + conductor.getContrasena() + "'" + "," +
                    "'" + conductor.getRfc() + "'" + "," +
                    conductor.getSalario() + ");";
            oStatement.executeUpdate(instruccionSQL);

            instruccionSQL = "";
            instruccionSQL += "INSERT INTO Conductor VALUES(" +
                    "'" + conductor.getClaveEmpleado() + "'" + "," +
                    conductor.getClaveConductor() + ");";
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
     * Registra un nuevo viaje en la base de datos.
     */
    public static boolean altaViaje(Viaje viaje) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "INSERT INTO Viaje VALUES(" +
                    viaje.getIdViaje() + "," +
                    viaje.getTipoViaje().ID_TIPO_VIAJE + "," +
                    "'" + viaje.getOrigen() + "'" + "," +
                    "'" + viaje.getDestino() + "'" + "," +
                    viaje.getPrecio() + "," +
                    viaje.getDistancia() + "," +
                    "'" + viaje.getFecha() + "'" + ");";
            oStatement.executeUpdate(instruccionSQL);

            oStatement.close();
            oConnection.close();
            status = true;
        } catch (Exception e) {
            status = false;
            System.out.println("Error al registrar nuevo destino.");
            e.printStackTrace();
        }
        return status;
    }

    /*
     * Registra un nuevo autobús en la base de datos.
     */
    public static boolean altaAutobus(Autobus autobus) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "INSERT INTO Autobus VALUES(" +
                    autobus.getClaveAutobus() + "," +
                    "'" + autobus.getModelo() + "'" + "," +
                    "'" + autobus.getMarca() + "'" + "," +
                    autobus.getCapacidad() + "," +
                    autobus.getTipoUso().ID_TIPO_USO + "," +
                    autobus.getClase().ID_CLASE + "," +
                    autobus.getTipoTuribus().ID_TURIBUS + ");";
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
     * Asigna un viaje a un conductor.
     * Debe existir el conductor y el viaje en la base de datos.
     */
    public static boolean asignarViaje(String claveConductor, int idViaje) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "INSERT INTO Conductor_Viaje VALUES(" +
                    "'" + claveConductor + "'," +
                    idViaje + ");";
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
     * Asigna un autobús a un conductor.
     * El conductor y el autobús deben existir en la base de datos.
     */
    public static boolean asignarAutobus(String claveConductor, int idAutobus) {
        boolean status = false;
        String instruccionSQL = "";

        try {
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
            Statement oStatement = oConnection.createStatement();

            instruccionSQL += "INSERT INTO Conductor_Autobus VALUES(" +
                    "'" + claveConductor + "'," +
                    idAutobus + ");";
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
