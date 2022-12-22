package unam.dgtic.diplomado.modelo.entidades.transporte.factory;

import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;

public abstract class TransporteFactory {

    public TransporteEntity crear() {

        return crearTransporte();
    }

    protected abstract TransporteEntity crearTransporte();
}
