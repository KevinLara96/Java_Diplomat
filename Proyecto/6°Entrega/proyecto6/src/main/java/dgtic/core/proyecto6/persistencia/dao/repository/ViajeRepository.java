package dgtic.core.proyecto6.persistencia.dao.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dgtic.core.proyecto6.persistencia.dao.interfaces.ViajesDAO;
import dgtic.core.proyecto6.persistencia.modelo.viaje.Viaje;

@Repository
public class ViajeRepository implements ViajesDAO {

    private JdbcTemplate jdbc;

    @Autowired
    public ViajeRepository(JdbcTemplate jdbc) {
        super();
        this.jdbc = jdbc;
    }

    @Override
    public List<Viaje> consultaViajes() {
        String query = "SELECT * FROM viajes\n" +
                "ORDER BY idViaje";

        return jdbc.query(query, this::mapRowToViaje);
    }

    @Override
    public Viaje consultaIdViaje(Integer idViaje) {
        String query = "SELECT * FROM viajes\n" +
                "WHERE idViaje = " + idViaje;

        return jdbc.query(query, this::mapRowToViaje).get(0);
    }

    @Override
    public void insertarViaje(Viaje nuevoViaje) {
        String query = "INSERT INTO viajes VALUES(?,?,?,?,?,?,?)";

        jdbc.update(query, nuevoViaje.getIdViaje(),
                nuevoViaje.getOrigen(),
                nuevoViaje.getDestino(),
                nuevoViaje.getPrecio(),
                nuevoViaje.getFecha(),
                nuevoViaje.getIdAgencia(),
                nuevoViaje.getIdTipoViaje());
    }

    @Override
    public void cambiarViaje(Viaje nuevoViaje) {
        String query = "UPDATE viajes SET \n" +
                "origen = ?,\n" +
                "destino = ?,\n" +
                "precio = ?,\n" +
                "fecha = ?,\n" +
                "idAgencia = ?,\n" +
                "idTipoViaje = ?\n" +
                "WHERE idViaje = ?";

        jdbc.update(query, nuevoViaje.getOrigen(),
                nuevoViaje.getDestino(),
                nuevoViaje.getPrecio(),
                nuevoViaje.getFecha(),
                nuevoViaje.getIdAgencia(),
                nuevoViaje.getIdTipoViaje(),
                nuevoViaje.getIdViaje());
    }

    @Override
    public void borrarViaje(Viaje nuevoViaje) {
        String query = "DELETE FROM viajes WHERE idViaje = ?";

        jdbc.update(query, nuevoViaje.getIdViaje());
    }

    private Viaje mapRowToViaje(ResultSet rs, int row) throws SQLException {
        Viaje viaje = new Viaje();

        viaje.setIdViaje(rs.getInt(1));
        viaje.setOrigen(rs.getString(2));
        viaje.setDestino(rs.getString(3));
        viaje.setPrecio(rs.getFloat(4));
        viaje.setFecha(rs.getString(5));
        viaje.setIdAgencia(rs.getInt(6));
        viaje.setIdTipoViaje(rs.getInt(7));

        return viaje;
    }

    public List<Viaje> joinViajeAgencia(Integer idAgencia) {
        String query = "SELECT * FROM viajes v, agencia a\n" +
                "WHERE v.idAgencia = a.idAgencia AND \n" +
                "a.idAgencia = " + idAgencia;
        return jdbc.query(query, this::mapRowToViaje);
    }

    public List<Viaje> joinViajeTipoViaje(Integer idTipoViaje) {
        String query = "SELECT * FROM viajes v, tipoViaje a\n" +
                "WHERE v.idTipoViaje = a.idTipoViaje AND \n" +
                "a.idTipoViaje = " + idTipoViaje;
        return jdbc.query(query, this::mapRowToViaje);
    }
}
