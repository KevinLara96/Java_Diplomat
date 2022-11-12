package dgtic.core.proyecto6.persistencia.dao.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dgtic.core.proyecto6.persistencia.dao.interfaces.ViajeTipoViajeDAO;
import dgtic.core.proyecto6.persistencia.modelo.viaje.ViajeTipoViaje;

@Repository
public class ViajeTipoViajeRepository implements ViajeTipoViajeDAO {

    private JdbcTemplate jdbc;

    public ViajeTipoViajeRepository(JdbcTemplate jdbc) {
        super();
        this.jdbc = jdbc;
    }

    @Override
    public List<dgtic.core.proyecto6.persistencia.modelo.viaje.ViajeTipoViaje> consulta() {
        String query = "SELECT * FROM viajes_tipoViaje;";
        return jdbc.query(query, this::mapRowToViajesTipos);
    }

    @Override
    public void insertar(dgtic.core.proyecto6.persistencia.modelo.viaje.ViajeTipoViaje nuevo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void cambiar(dgtic.core.proyecto6.persistencia.modelo.viaje.ViajeTipoViaje nuevo) {
        // TODO Auto-generated method stub

    }

    @Override
    public void borrar(dgtic.core.proyecto6.persistencia.modelo.viaje.ViajeTipoViaje nuevo) {
        // TODO Auto-generated method stub

    }

    private ViajeTipoViaje mapRowToViajesTipos(ResultSet rs, int row) throws SQLException {
        ViajeTipoViaje viajeTipo = new ViajeTipoViaje();
        viajeTipo.setIdViaje(rs.getInt(1));
        viajeTipo.setIdTipoViaje(rs.getInt(2));

        return viajeTipo;
    }
}
