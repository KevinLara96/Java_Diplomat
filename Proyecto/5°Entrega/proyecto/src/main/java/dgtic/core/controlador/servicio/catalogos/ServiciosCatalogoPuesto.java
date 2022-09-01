package dgtic.core.controlador.servicio.catalogos;

import java.util.List;

import dgtic.core.modelo.entidades.puesto.Puesto;

public interface ServiciosCatalogoPuesto {
    List<Puesto> cargaPuestos();

    Puesto cargaPuestoPorId(Integer id);
}
