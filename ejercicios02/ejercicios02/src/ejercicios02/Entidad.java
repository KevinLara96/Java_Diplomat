package ejercicios02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Entidad {
    private int clave;
    private String entidad;
    private long poblacion;
    String cadenaConexion = "jdbc:mariadb://localhost/modulo03";
    String usuario = "root";
    String pwd = "MaPassw";

    public Entidad() {

    }

    public Entidad(int clave, String entidad, long poblacion) {
        this.clave = clave;
        this.entidad = entidad;
        this.poblacion = poblacion;
    }

    public boolean alta() {
        // INSERT INTO Entidad VALUES (clave, entidad, poblacion).
        boolean altaRealizada = false;
        String instruccionSQL;

        try {
            // Conexión a la Base.
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, pwd);
            Statement oStatement = oConnection.createStatement();

            /* Insert into Entidad. */
            instruccionSQL = "INSERT INTO entidad (clave, entidad, poblacion) VALUES (";
            instruccionSQL += getClave() + ",'" + this.getEntidad() + "'," + this.getPoblacion() + " )";

            oStatement.executeUpdate(instruccionSQL);

            // Cerrar objetos para terminar la operación
            oStatement.close();
            oConnection.close();
            altaRealizada = true;
        } catch (SQLException e) {
            e.printStackTrace();
            altaRealizada = false;
        }

        return altaRealizada;
    }

    public boolean baja(int claveBorrar) {
        // DELETE FROM Entidad
        boolean bajaRealizada = false;
        String instruccionSQL;

        try {
            // Conexi�n a la Base.
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, pwd);
            Statement oStatement = oConnection.createStatement();

            /* Delete from Entidad. */
            instruccionSQL = "DELETE FROM entidad WHERE clave = ";
            instruccionSQL += claveBorrar;

            oStatement.executeUpdate(instruccionSQL);

            // Cerrar objetos para terminar la operaci�n
            oStatement.close();
            oConnection.close();
            bajaRealizada = true;
        } catch (SQLException e) {
            e.printStackTrace();
            bajaRealizada = false;
        }

        return bajaRealizada;
    }

    public boolean cambio(int clave, String entidad) {
        // UPDATE table SET
        boolean bajaRealizada = false;
        String instruccionSQL;

        try {
            // Conexi�n a la Base.
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, pwd);
            Statement oStatement = oConnection.createStatement();

            /* Delete from Entidad. */
            instruccionSQL = "UPDATE entidad SET entidad = '";
            instruccionSQL += entidad + "' ";
            instruccionSQL += "WHERE clave = " + clave;

            oStatement.executeUpdate(instruccionSQL);

            // Cerrar objetos para terminar la operaci�n
            oStatement.close();
            oConnection.close();
            bajaRealizada = true;
        } catch (SQLException e) {
            e.printStackTrace();
            bajaRealizada = false;
        }

        return bajaRealizada;
    }

    public String select(int clave) {

        String instruccionSQL;
        String resultado = "";
        try {
            // C�digo para conectarme a la base de datos
            Connection oConnection = DriverManager.getConnection(cadenaConexion, usuario, pwd);

            // C�digo para "armar" el query (comando SQL a ejecutar)
            instruccionSQL = "SELECT * FROM entidad WHERE clave = " + clave;

            // C�digo para ejecutar el query
            Statement oStatement = oConnection.createStatement();
            ResultSet oResultSet = oStatement.executeQuery(instruccionSQL); // Aqu� se regresa la "tabla"

            // Recorrer el ResultSet y vamos a desplegar los pa�ses

            while (oResultSet.next()) { // Mientras existan registros, lee uno a la vez
                resultado += oResultSet.getInt("clave");
                resultado += " / " + oResultSet.getString("entidad");
                resultado += " / " + oResultSet.getInt("poblacion") + "\n";
            }
            // Cerrar objetos para terminar la operaci�n
            oResultSet.close();
            oStatement.close();
            oConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } // Fin del catch

        return resultado;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }
}
