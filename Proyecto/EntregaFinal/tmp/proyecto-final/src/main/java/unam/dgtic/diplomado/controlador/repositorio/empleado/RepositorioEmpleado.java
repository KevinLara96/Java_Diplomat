package unam.dgtic.diplomado.controlador.repositorio.empleado;

import unam.dgtic.diplomado.modelo.beans.empleado.EmpleadoBean;

public interface RepositorioEmpleado {

    public Iterable<EmpleadoBean> obtenerEmpleados();

    public EmpleadoBean obtenerEmpleado(Integer idEmpleado);

    public void guardarEmpleado(EmpleadoBean empleado) throws Exception;

    public void eliminarEmpleado(Integer idEmpleado);

    public void actualizarEmpleado(EmpleadoBean empleadoParam);
}
