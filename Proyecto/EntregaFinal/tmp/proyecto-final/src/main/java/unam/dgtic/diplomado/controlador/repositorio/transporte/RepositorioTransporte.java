package unam.dgtic.diplomado.controlador.repositorio.transporte;

import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;

public interface RepositorioTransporte {

    public Iterable<TransporteEntity> obtenerTransportes();

    public TransporteEntity obtenerTransporte(Integer idTransporte);

    public boolean guardarTransporte(TransporteEntity transporte) throws Exception;

    public boolean eliminarTransporte(Integer idTransporte) throws Exception;

    public boolean actualizarTransporte(TransporteEntity transporteParam) throws Exception;
}
