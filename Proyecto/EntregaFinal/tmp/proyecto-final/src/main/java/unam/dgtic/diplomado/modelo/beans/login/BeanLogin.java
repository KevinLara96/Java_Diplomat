package unam.dgtic.diplomado.modelo.beans.login;

import java.io.Serializable;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.ejb.LoginEJB;

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
            servicioEJB.login(this.correo, this.contrasena);
            return "inicioAdministracion";
        } catch (Exception e) {
            this.estatus = "Correo / Contraseña erróneos : ";
            return "loginEmpleados";
        }
    }
}
