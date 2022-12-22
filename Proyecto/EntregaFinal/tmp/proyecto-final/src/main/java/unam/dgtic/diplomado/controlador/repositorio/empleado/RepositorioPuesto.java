package unam.dgtic.diplomado.controlador.repositorio.empleado;

import unam.dgtic.diplomado.modelo.entidades.empleado.PuestoEntity;

public interface RepositorioPuesto {

    public Iterable<PuestoEntity> obtenerPuestos();

    public PuestoEntity obtenerPuesto(Integer idPuesto);

    public void guardarPuesto(PuestoEntity puesto) throws Exception;

    public void eliminarPuesto(Integer idPuesto);

    public void actualizarPuesto(PuestoEntity puestoParam);
}
