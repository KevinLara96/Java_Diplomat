package unam.dgtic.diplomado.controlador.repositorio.transporte;

import unam.dgtic.diplomado.modelo.beans.transporte.Transporte;

public interface RepositorioTransporte {

    public Iterable<Transporte> obtenerTransportes();

    public Transporte obtenerTransporte(Integer idTransporte);

    public void guardarTransporte(Transporte transporte) throws Exception;

    public void eliminarTransporte(Integer idTransporte);

    public void actualizarTransporte(Transporte transporteParam);
}
