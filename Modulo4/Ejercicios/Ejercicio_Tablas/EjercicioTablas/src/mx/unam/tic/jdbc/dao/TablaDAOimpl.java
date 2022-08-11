package mx.unam.tic.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mx.unam.tic.jdbc.JDBCUtil;
import mx.unam.tic.jdbc.entidades.Tabla1;
import mx.unam.tic.jdbc.entidades.Tabla2;

public class TablaDAOimpl implements TablaDAO {

    @Override
    public Tabla1 buscarRow(Integer id) {
        Tabla1 tabla = null;

        List<Tabla2> tablas = null;
        String query = "SELECT t1.id as idt1, t1.dato1, t2.id as idt2, t2.dato2 " +
                "FROM tabla_1 as t1, tabla_2 as t2 " +
                "WHERE t1.id = t2.id_tabla1 AND t1.id=?";

        try (Connection con = JDBCUtil.obtenConexion(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                tablas = new ArrayList<>();
                Integer cont = 0;

                while (rs.next()) {
                    if (cont == 0) {
                        tabla = new Tabla1();
                        tabla.setId(rs.getInt("idt1"));
                        tabla.setDato1(rs.getString("dato1"));
                    }
                    Tabla2 tabla2 = new Tabla2();
                    tabla2.setId(rs.getInt("idt2"));
                    tabla2.setDato2(rs.getString("dato2"));
                    tablas.add(tabla2);
                    cont++;
                }
                if (tabla != null)
                    tabla.setTablas2(tablas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tabla;
    }

}
