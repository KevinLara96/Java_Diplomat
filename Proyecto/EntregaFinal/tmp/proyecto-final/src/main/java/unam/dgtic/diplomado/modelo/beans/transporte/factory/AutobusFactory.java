package unam.dgtic.diplomado.modelo.beans.transporte.factory;

import unam.dgtic.diplomado.modelo.beans.transporte.AutobusBean;
import unam.dgtic.diplomado.modelo.beans.transporte.TransporteBean;

public class AutobusFactory extends TransporteFactory {

    @Override
    protected TransporteBean crearTransporte() {
        return new AutobusBean();
    }
}
