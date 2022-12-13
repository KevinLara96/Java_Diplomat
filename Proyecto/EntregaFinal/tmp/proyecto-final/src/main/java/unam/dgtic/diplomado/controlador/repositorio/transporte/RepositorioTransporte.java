package unam.dgtic.diplomado.controlador.repositorio.transporte;

import unam.dgtic.diplomado.modelo.entidades.transporte.Transporte;

public interface RepositorioTransporte {

    public Iterable<Transporte> obtenerTransportes();

    public Transporte obtenerTransporte(Integer idTransporte);

    public void crearTransporte(Transporte agenciaNueva) throws Exception;

    public void eliminarTransporte();
}
