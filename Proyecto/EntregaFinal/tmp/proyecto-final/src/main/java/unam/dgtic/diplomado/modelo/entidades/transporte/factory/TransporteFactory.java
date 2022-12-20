package unam.dgtic.diplomado.modelo.entidades.transporte.factory;

import unam.dgtic.diplomado.modelo.beans.transporte.TransporteBean;

public abstract class TransporteFactory {

    public TransporteBean crear() {

        return crearTransporte();
    }

    protected abstract TransporteBean crearTransporte();
}
