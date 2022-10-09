package dgtic.core.controlador.servicio.catalogos;

import java.util.List;

import dgtic.core.modelo.DAO.catalogos.CatalogosPuestoDAO;
import dgtic.core.modelo.DAO.catalogos.CatalogosPuestoDAOImpl;
import dgtic.core.modelo.entidades.puesto.Puesto;

public class ServiciosCatalogoPuestoImpl implements ServiciosCatalogoPuesto {
    private static ServiciosCatalogoPuestoImpl instance;

    private ServiciosCatalogoPuestoImpl() {

    }

    public static ServiciosCatalogoPuestoImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosCatalogoPuestoImpl();
        }
        return instance;
    }

    @Override
    public List<Puesto> cargaPuestos() {
        CatalogosPuestoDAO catalogosDAO = CatalogosPuestoDAOImpl.getInstance();
        return catalogosDAO.cargaPuestos();
    }

    @Override
    public Puesto cargaPuestoPorId(Integer id) {
        CatalogosPuestoDAO catalogosDAO = CatalogosPuestoDAOImpl.getInstance();
        return catalogosDAO.cargaPuestoPorId(id);
    }

}
