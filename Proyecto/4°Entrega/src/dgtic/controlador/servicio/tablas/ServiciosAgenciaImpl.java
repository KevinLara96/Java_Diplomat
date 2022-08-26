package dgtic.controlador.servicio.tablas;

import dgtic.modelo.DAO.tablas.AgenciaDAO;
import dgtic.modelo.DAO.tablas.AgenciaDAOImpl;
import dgtic.modelo.entidades.agencia.Agencia;

public class ServiciosAgenciaImpl implements ServiciosAgencia {
    public static ServiciosAgenciaImpl instance;

    private ServiciosAgenciaImpl() {

    }

    public static ServiciosAgenciaImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosAgenciaImpl();
        }
        return instance;
    }

    @Override
    public Agencia cargaAgencia() {
        AgenciaDAO agenciaDAO = AgenciaDAOImpl.getInstance();
        return agenciaDAO.cargaAgencia();
    }

    @Override
    public void guardaAgencia(Agencia agencia) {
        AgenciaDAO agenciaDAO = AgenciaDAOImpl.getInstance();
        agenciaDAO.guardaAgencia(agencia);

    }

    @Override
    public void actualizaAgencia(Agencia agencia) {
        AgenciaDAO agenciaDAO = AgenciaDAOImpl.getInstance();
        agenciaDAO.actualizaAgencia(agencia);
    }

    @Override
    public void eliminaAgencia(Agencia agencia) {
        AgenciaDAO agenciaDAO = AgenciaDAOImpl.getInstance();
        agenciaDAO.eliminaAgencia(agencia);
    }
}
