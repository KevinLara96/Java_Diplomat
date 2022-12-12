package unam.dgtic.diplomado.m1100base.dominio.puesto;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Puesto {

    @Column(name = "puesto")
    private String puesto;

    public Puesto() {
    }

    public Puesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Puesto [puesto=" + puesto + "]";
    }

}
