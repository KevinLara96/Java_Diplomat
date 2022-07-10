package dgtic.modelo.viaje.implementacion;

import java.time.LocalDate;

import dgtic.modelo.viaje.Viaje;
import dgtic.modelo.viaje.interfaces.Viajes;

public class ViajeLargo implements Viajes {

    @Override
    public Viaje viaje(String origen, String destino, float precio, int distancia, LocalDate fecha) {
        return new Viaje(origen, destino, precio, distancia, fecha);
    }

}
