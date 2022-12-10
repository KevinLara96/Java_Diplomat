package unam.dgtic.diplomado.modelo.entidades.transporte.factory;

import unam.dgtic.diplomado.modelo.entidades.transporte.Transporte;

public abstract class TransporteFactory {

    public Transporte crear() {

        return crearTransporte();
    }

    protected abstract Transporte crearTransporte();
}
