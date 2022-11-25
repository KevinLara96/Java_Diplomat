package mx.unam.diplomado.agencia.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mx.unam.diplomado.agencia.db.DBConnection;
import mx.unam.diplomado.agencia.db.JDBCUtil;
//import mx.unam.diplomado.agenciafaces.vo.agencia.Agencia;
//import mx.unam.diplomado.agenciafaces.vo.viaje.TipoViaje;
import mx.unam.diplomado.agenciafaces.vo.viaje.Viaje;

/**
 * Clase que realiza la consulta a la Base de Datos.
 */
public class AgenciaDAO implements IAgenciaDAO {

    private static AgenciaDAO instance;

    private AgenciaDAO() {
    }

    public static AgenciaDAO getInstance() {
        if (instance == null) {
            instance = new AgenciaDAO();
        }
        return instance;
    }

    @Override
    public List<Viaje> cargaViajes() {

        DBConnection db = JDBCUtil.getInstance();
        List<Viaje> viajes = null;
        String query = "SELECT * FROM viaje";

        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(query.toString());
                ResultSet rs = ps.executeQuery();) {

            viajes = new ArrayList<>();
            while (rs.next()) {
                Viaje viaje = new Viaje();

                viaje.setIdViaje(rs.getInt("idViaje"));
                viaje.setOrigen(rs.getString("origen"));
                viaje.setDestino(rs.getString("destino"));
                viaje.setPrecio(rs.getFloat("precio"));
                viaje.setFecha(rs.getString("fecha"));
                viaje.setIdTipoViaje(rs.getInt("idTipoViaje"));
                viaje.setIdAgencia(rs.getInt("idAgencia"));

                // viaje.setTipoViaje(cargaTipoViaje(viaje.getIdTipoViaje()));
                // viaje.setAgencia(cargaAgencia(viaje.getIdAgencia()));

                viajes.add(viaje);
            }
        } catch (SQLException e) {
        }

        return viajes;
    }

}
