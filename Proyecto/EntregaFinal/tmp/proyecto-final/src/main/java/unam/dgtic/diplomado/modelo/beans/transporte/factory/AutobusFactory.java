package unam.dgtic.diplomado.modelo.beans.transporte.factory;

import unam.dgtic.diplomado.modelo.beans.transporte.Autobus;
import unam.dgtic.diplomado.modelo.beans.transporte.Transporte;

public class AutobusFactory extends TransporteFactory {

    @Override
    protected Transporte crearTransporte() {
        return new Autobus();
    }
}
