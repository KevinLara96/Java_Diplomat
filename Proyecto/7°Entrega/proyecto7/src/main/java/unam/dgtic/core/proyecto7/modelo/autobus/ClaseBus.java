package unam.dgtic.core.proyecto7.modelo.autobus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "claseBus")
public class ClaseBus {

    @Id
    private Integer idClaseAutobus;

    @OneToOne(mappedBy = "claseAutobus")
    private Autobus autobus;

    private String claseAutobus;

    public Integer getIdClaseAutobus() {
        return idClaseAutobus;
    }

    public void setIdClaseAutobus(Integer idClaseAutobus) {
        this.idClaseAutobus = idClaseAutobus;
    }

    public String getClaseAutobus() {
        return claseAutobus;
    }

    public void setClaseAutobus(String claseAutobus) {
        this.claseAutobus = claseAutobus;
    }
}
