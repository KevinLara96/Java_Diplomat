package dgtic.core.modelo.DAO.tablas;

import java.util.List;

import dgtic.core.modelo.entidades.viaje.Viaje;

public interface ViajeDAO {
    Viaje cargaViajePorId(Integer id);

    // Viaje cargaViajePorIdNQ(Integer id);

    List<Viaje> cargaViajes();

    void guardaViaje(Viaje viaje);

    void actualizaViaje(Viaje viaje);

    void eliminaViaje(Viaje viaje);
}
