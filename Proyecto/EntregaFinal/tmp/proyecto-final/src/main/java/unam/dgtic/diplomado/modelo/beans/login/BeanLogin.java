package unam.dgtic.diplomado.modelo.beans.login;

import java.io.IOException;
import java.io.Serializable;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.ejb.LoginEJB;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

@Named
@SessionScoped
public class BeanLogin implements Serializable {

    @EJB
    private LoginEJB servicioEJB;

    private String correo;
    private String contrasena;
    private String estatus;

    public BeanLogin() {

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String login() {
        this.servicioEJB = new LoginEJB();
        try {
            EmpleadoEntity tmp = servicioEJB.login(this.correo, this.contrasena);
            String puesto = tmp.getPuesto().getPuesto();
            if (puesto.equals("SYS") || puesto.equals("ADMINISTRADOR") || puesto.equals("PROGRAMADOR")) {
                return "inicioAdministracion";
            } else {
                throw new IOException("Permisos no suficientes");
            }
        } catch (IOException e) {
            this.estatus = e.getMessage();
            return "loginEmpleados";
        } catch (Exception e) {
            this.estatus = "Correo / Contraseña erróneos : ";
            return "loginEmpleados";
        }
    }
}
