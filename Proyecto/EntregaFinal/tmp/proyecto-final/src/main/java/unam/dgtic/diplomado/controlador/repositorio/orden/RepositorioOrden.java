package unam.dgtic.diplomado.controlador.repositorio.orden;

import unam.dgtic.diplomado.modelo.entidades.orden.OrdenEntity;

public interface RepositorioOrden {

    public Iterable<OrdenEntity> obtenerOrdenes();

    public OrdenEntity obtenerOrden(Integer idOrden);

    public void guardarOrden(OrdenEntity orden) throws Exception;

    public void actualizarOrden(OrdenEntity ordenParam);
}
