package dgtic.core.controlador.servicio.catalogos;

import java.util.List;

import dgtic.core.modelo.entidades.autobus.ClaseBus;
import dgtic.core.modelo.entidades.autobus.ClaseTuribus;

public interface ServiciosCatalogosAutobus {
    List<ClaseBus> cargaClasesBus();

    ClaseBus cargaClasesBusPorId(Integer id);

    List<ClaseTuribus> cargaClasesTuribus();

    ClaseTuribus cargaClaseTuribusPorId(Integer id);
}
