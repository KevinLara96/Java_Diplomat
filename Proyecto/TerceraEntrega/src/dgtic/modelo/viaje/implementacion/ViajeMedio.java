package dgtic.modelo.viaje.implementacion;

import java.time.LocalDate;

import dgtic.modelo.viaje.Viaje;
import dgtic.modelo.viaje.interfaces.TipoViaje;
import dgtic.modelo.viaje.interfaces.Viajes;

public class ViajeMedio implements Viajes {

    @Override
    public Viaje viaje(String origen, String destino, float precio, int distancia, LocalDate fecha,
            TipoViaje tipoViaje) {
        return new Viaje(origen, destino, precio, distancia, fecha, tipoViaje);
    }

}
