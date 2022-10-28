package mx.unam.diplomado.service;

import java.util.List;
import java.util.Optional;

import mx.unam.diplomado.modelo.entidades.empleado.Empleado;

public interface EmpleadoService {

    List<Empleado> cargaEmpleados();

    void guardaEmpleado(Empleado empleado);

    Optional<Empleado> cargaEmpleado(Integer idEmpleado);

    void eliminaEmpleado(Integer idEmpleado);

    List<Empleado> getListaEmpleado();

    Empleado cargaPorNombre(String nombre);
}
