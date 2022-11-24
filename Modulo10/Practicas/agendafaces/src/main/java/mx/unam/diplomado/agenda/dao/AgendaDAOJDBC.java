package mx.unam.diplomado.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.unam.diplomado.agenda.db.DBConnection;
import mx.unam.diplomado.agenda.db.JDBCUtil;
import mx.unam.diplomado.agendafaces.vo.Contacto;
import mx.unam.diplomado.agendafaces.vo.TipoContacto;

/**
 * Clase que realiza la conexión a la Base de datos.
 */
public class AgendaDAOJDBC implements IAgendaDAO {

    private static AgendaDAOJDBC instance;

    private AgendaDAOJDBC() {
    }

    public static AgendaDAOJDBC getInstance() {
        if (instance == null) {
            instance = new AgendaDAOJDBC();
        }
        return instance;
    }

    @Override
    public List<Contacto> cargaContactos() {

        DBConnection db = JDBCUtil.getInstance();
        List<Contacto> contactos = null;

        String query = "SELECT * FROM t_contacto";
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(query.toString());
                ResultSet rs = ps.executeQuery();) {
            contactos = new ArrayList<>();
            while (rs.next()) {
                Contacto contacto = new Contacto();
                contacto.setIdContacto(rs.getInt("id_contacto"));
                contacto.setNombre(rs.getString("vc_nombre"));
                contacto.setApellidos(rs.getString("vc_apellidos"));
                contacto.setEdad(rs.getInt("vi_edad"));
                contacto.setDireccion(rs.getString("vc_direccion"));
                contacto.setIdTipoContacto(rs.getInt("id_tipo_contacto"));
                // contacto.setTipoContacto(cargaTipoContactos().get(contacto.getIdTipoContacto()));
                contacto.setTipoContacto(cargaTipoContactos(contacto.getIdTipoContacto()));
                contacto.setEstatus(rs.getString("vc_estatus"));

                contactos.add(contacto);
            }
        } catch (SQLException sqlx) {

        }

        return contactos;
    }

    public TipoContacto cargaTipoContactos(Integer idTipoContacto) {

        DBConnection db = JDBCUtil.getInstance();
        TipoContacto tipoContacto = new TipoContacto();

        String query = "SELECT * FROM c_tipo_contacto\n" +
                "WHERE id_tipo_contacto = " + idTipoContacto;
        try (Connection conn = db.getConnection();
                PreparedStatement ps = conn.prepareStatement(query.toString());
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                tipoContacto.setIdTipoContacto(rs.getInt("id_tipo_contacto"));
                tipoContacto.setNombre(rs.getString("vc_nombre"));
                tipoContacto.setEstatus(rs.getString("vc_estatus"));

            }
        } catch (SQLException sqlx) {

        }

        return tipoContacto;
    }
}
