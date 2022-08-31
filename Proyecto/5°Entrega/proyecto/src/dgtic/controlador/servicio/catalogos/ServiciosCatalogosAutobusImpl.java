package dgtic.controlador.servicio.catalogos;

import java.util.List;

import dgtic.modelo.DAO.catalogos.CatalogosAutobusDAO;
import dgtic.modelo.DAO.catalogos.CatalogosAutobusDAOImpl;
import dgtic.modelo.entidades.autobus.ClaseBus;
import dgtic.modelo.entidades.autobus.ClaseTuribus;

public class ServiciosCatalogosAutobusImpl implements ServiciosCatalogosAutobus {

    private static ServiciosCatalogosAutobusImpl instance;

    private ServiciosCatalogosAutobusImpl() {

    }

    public static ServiciosCatalogosAutobusImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosCatalogosAutobusImpl();
        }
        return instance;
    }

    @Override
    public List<ClaseBus> cargaClasesBus() {
        CatalogosAutobusDAO catalogosDAO = CatalogosAutobusDAOImpl.getInstance();
        return catalogosDAO.cargaClasesBus();
    }

    @Override
    public ClaseBus cargaClasesBusPorId(Integer id) {
        CatalogosAutobusDAO catalogosDAO = CatalogosAutobusDAOImpl.getInstance();
        return catalogosDAO.cargaClasesBusPorId(id);
    }

    @Override
    public List<ClaseTuribus> cargaClasesTuribus() {
        CatalogosAutobusDAO catalogosDAO = CatalogosAutobusDAOImpl.getInstance();
        return catalogosDAO.cargaClasesTuribus();
    }

    @Override
    public ClaseTuribus cargaClaseTuribusPorId(Integer id) {
        CatalogosAutobusDAO catalogosDAO = CatalogosAutobusDAOImpl.getInstance();
        return catalogosDAO.cargaClasesTuribusPorId(id);
    }
}
