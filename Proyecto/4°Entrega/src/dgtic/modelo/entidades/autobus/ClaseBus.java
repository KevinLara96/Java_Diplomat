package dgtic.modelo.entidades.autobus;

import javax.persistence.*;

@Entity
@Table(name = "claseBus")
public class ClaseBus {
    private Integer idClaseAutobus;
    private String claseAutobus;

    @Id
    @Column(name = "idClaseBus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdClaseAutobus() {
        return idClaseAutobus;
    }

    public void setIdClaseAutobus(Integer idClaseAutobus) {
        this.idClaseAutobus = idClaseAutobus;
    }

    @Column(name = "claseBus")
    public String getClaseAutobus() {
        return claseAutobus;
    }

    public void setClaseAutobus(String claseAutobus) {
        this.claseAutobus = claseAutobus;
    }
}