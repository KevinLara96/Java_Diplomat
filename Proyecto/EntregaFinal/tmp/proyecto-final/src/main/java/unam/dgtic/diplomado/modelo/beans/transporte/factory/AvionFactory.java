package unam.dgtic.diplomado.modelo.beans.transporte.factory;

import unam.dgtic.diplomado.modelo.beans.transporte.Avion;
import unam.dgtic.diplomado.modelo.beans.transporte.Transporte;

public class AvionFactory extends TransporteFactory {

    @Override
    protected Transporte crearTransporte() {
        return new Avion();
    }

}
