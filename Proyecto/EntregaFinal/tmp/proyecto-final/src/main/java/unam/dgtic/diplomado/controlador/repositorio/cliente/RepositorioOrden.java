package unam.dgtic.diplomado.controlador.repositorio.cliente;

import unam.dgtic.diplomado.modelo.entidades.cliente.Orden;

public interface RepositorioOrden {

    public Iterable<Orden> obtenerOrdenes();

    public Orden obtenerOrden(Integer idOrden);

    public void guardarOrden(Orden orden) throws Exception;

    public void eliminarOrden(Integer idOrden);

    public void actualizarOrden(Orden ordenParam);
}
