package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAvion;

public interface RepositorioTipoViajeAvion {

    public Iterable<TipoViajeAvion> obtenerTiposViajeAvion();

    public TipoViajeAvion obtenerTipoViajeAvion(Integer idTipoViajeAvion);

    public void guardarTipoViajeAvion(TipoViajeAvion tipoViajeAvion) throws Exception;

    public void eliminarTipoViajeAvion(Integer idTipoViajeAvion);

    public void actualizarTipoViajeAvion(TipoViajeAvion tipoViajeAvionParam);
}
