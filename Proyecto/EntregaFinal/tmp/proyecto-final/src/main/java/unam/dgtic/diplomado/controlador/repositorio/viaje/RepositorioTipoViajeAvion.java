package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAvionEntity;

public interface RepositorioTipoViajeAvion {

    public Iterable<TipoViajeAvionEntity> obtenerTiposViajeAvion();

    public TipoViajeAvionEntity obtenerTipoViajeAvion(Integer idTipoViajeAvion);

    public boolean guardarTipoViajeAvion(TipoViajeAvionEntity tipoViajeAvion) throws Exception;

    public boolean eliminarTipoViajeAvion(Integer idTipoViajeAvion) throws Exception;

    public boolean actualizarTipoViajeAvion(TipoViajeAvionEntity tipoViajeAvionParam) throws Exception;
}
