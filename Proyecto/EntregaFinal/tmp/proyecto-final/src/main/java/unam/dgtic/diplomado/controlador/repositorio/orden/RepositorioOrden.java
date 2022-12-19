package unam.dgtic.diplomado.controlador.repositorio.orden;

import unam.dgtic.diplomado.modelo.entidades.orden.Orden;

public interface RepositorioOrden {

    public Iterable<Orden> obtenerOrdenes();

    public Orden obtenerOrden(Integer idOrden);

    public void guardarOrden(Orden orden) throws Exception;

    public void actualizarOrden(Orden ordenParam);
}
