package dgtic.core.controlador.servicio.tablas;

import java.util.List;

import dgtic.core.modelo.DAO.tablas.ViajeDAO;
import dgtic.core.modelo.DAO.tablas.ViajeDAOImpl;
import dgtic.core.modelo.entidades.viaje.Viaje;

public class ServiciosViajeImpl implements ServiciosViaje {
    private static ServiciosViajeImpl instance;

    private ServiciosViajeImpl() {

    }

    public static ServiciosViajeImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosViajeImpl();
        }
        return instance;
    }

    @Override
    public Viaje cargaViajePorId(Integer id) {
        ViajeDAO viajeDAO = ViajeDAOImpl.getInstance();
        return viajeDAO.cargaViajePorId(id);
    }

    @Override
    public List<Viaje> cargaViajes() {
        ViajeDAO viajeDAO = ViajeDAOImpl.getInstance();
        return viajeDAO.cargaViajes();
    }

    @Override
    public void guardaViaje(Viaje viaje) {
        ViajeDAO viajeDAO = ViajeDAOImpl.getInstance();
        viajeDAO.guardaViaje(viaje);

    }

    @Override
    public void actualizaViaje(Viaje viaje) {
        ViajeDAO viajeDAO = ViajeDAOImpl.getInstance();
        viajeDAO.actualizaViaje(viaje);
    }

    @Override
    public void eliminaViaje(Viaje viaje) {
        ViajeDAO viajeDAO = ViajeDAOImpl.getInstance();
        viajeDAO.eliminaViaje(viaje);
    }
}
