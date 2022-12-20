package unam.dgtic.diplomado.modelo.beans.transporte.factory;

import unam.dgtic.diplomado.modelo.beans.transporte.Transporte;

public abstract class TransporteFactory {

    public Transporte crear() {

        return crearTransporte();
    }

    protected abstract Transporte crearTransporte();
}
