package dgtic.modelo.viaje.interfaces;

import dgtic.modelo.viaje.Viaje;

public interface Viajes {

    public Viaje viaje(int idViajes, String origen, String destino, float precio, int distancia,
            String fecha, TipoViaje tipoViaje);
}
