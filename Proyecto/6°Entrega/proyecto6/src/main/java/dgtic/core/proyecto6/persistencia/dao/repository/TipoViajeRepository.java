package dgtic.core.proyecto6.persistencia.dao.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dgtic.core.proyecto6.persistencia.dao.interfaces.TipoViajeDAO;
import dgtic.core.proyecto6.persistencia.modelo.viaje.TipoViaje;

@Repository
public class TipoViajeRepository implements TipoViajeDAO {

    private JdbcTemplate jdbc;

    @Autowired
    public TipoViajeRepository(JdbcTemplate jdbc) {
        super();
        this.jdbc = jdbc;
    }

    @Override
    public List<TipoViaje> consultaTiposViaje() {
        String query = "SELECT * FROM tipoViaje\n" +
                "ORDER BY idTipoViaje";

        return jdbc.query(query, this::mapRowToTipoViaje);
    }

    @Override
    public TipoViaje consultaIdTipoViaje(Integer idTipoViaje) {
        String query = "SELECT * FROM tipoViaje\n" +
                "WHERE idTipoViaje=" + idTipoViaje + ";";

        return jdbc.query(query, this::mapRowToTipoViaje).get(0);
    }

    @Override
    public void insertarTipoViaje(TipoViaje nuevoTipoViaje) {
        String query = "INSERT INTO tipoViaje VALUES (?,?)";

        jdbc.update(query, nuevoTipoViaje.getIdTipoViaje(), nuevoTipoViaje.getTipoViaje());
    }

    @Override
    public void cambiarTipoViaje(TipoViaje nuevoTipoViaje) {
        String query = "UPDATE tipoViaje SET\n" +
                "tipoViaje=?\n" +
                "WHERE idTipoViaje=? ;";
        jdbc.update(query, nuevoTipoViaje.getTipoViaje(), nuevoTipoViaje.getIdTipoViaje());
    }

    @Override
    public void borrarTipoViaje(TipoViaje tipoViaje) {
        String query = "DELETE FROM tipoViaje WHERE idTipoViaje=?";

        jdbc.update(query, tipoViaje.getIdTipoViaje());
    }

    private TipoViaje mapRowToTipoViaje(ResultSet rs, int row) throws SQLException {
        TipoViaje tipoViaje = new TipoViaje();
        tipoViaje.setIdTipoViaje(rs.getInt(1));
        tipoViaje.setTipoViaje(rs.getString(2));

        return tipoViaje;
    }
}
