package dgtic.modelo.DAO.catalogos;

import java.util.List;

import dgtic.modelo.entidades.puesto.Puesto;

public interface CatalogosPuestoDAO {
    List<Puesto> cargaPuestos();

    Puesto cargaPuestoPorId(Integer id);
}
