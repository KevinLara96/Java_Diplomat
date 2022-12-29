package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAutobusEntity;

public interface RepositorioTipoViajeAutobus {

    public Iterable<TipoViajeAutobusEntity> obtenerTiposViajeAutobus();

    public TipoViajeAutobusEntity obtenerTipoViajeAutobus(Integer idTipoViajeAutobus);

    public boolean guardarTipoViajeAutobus(TipoViajeAutobusEntity tipoViajeAutobus) throws Exception;

    public boolean eliminarTipoViajeAutobus(Integer idTipoViajeAutobus) throws Exception;

    public boolean actualizarTipoViajeAutobus(TipoViajeAutobusEntity tipoViajeAutobusParam) throws Exception;
}
