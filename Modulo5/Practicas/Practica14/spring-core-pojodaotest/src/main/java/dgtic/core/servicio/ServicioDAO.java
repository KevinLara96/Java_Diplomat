package dgtic.core.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import dgtic.core.repositorio.intf.BaseDeDatosDAO;
import java.util.stream.Collectors;

@Component
@ComponentScan(basePackages = "dgtic.core")
public class ServicioDAO {
    private BaseDeDatosDAO servicioDAO;

    @Autowired
    public void setServicioDAO(
            @Qualifier("baseDeDatosDAOExtra") BaseDeDatosDAO servicioDAO) {
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