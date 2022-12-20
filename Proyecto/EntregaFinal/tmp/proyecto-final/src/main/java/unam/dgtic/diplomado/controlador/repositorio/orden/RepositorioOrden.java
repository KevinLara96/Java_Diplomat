package unam.dgtic.diplomado.controlador.repositorio.orden;

import unam.dgtic.diplomado.modelo.beans.orden.OrdenBean;

public interface RepositorioOrden {

    public Iterable<OrdenBean> obtenerOrdenes();

    public OrdenBean obtenerOrden(Integer idOrden);

    public void guardarOrden(OrdenBean orden) throws Exception;

    public void actualizarOrden(OrdenBean ordenParam);
}
