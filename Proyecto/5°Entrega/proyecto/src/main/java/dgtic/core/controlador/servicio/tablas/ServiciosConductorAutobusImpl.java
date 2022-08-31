package dgtic.controlador.servicio.tablas;

import java.util.List;

import dgtic.modelo.DAO.tablas.ConductorAutobusDAO;
import dgtic.modelo.DAO.tablas.ConductorAutobusDAOImpl;
import dgtic.modelo.entidades.agencia.asignaciones.ConductorAutobus;

public class ServiciosConductorAutobusImpl implements ServiciosConductorAutobus {
    private static ServiciosConductorAutobusImpl instance;

    private ServiciosConductorAutobusImpl() {

    }

    public static ServiciosConductorAutobusImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosConductorAutobusImpl();
        }
        return instance;
    }

    @Override
    public ConductorAutobus cargaConductorAutobusPorId(Integer id) {
        ConductorAutobusDAO conductorAutobusDAO = ConductorAutobusDAOImpl.getInstance();
        return conductorAutobusDAO.cargaConductorAutobusPorId(id);
    }

    @Override
    public List<ConductorAutobus> cargaConductorAutobuses() {
        ConductorAutobusDAO conductorAutobusDAO = ConductorAutobusDAOImpl.getInstance();
        return conductorAutobusDAO.cargaAutobusesAsignados();
    }

    @Override
    public void guardaConductorAutobus(ConductorAutobus conductorAutobus) {
        ConductorAutobusDAO conductorAutobusDAO = ConductorAutobusDAOImpl.getInstance();
        conductorAutobusDAO.guardaConductorAutobus(conductorAutobus);

    }

    @Override
    public void actualizaConductorAutobus(ConductorAutobus conductorAutobus) {
        ConductorAutobusDAO conductorAutobusDAO = ConductorAutobusDAOImpl.getInstance();
        conductorAutobusDAO.actualizaConductorAutobus(conductorAutobus);
    }

    @Override
    public void eliminaConductorAutobus(ConductorAutobus conductorAutobus) {
        ConductorAutobusDAO conductorAutobusDAO = ConductorAutobusDAOImpl.getInstance();
        conductorAutobusDAO.eliminaConductorAutobus(conductorAutobus);
    }
}
