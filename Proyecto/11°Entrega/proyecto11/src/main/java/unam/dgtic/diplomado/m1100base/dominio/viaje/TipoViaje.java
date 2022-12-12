package unam.dgtic.diplomado.m1100base.dominio.viaje;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class TipoViaje {

    @Column(name = "tipoViaje")
    private String tipoViaje;

    public TipoViaje() {
    }

    public TipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    @Override
    public String toString() {
        return "TipoViaje [tipoViaje=" + tipoViaje + "]";
    }

}