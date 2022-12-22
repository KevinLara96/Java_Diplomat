package unam.dgtic.diplomado.controlador.repositorio.transporte;

import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;

public interface RepositorioTransporte {

    public Iterable<TransporteEntity> obtenerTransportes();

    public TransporteEntity obtenerTransporte(Integer idTransporte);

    public void guardarTransporte(TransporteEntity transporte) throws Exception;

    public void eliminarTransporte(Integer idTransporte);

    public void actualizarTransporte(TransporteEntity transporteParam);
}
