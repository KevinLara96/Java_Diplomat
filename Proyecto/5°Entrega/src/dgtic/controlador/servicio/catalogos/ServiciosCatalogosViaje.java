package dgtic.controlador.servicio.catalogos;

import java.util.List;

import dgtic.modelo.entidades.viaje.TipoTour;
import dgtic.modelo.entidades.viaje.TipoViaje;

public interface ServiciosCatalogosViaje {
    List<TipoViaje> cargaTiposViaje();

    TipoViaje cargaTipoViajePorId(Integer id);

    List<TipoTour> cargaTiposTour();

    TipoTour cargaTipoTourPorId(Integer id);
}
