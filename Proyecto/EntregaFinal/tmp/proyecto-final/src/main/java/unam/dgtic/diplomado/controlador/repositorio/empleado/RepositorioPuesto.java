package unam.dgtic.diplomado.controlador.repositorio.empleado;

import unam.dgtic.diplomado.modelo.entidades.empleado.Puesto;

public interface RepositorioPuesto {

    public Iterable<Puesto> obtenerPuestos();

    public Puesto obtenerPuesto(Integer idPuesto);

    public void crearPuesto(Puesto agenciaNueva) throws Exception;

    public void eliminarPuesto();
}
