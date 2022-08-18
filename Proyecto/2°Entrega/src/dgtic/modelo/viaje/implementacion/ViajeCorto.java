package dgtic.modelo.viaje.implementacion;

//import java.sql.Date;
import java.time.LocalDate;

import dgtic.modelo.viaje.Viaje;
import dgtic.modelo.viaje.interfaces.Viajes;

public class ViajeCorto implements Viajes {

    @Override
    public Viaje viaje() {
        return new Viaje();
    }

    @Override
    public Viaje viaje(String origen, String destino, float precio, int distancia, LocalDate fecha) {
        return new Viaje(origen, destino, precio, distancia, fecha);
    }

}
