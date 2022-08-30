package dgtic.controlador.servicio.tablas;

import java.util.List;

import dgtic.modelo.DAO.tablas.EmpleadoDAO;
import dgtic.modelo.DAO.tablas.EmpleadoDAOImpl;
import dgtic.modelo.entidades.empleado.Empleado;

public class ServiciosEmpleadoImpl implements ServiciosEmpleado {

    private static ServiciosEmpleadoImpl instance;

    private ServiciosEmpleadoImpl() {

    }

    public static ServiciosEmpleadoImpl getInstance() {
        if (instance == null) {
            instance = new ServiciosEmpleadoImpl();
        }
        return instance;
    }

    @Override
    public Empleado cargaEmpleadoPorId(Integer id) {
        EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstance();
        return empleadoDAO.cargaEmpleadoPorId(id);
    }

    @Override
    public List<Empleado> cargaEmpleados() {
        EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstance();
        return empleadoDAO.cargaEmpleados();
    }

    @Override
    public void guardaEmpleado(Empleado empleado) {
        EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstance();
        empleadoDAO.guardaEmpleado(empleado);

    }

    @Override
    public void actualizaEmpleado(Empleado empleado) {
        EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstance();
        empleadoDAO.actualizaEmpleado(empleado);
    }

    @Override
    public void eliminaEmpleado(Empleado empleado) {
        EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstance();
        empleadoDAO.eliminaEmpleado(empleado);
    }

}
