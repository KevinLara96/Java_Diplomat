package mx.unam.diplomado.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.unam.diplomado.agencia.db.DBConnection;
import mx.unam.diplomado.agencia.db.JDBCUtil;
import mx.unam.diplomado.agendafaces.vo.Agencia;
import mx.unam.diplomado.agendafaces.vo.TipoViaje;
import mx.unam.diplomado.agendafaces.vo.Viaje;

/**
 * Clase que realiza la consulta a la Base de datos.
 */
public class AgenciaDAOJDBC implements IAgenciaDAO {

    private static AgenciaDAOJDBC instance;

    private AgenciaDAOJDBC() {
    }

    public static AgenciaDAOJDBC getInstance() {
        if (instance == null) {
            instance = new AgenciaDAOJDBC();
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

                viaje.setIdViaje(rs.getInt(1));
                viaje.setOrigen(rs.getString(2));
                viaje.setDestino(rs.getString(3));
                viaje.setPrecio(rs.getFloat(4));
                viaje.setFecha(rs.getString(5));
                viaje.setIdTipoViaje(rs.getInt(6));
                viaje.setIdAgencia(rs.getInt(6));

                viaje.setTipoViaje(cargaTipoViaje(viaje.getIdTipoViaje()));
                viaje.setAgencia(cargaAgencia(viaje.getIdTipoViaje()));

                viajes.add(viaje);
            }
        } catch (SQLException sqlx) {

        }

        return viajes;
    }

    public TipoViaje cargaTipoViaje(Integer idTipoViaje) {

        DBConnection db = JDBCUtil.getInstance();
        TipoViaje tipoViaje = new TipoViaje();

        String query = "SELECT * FROM tipoViaje\n" +
                "WHERE idTipoViaje = " + idTipoViaje;

        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(query.toString());
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                tipoViaje.setIdTipoViaje(rs.getInt(1));
                tipoViaje.setTipoViaje(rs.getString(2));

            }
        } catch (SQLException sqlx) {

        }

        return tipoViaje;
    }

    public Agencia cargaAgencia(Integer idAgencia) {

        DBConnection db = JDBCUtil.getInstance();
        Agencia agencia = new Agencia();

        String query = "SELECT * FROM agencia\n" +
                "WHERE idAgencia = " + idAgencia;

        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(query.toString());
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                agencia.setIdAgencia(rs.getInt(1));
                agencia.setNombreAgencia(rs.getString(2));
                agencia.setUbicacion(rs.getString(3));

            }
        } catch (SQLException sqlx) {

        }

        return agencia;
    }
}
