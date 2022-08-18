package dgtic.modelo.viaje.interfaces;

//import java.sql.Date;
import java.time.LocalDate;

import dgtic.modelo.viaje.Viaje;

public interface Viajes {
    public Viaje viaje();

    public Viaje viaje(String origen, String destino, float precio, int distancia, LocalDate fecha);
}
