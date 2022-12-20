package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.beans.viaje.TipoViajeAutobus;

public interface RepositorioTipoViajeAutobus {

    public Iterable<TipoViajeAutobus> obtenerTiposViajeAutobus();

    public TipoViajeAutobus obtenerTipoViajeAutobus(Integer idTipoViajeAutobus);

    public void guardarTipoViajeAutobus(TipoViajeAutobus tipoViajeAutobus) throws Exception;

    public void eliminarTipoViajeAutobus(Integer idTipoViajeAutobus);

    public void actualizarTipoViajeAutobus(TipoViajeAutobus tipoViajeAutobusParam);
}
