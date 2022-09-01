package dgtic.core.controlador.servicio.tablas;

import java.util.List;

import dgtic.core.modelo.DAO.tablas.AutobusDAO;
import dgtic.core.modelo.DAO.tablas.AutobusDAOImpl;
import dgtic.core.modelo.entidades.autobus.Autobus;

public class ServiciosAutobusImpl implements ServiciosAutobus {
    private static ServiciosAutobusImpl instance;

    private ServiciosAutobusImpl() {

    }

    public static ServiciosAutobusImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosAutobusImpl();
        }
        return instance;
    }

    @Override
    public Autobus cargaAutobusPorId(Integer id) {
        AutobusDAO autobusDAO = AutobusDAOImpl.getInstance();
        return autobusDAO.cargaAutobusPorId(id);
    }

    @Override
    public List<Autobus> cargaAutobuses() {
        AutobusDAO autobusDAO = AutobusDAOImpl.getInstance();
        return autobusDAO.cargaAutobuses();
    }

    @Override
    public void guardaAutobus(Autobus autobus) {
        AutobusDAO autobusDAO = AutobusDAOImpl.getInstance();
        autobusDAO.guardaAutobus(autobus);

    }

    @Override
    public void actualizaAutobus(Autobus autobus) {
        AutobusDAO autobusDAO = AutobusDAOImpl.getInstance();
        autobusDAO.actualizaAutobus(autobus);
    }

    @Override
    public void eliminaAutobus(Autobus autobus) {
        AutobusDAO autobusDAO = AutobusDAOImpl.getInstance();
        autobusDAO.eliminaAutobus(autobus);
    }

}
