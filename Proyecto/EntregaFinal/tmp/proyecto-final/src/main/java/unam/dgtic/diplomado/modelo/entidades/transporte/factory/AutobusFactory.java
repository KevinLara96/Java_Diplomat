package unam.dgtic.diplomado.modelo.entidades.transporte.factory;

import unam.dgtic.diplomado.modelo.entidades.transporte.AutobusEntity;
import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;

public class AutobusFactory extends TransporteFactory {

    @Override
    protected TransporteEntity crearTransporte() {
        return new AutobusEntity();
    }
}
