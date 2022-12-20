package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.beans.viaje.TipoViajeAvionBean;

public interface RepositorioTipoViajeAvion {

    public Iterable<TipoViajeAvionBean> obtenerTiposViajeAvion();

    public TipoViajeAvionBean obtenerTipoViajeAvion(Integer idTipoViajeAvion);

    public void guardarTipoViajeAvion(TipoViajeAvionBean tipoViajeAvion) throws Exception;

    public void eliminarTipoViajeAvion(Integer idTipoViajeAvion);

    public void actualizarTipoViajeAvion(TipoViajeAvionBean tipoViajeAvionParam);
}
