package unam.dgtic.diplomado.controlador.repositorio.orden;

import unam.dgtic.diplomado.modelo.entidades.orden.OrdenEntity;

public interface RepositorioOrden {

    public Iterable<OrdenEntity> obtenerOrdenes();

    public OrdenEntity obtenerOrden(Integer idOrden);

    public boolean guardarOrden(OrdenEntity orden) throws Exception;

    public boolean actualizarOrden(OrdenEntity ordenParam) throws Exception;
}
