package unam.dgtic.diplomado.controlador.repositorio.empleado;

import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

public interface RepositorioEmpleado {

    public Iterable<EmpleadoEntity> obtenerEmpleados();

    public EmpleadoEntity obtenerEmpleado(Integer idEmpleado);

    public boolean guardarEmpleado(EmpleadoEntity empleado) throws Exception;

    public boolean eliminarEmpleado(Integer idEmpleado) throws Exception;

    public boolean actualizarEmpleado(EmpleadoEntity empleadoParam) throws Exception;
}
