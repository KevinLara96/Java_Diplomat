package unam.dgtic.diplomado.controlador.repositorio.empleado;

import unam.dgtic.diplomado.modelo.beans.empleado.Puesto;

public interface RepositorioPuesto {

    public Iterable<Puesto> obtenerPuestos();

    public Puesto obtenerPuesto(Integer idPuesto);

    public void guardarPuesto(Puesto puesto) throws Exception;

    public void eliminarPuesto(Integer idPuesto);

    public void actualizarPuesto(Puesto puestoParam);
}
