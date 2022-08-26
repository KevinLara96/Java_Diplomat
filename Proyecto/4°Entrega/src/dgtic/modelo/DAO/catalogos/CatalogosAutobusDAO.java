package dgtic.modelo.DAO.catalogos;

import java.util.*;

import dgtic.modelo.entidades.autobus.*;

public interface CatalogosAutobusDAO {
    List<ClaseBus> cargaClasesBus();

    ClaseBus cargaClasesBusPorId(Integer id);

    List<ClaseTuribus> cargaClasesTuribus();

    ClaseTuribus cargaClaseTuribusPorId(Integer id);
}
