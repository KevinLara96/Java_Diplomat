package mx.unam.diplomado.service.servicioEmpleado;

import java.util.List;

import mx.unam.diplomado.modelo.entidades.empleado.Empleado;

public interface EmpleadoService {

    List<Empleado> cargaEmpleados();

    void guardaEmpleado(Empleado empleado);

    Empleado cargaEmpleado(Integer id);

    void eliminaEmpleado(Integer id);
}
