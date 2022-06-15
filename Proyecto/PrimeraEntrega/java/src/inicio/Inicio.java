package inicio;

import modelo.camion.Camion;
import modelo.empleado.*;
import modelo.viaje.Viaje;
import vista.Aplicacion;
import controlador.Agencia;

public class Inicio {
    public static void main(String[] args) {
        Agencia agencia = new Agencia(
                new Empleado(),
                new Camion(),
                new Viaje());

        new Aplicacion(agencia);
    }
}
