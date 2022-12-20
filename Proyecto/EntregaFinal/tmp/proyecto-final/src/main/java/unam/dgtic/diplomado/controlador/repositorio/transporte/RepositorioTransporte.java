package unam.dgtic.diplomado.controlador.repositorio.transporte;

import unam.dgtic.diplomado.modelo.beans.transporte.TransporteBean;

public interface RepositorioTransporte {

    public Iterable<TransporteBean> obtenerTransportes();

    public TransporteBean obtenerTransporte(Integer idTransporte);

    public void guardarTransporte(TransporteBean transporte) throws Exception;

    public void eliminarTransporte(Integer idTransporte);

    public void actualizarTransporte(TransporteBean transporteParam);
}
