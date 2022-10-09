package dgtic.core.controlador.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import dgtic.core.baseDatos.intf.BaseDeDatosDAO;
import dgtic.core.modelo.entidades.autobus.Autobus;
import dgtic.core.modelo.entidades.empleado.Empleado;
import dgtic.core.modelo.entidades.viaje.Viaje;

@Component
@ComponentScan(basePackages = "dgtic.core")
public class ServicioDAO {
    @Autowired
    @Qualifier("BaseDeDatosDAO")
    private BaseDeDatosDAO servicioDAO;

    /* Constructor. */
    @Autowired
    public ServicioDAO(BaseDeDatosDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    /* Getter y Setter. */
    public void setServicioDAO(BaseDeDatosDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public BaseDeDatosDAO getServicioDAO() {
        return servicioDAO;
    }

    /* Métodos CSV. */
    public String archivoCSVAutobuses() {
        StringBuilder str = new StringBuilder("");
        for (Autobus autobus : servicioDAO.getAutobuses()) {
            str.append(autobus.getModelo()).append(" / ");
            str.append(autobus.getMarca()).append(" / ");
            str.append(autobus.getCapacidad()).append("\n");
        }
        return str.toString();
    }

    /* Métodos CSV. */
    public String archivoCSVEmpleados() {
        StringBuilder str = new StringBuilder("");
        for (Empleado empleado : servicioDAO.getEmpleados()) {
            str.append(empleado.getNombre()).append(" / ");
            str.append(empleado.getCorreo()).append(" / ");
            str.append(empleado.getRfc()).append("\n");
        }
        return str.toString();
    }

    /* Métodos CSV. */
    public String archivoCSVDestinos() {
        StringBuilder str = new StringBuilder("");
        for (Viaje viaje : servicioDAO.getDestinos()) {
            str.append(viaje.getOrigen()).append(" / ");
            str.append(viaje.getDestino()).append(" / ");
            str.append(viaje.getFecha()).append("\n");
        }
        return str.toString();
    }
}