package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.entidades.viaje.TipoViajeAutobus;

public interface RepositorioTipoViajeAutobus {

    public Iterable<TipoViajeAutobus> obtenerTipoViajeAutobuss();

    public TipoViajeAutobus obtenerTipoViajeAutobus(Integer idTipoViajeAutobus);

    public void crearTipoViajeAutobus(TipoViajeAutobus agenciaNueva) throws Exception;

    public void eliminarTipoViajeAutobus();
}
