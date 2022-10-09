package dgtic.core.modelo.DAO.catalogos;

import java.util.*;

import dgtic.core.modelo.entidades.autobus.*;

public interface CatalogosAutobusDAO {
    List<ClaseBus> cargaClasesBus();

    ClaseBus cargaClasesBusPorId(Integer id);

    List<ClaseTuribus> cargaClasesTuribus();

    ClaseTuribus cargaClasesTuribusPorId(Integer id);
}
