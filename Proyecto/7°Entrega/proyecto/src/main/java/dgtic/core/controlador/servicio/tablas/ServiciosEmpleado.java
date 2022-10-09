package dgtic.core.controlador.servicio.tablas;

import java.util.List;

import dgtic.core.modelo.entidades.empleado.Empleado;

public interface ServiciosEmpleado {
    Empleado cargaEmpleadoPorId(Integer id);

    List<Empleado> cargaEmpleados();

    void guardaEmpleado(Empleado empleado);

    void actualizaEmpleado(Empleado empleado);

    void eliminaEmpleado(Empleado empleado);
}