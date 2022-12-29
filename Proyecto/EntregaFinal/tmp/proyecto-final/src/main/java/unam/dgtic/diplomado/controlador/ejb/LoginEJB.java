package unam.dgtic.diplomado.controlador.ejb;

import jakarta.ejb.Stateless;
import unam.dgtic.diplomado.controlador.servicio.empleado.ServicioEmpleado;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

@Stateless
public class LoginEJB {

    private ServicioEmpleado servicioEmpleado;

    public EmpleadoEntity login(String correo, String contrasena) throws Exception {
        try {
            this.servicioEmpleado = new ServicioEmpleado();
            return servicioEmpleado.login(correo, contrasena);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
