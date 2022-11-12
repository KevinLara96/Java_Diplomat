package dgtic.core.proyecto6.persistencia.dao.interfaces;

import java.util.List;

import dgtic.core.proyecto6.persistencia.modelo.viaje.TipoViaje;

public interface TipoViajeDAO {

    public List<TipoViaje> consultaTiposViaje();

    public TipoViaje consultaIdTipoViaje(Integer idTipoViaje);

    public void insertarTipoViaje(TipoViaje nuevoTipoViaje);

    public void cambiarTipoViaje(TipoViaje nuevoTipoViaje);

    public void borrarTipoViaje(TipoViaje nuevoTipoViaje);
}
