package dgtic.core.proyecto6.persistencia.dao.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dgtic.core.proyecto6.persistencia.dao.interfaces.AgenciaDAO;
import dgtic.core.proyecto6.persistencia.dao.interfaces.ViajesDAO;
import dgtic.core.proyecto6.persistencia.modelo.agencia.Agencia;

@Repository
public class AgenciaRepository implements AgenciaDAO {

    private JdbcTemplate jdbc;

    // @Autowired
    // private ViajesDAO viajesDAO;

    @Autowired
    public AgenciaRepository(JdbcTemplate jdbc) {
        super();
        this.jdbc = jdbc;
    }

    @Override
    public List<Agencia> consultaAgencias() {
        String query = "SELECT * FROM agencia\n" +
                "ORDER BY idAgencia";

        return jdbc.query(query, this::mapRowToAgencia);
    }

    @Override
    public Agencia consultaIdAgencia(Integer idAgencia) {
        String query = "SELECT * FROM agencia\n" +
                "WHERE idAgencia = " + idAgencia;

        return jdbc.query(query, this::mapRowToAgencia).get(0);
    }

    @Override
    public void insertarAgencia(Agencia agencia) {
        String query = "INSERT INTO agencia VALUES(?,?,?)";

        jdbc.update(query, agencia.getIdAgencia(),
                agencia.getNombreAgencia(), agencia.getUbicacion());
    }

    @Override
    public void cambiarAgencia(Agencia agencia) {
        String query = "UPDATE agencia SET\n" +
                "nombreAgencia = ?\n," +
                "ubicacion = ?\n" +
                "WHERE idAgencia = ?";
        jdbc.update(query, agencia.getNombreAgencia(),
                agencia.getUbicacion(), agencia.getIdAgencia());
    }

    @Override
    public void borrarAgencia(Agencia agencia) {
        String query = "DELETE FROM agencia WHERE idAgencia = ?";

        jdbc.update(query, agencia.getIdAgencia());
    }

    private Agencia mapRowToAgencia(ResultSet rs, int row) throws SQLException {
        Agencia agencia = new Agencia();
        agencia.setIdAgencia(rs.getInt(1));
        agencia.setNombreAgencia(rs.getString(2));
        agencia.setUbicacion(rs.getString(3));
        agencia.setDestinos(null);

        return agencia;
    }
}
