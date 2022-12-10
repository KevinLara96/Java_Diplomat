package unam.dgtic.diplomado.modelo.entidades.transporte.factory;

import unam.dgtic.diplomado.modelo.entidades.transporte.Autobus;
import unam.dgtic.diplomado.modelo.entidades.transporte.Transporte;

public class AutobusFactory extends TransporteFactory {

    @Override
    protected Transporte crearTransporte() {
        return new Autobus();
    }
}
