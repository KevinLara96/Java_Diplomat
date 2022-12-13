package unam.dgtic.diplomado.controlador.repositorio.cliente;

import unam.dgtic.diplomado.modelo.entidades.cliente.Orden;

public interface RepositorioOrden {

    public Iterable<Orden> obtenerOrdens();

    public Orden obtenerOrden(Integer idOrden);

    public void crearOrden(Orden agenciaNueva) throws Exception;

    public void eliminarOrden();
}
