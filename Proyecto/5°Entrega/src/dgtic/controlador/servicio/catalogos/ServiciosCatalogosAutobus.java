package dgtic.controlador.servicio.catalogos;

import java.util.List;

import dgtic.modelo.entidades.autobus.ClaseBus;
import dgtic.modelo.entidades.autobus.ClaseTuribus;

public interface ServiciosCatalogosAutobus {
    List<ClaseBus> cargaClasesBus();

    ClaseBus cargaClasesBusPorId(Integer id);

    List<ClaseTuribus> cargaClasesTuribus();

    ClaseTuribus cargaClaseTuribusPorId(Integer id);
}
