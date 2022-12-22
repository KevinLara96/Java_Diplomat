package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAvionEntity;

public interface RepositorioTipoViajeAvion {

    public Iterable<TipoViajeAvionEntity> obtenerTiposViajeAvion();

    public TipoViajeAvionEntity obtenerTipoViajeAvion(Integer idTipoViajeAvion);

    public void guardarTipoViajeAvion(TipoViajeAvionEntity tipoViajeAvion) throws Exception;

    public void eliminarTipoViajeAvion(Integer idTipoViajeAvion);

    public void actualizarTipoViajeAvion(TipoViajeAvionEntity tipoViajeAvionParam);
}
