package unam.dgtic.diplomado;

import unam.dgtic.diplomado.controlador.servicio.empleado.ServicioEmpleado;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

public class Pruebas {

    public static void main(String[] args) {

        ServicioEmpleado servicioEmpleado = new ServicioEmpleado();

        String correo = "kevin@avk.com";
        String contrasena = "a";

        EmpleadoEntity hola = servicioEmpleado.login(correo, contrasena);
        if (hola == null) {
            System.out.println("No hay empleado");
        } else {
            System.out.println(hola);
        }
    }
}
