package dgtic.core.modelo.DAO.tablas;

import java.util.List;

import dgtic.core.modelo.entidades.empleado.Empleado;

public interface EmpleadoDAO {
    Empleado cargaEmpleadoPorId(Integer id);

    // Empleado cargaEmpleadoPorIdNQ(Integer id);

    List<Empleado> cargaEmpleados();

    void guardaEmpleado(Empleado empleado);

    void actualizaEmpleado(Empleado empleado);

    void eliminaEmpleado(Empleado empleado);
}
