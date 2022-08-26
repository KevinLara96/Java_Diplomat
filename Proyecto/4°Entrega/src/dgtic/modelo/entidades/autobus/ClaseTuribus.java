package dgtic.modelo.entidades.autobus;

import javax.persistence.*;

@Entity
@Table(name = "claseTuribus")
public class ClaseTuribus {
    private Integer idClaseTuribus;
    private String claseTuribus;

    @Id
    @Column(name = "idClaseTuribus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdClaseTuribus() {
        return idClaseTuribus;
    }

    public void setIdClaseTuribus(Integer idClaseTuribus) {
        this.idClaseTuribus = idClaseTuribus;
    }

    @Column(name = "claseTuribus")
    public String getClaseTuribus() {
        return claseTuribus;
    }

    public void setClaseTuribus(String claseTuribus) {
        this.claseTuribus = claseTuribus;
    }
}