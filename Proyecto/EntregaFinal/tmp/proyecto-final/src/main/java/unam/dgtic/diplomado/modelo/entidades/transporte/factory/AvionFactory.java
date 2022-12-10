package unam.dgtic.diplomado.modelo.entidades.transporte.factory;

import unam.dgtic.diplomado.modelo.entidades.transporte.Avion;
import unam.dgtic.diplomado.modelo.entidades.transporte.Transporte;

public class AvionFactory extends TransporteFactory {

    @Override
    protected Transporte crearTransporte() {
        return new Avion();
    }

}
