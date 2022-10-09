package dgtic.core.modelo.DAO.catalogos;

import java.util.List;

import dgtic.core.modelo.entidades.puesto.Puesto;

public interface CatalogosPuestoDAO {
    List<Puesto> cargaPuestos();

    Puesto cargaPuestoPorId(Integer id);
}
