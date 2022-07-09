package dgtic.modelo.viaje.implementacion;

import dgtic.modelo.viaje.interfaces.AbstractFactory;
import dgtic.modelo.viaje.interfaces.Viajes;

public class FactoryViajeMedio implements AbstractFactory {

    @Override
    public Viajes crearViaje() {
        return new ViajeMedio();
    }

}
