package unam.dgtic.diplomado.modelo.entidades.transporte.factory;

import unam.dgtic.diplomado.modelo.entidades.transporte.AvionEntity;
import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;

public class AvionFactory extends TransporteFactory {

    @Override
    protected TransporteEntity crearTransporte() {
        return new AvionEntity();
    }

}
