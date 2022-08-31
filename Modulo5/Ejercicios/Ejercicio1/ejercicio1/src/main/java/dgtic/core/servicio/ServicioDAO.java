package dgtic.core.servicio;

import org.springframework.beans.factory.annotation.*;

import dgtic.core.repositorio.intf.BaseDeDatosDAO;

public class ServicioDAO {
    @Autowired
    @Qualifier("baseDeDatosDAOExtra")
    private BaseDeDatosDAO servicioDAO;

    @Autowired
    public ServicioDAO(BaseDeDatosDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public void setServicioDAO(BaseDeDatosDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public BaseDeDatosDAO getServicioDAO() {
        return servicioDAO;
    }

    public String archivoCSV(String carrera) {
        return servicioDAO.getEstudiantes(carrera).stream()
                .map(alm -> alm.getMatricula() + ";" +
                        (alm.getMaterias().stream()
                                .map(mat -> (mat.getNombre() + ";" + mat.getCreditos()))
                                .collect(Collectors.joining(";")))
                        + ";" + alm.getNombre())
                .collect(Collectors.joining("\n"));
    }
}
