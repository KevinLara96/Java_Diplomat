package dgtic.core.modelo.DAO.catalogos;

import java.util.List;

import dgtic.core.modelo.entidades.viaje.TipoTour;
import dgtic.core.modelo.entidades.viaje.TipoViaje;

public interface CatalogosViajeDAO {
    List<TipoViaje> cargaTiposViaje();

    TipoViaje cargaTipoViajePorId(Integer id);

    List<TipoTour> cargaTiposTour();

    TipoTour cargaTipoTourPorId(Integer id);
}
