package unam.dgtic.diplomado.controlador.repositorio.viaje;

import unam.dgtic.diplomado.modelo.beans.viaje.TipoViajeAutobusBean;

public interface RepositorioTipoViajeAutobus {

    public Iterable<TipoViajeAutobusBean> obtenerTiposViajeAutobus();

    public TipoViajeAutobusBean obtenerTipoViajeAutobus(Integer idTipoViajeAutobus);

    public void guardarTipoViajeAutobus(TipoViajeAutobusBean tipoViajeAutobus) throws Exception;

    public void eliminarTipoViajeAutobus(Integer idTipoViajeAutobus);

    public void actualizarTipoViajeAutobus(TipoViajeAutobusBean tipoViajeAutobusParam);
}
