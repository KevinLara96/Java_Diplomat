package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAvion;

public interface RepositorioTipoViajeAvion {

    public Iterable<TipoViajeAvion> obtenerTipoViajeAvions();

    public TipoViajeAvion obtenerTipoViajeAvion(Integer idTipoViajeAvion);

    public void crearTipoViajeAvion(TipoViajeAvion agenciaNueva) throws Exception;

    public void eliminarTipoViajeAvion();
}
