package unam.dgtic.diplomado.controlador.repositorio.empleado;

import unam.dgtic.diplomado.modelo.entidades.empleado.Empleado;

public interface RepositorioEmpleado {

    public Iterable<Empleado> obtenerEmpleados();

    public Empleado obtenerEmpleado(Integer idEmpleado);

    public void guardarEmpleado(Empleado empleado) throws Exception;

    public void eliminarEmpleado(Integer idEmpleado);

    public void actualizarEmpleado(Empleado empleadoParam);
}
