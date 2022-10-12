package unam.dgtic.core.proyecto7.modelo.puesto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import unam.dgtic.core.proyecto7.modelo.empleado.Empleado;

@Entity
@Table(name = "puesto")
public class Puesto {

    @Id
    private Integer idPuesto;

    @OneToOne(mappedBy = "puesto", fetch = FetchType.LAZY)
    private Empleado empleado;

    private String puesto;

    public Puesto() {

    }

    public Puesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public Puesto(Integer idPuesto, String puesto) {
        this.idPuesto = idPuesto;
        this.puesto = puesto;
    }

    public Integer getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
