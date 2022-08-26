package dgtic.modelo.DAO.catalogos;

import java.util.List;

import dgtic.modelo.entidades.viaje.TipoTour;
import dgtic.modelo.entidades.viaje.TipoViaje;

public interface CatalogosViajeDAO {
    List<TipoViaje> cargaTipoViaje();

    TipoViaje cargaTipoViajePorId(Integer id);

    List<TipoTour> cargaTipoTour();

    TipoTour cargaTipoTourPorId(Integer id);
}
