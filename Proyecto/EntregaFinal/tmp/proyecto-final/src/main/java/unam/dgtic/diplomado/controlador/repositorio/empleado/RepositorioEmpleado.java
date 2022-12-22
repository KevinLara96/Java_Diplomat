package unam.dgtic.diplomado.controlador.repositorio.empleado;

import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

public interface RepositorioEmpleado {

    public Iterable<EmpleadoEntity> obtenerEmpleados();

    public EmpleadoEntity obtenerEmpleado(Integer idEmpleado);

    public void guardarEmpleado(EmpleadoEntity empleado) throws Exception;

    public void eliminarEmpleado(Integer idEmpleado);

    public void actualizarEmpleado(EmpleadoEntity empleadoParam);
}
