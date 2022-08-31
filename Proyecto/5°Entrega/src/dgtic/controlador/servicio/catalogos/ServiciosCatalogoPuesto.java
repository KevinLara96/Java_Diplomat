package dgtic.controlador.servicio.catalogos;

import java.util.List;

import dgtic.modelo.entidades.puesto.Puesto;

public interface ServiciosCatalogoPuesto {
    List<Puesto> cargaPuestos();

    Puesto cargaPuestoPorId(Integer id);
}
