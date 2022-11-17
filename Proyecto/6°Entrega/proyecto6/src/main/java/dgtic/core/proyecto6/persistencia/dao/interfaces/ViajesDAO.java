package dgtic.core.proyecto6.persistencia.dao.interfaces;

import java.util.List;

import dgtic.core.proyecto6.persistencia.modelo.viaje.Viaje;

public interface ViajesDAO {

    public List<Viaje> consultaViajes();

    public Viaje consultaIdViaje(Integer idViaje);

    public void insertarViaje(Viaje nuevoViaje);

    public void cambiarViaje(Viaje nuevoViaje);

    public void borrarViaje(Viaje nuevoViaje);
}
