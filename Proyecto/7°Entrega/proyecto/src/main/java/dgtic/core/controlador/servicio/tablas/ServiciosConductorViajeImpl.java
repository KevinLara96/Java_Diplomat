package dgtic.core.controlador.servicio.tablas;

import java.util.List;

import dgtic.core.modelo.DAO.tablas.ConductorViajeDAO;
import dgtic.core.modelo.DAO.tablas.ConductorViajeDAOImpl;
import dgtic.core.modelo.entidades.agencia.asignaciones.ConductorViaje;

public class ServiciosConductorViajeImpl implements ServiciosConductorViaje {

    private static ServiciosConductorViajeImpl instance;

    private ServiciosConductorViajeImpl() {

    }

    public static ServiciosConductorViajeImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosConductorViajeImpl();
        }
        return instance;
    }

    @Override
    public ConductorViaje cargaConductorViajePorId(Integer id) {
        ConductorViajeDAO conductorViajeDAO = ConductorViajeDAOImpl.getInstance();
        return conductorViajeDAO.cargaConductorViajePorId(id);
    }

    @Override
    public List<ConductorViaje> cargaConductorViajes() {
        ConductorViajeDAO conductorViajeDAO = ConductorViajeDAOImpl.getInstance();
        return conductorViajeDAO.cargaConductorViajes();
    }

    @Override
    public void guardaConductorViaje(ConductorViaje conductorViaje) {
        ConductorViajeDAO conductorViajeDAO = ConductorViajeDAOImpl.getInstance();
        conductorViajeDAO.guardaConductorViaje(conductorViaje);

    }

    @Override
    public void actualizaConductorViaje(ConductorViaje conductorViaje) {
        ConductorViajeDAO conductorViajeDAO = ConductorViajeDAOImpl.getInstance();
        conductorViajeDAO.actualizaConductorViaje(conductorViaje);
    }

    @Override
    public void eliminaConductorViaje(ConductorViaje conductorViaje) {
        ConductorViajeDAO conductorViajeDAO = ConductorViajeDAOImpl.getInstance();
        conductorViajeDAO.eliminaConductorViaje(conductorViaje);
    }
}
