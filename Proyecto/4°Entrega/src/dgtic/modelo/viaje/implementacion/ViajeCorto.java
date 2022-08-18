package dgtic.modelo.viaje.implementacion;

import dgtic.modelo.viaje.Viaje;
import dgtic.modelo.viaje.interfaces.TipoViaje;
import dgtic.modelo.viaje.interfaces.Viajes;

public class ViajeCorto implements Viajes {

    @Override
    public Viaje viaje(int idViaje, String origen, String destino, float precio, int distancia, String fecha,
            TipoViaje tipoViaje) {
        return new Viaje(idViaje, origen, destino, precio, distancia, fecha, tipoViaje);
    }

}
