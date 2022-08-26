package dgtic.controlador.servicio.catalogos;

import java.util.List;

import dgtic.modelo.DAO.catalogos.CatalogosViajeDAO;
import dgtic.modelo.DAO.catalogos.CatalogosViajeDAOImpl;
import dgtic.modelo.entidades.viaje.TipoTour;
import dgtic.modelo.entidades.viaje.TipoViaje;

public class ServiciosCatalogosViajeImpl implements ServiciosCatalogosViaje {
    private static ServiciosCatalogosViajeImpl instance;

    private ServiciosCatalogosViajeImpl() {

    }

    public static ServiciosCatalogosViajeImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosCatalogosViajeImpl();
        }
        return instance;
    }

    @Override
    public List<TipoViaje> cargaTiposViaje() {
        CatalogosViajeDAO catalogosDAO = CatalogosViajeDAOImpl.getInstance();
        return catalogosDAO.cargaTiposViaje();
    }

    @Override
    public TipoViaje cargaTipoViajePorId(Integer id) {
        CatalogosViajeDAO catalogosDAO = CatalogosViajeDAOImpl.getInstance();
        return catalogosDAO.cargaTipoViajePorId(id);
    }

    @Override
    public List<TipoTour> cargaTiposTour() {
        CatalogosViajeDAO catalogosDAO = CatalogosViajeDAOImpl.getInstance();
        return catalogosDAO.cargaTiposTour();
    }

    @Override
    public TipoTour cargaTipoTourPorId(Integer id) {
        CatalogosViajeDAO catalogosDAO = CatalogosViajeDAOImpl.getInstance();
        return catalogosDAO.cargaTipoTourPorId(id);
    }
}
