package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAutobusEntity;

public interface RepositorioTipoViajeAutobus {

    public Iterable<TipoViajeAutobusEntity> obtenerTiposViajeAutobus();

    public TipoViajeAutobusEntity obtenerTipoViajeAutobus(Integer idTipoViajeAutobus);

    public void guardarTipoViajeAutobus(TipoViajeAutobusEntity tipoViajeAutobus) throws Exception;

    public void eliminarTipoViajeAutobus(Integer idTipoViajeAutobus);

    public void actualizarTipoViajeAutobus(TipoViajeAutobusEntity tipoViajeAutobusParam);
}
