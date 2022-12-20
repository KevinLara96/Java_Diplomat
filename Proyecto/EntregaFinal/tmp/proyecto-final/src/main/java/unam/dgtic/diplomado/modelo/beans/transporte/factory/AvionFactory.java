package unam.dgtic.diplomado.modelo.beans.transporte.factory;

import unam.dgtic.diplomado.modelo.beans.transporte.AvionBean;
import unam.dgtic.diplomado.modelo.beans.transporte.TransporteBean;

public class AvionFactory extends TransporteFactory {

    @Override
    protected TransporteBean crearTransporte() {
        return new AvionBean();
    }

}
