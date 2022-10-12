package unam.dgtic.core.proyecto7.modelo.autobus;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "claseBus")
public class ClaseBus {

    @Id
    private Integer idClaseBus;

    @OneToOne(mappedBy = "claseAutobus", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Autobus autobus;

    private String claseAutobus;

    public Integer getIdClaseBus() {
        return idClaseBus;
    }

    public void setIdClaseBus(Integer idClaseBus) {
        this.idClaseBus = idClaseBus;
    }

    public String getClaseBus() {
        return claseAutobus;
    }

    public void setClaseBus(String claseAutobus) {
        this.claseAutobus = claseAutobus;
    }
}
