package mx.unam.diplomado.modelo.entidades.autobus;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "claseTuribus")
public class ClaseTuribus {

    @Id
    private Integer idClaseTuribus;

    @OneToOne(mappedBy = "claseTuribus", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Autobus autobus;

    private String claseTuribus;

    public Integer getIdClaseTuribus() {
        return idClaseTuribus;
    }

    public void setIdClaseTuribus(Integer idClaseTuribus) {
        this.idClaseTuribus = idClaseTuribus;
    }

    public String getClaseTuribus() {
        return claseTuribus;
    }

    public void setClaseTuribus(String claseTuribus) {
        this.claseTuribus = claseTuribus;
    }
}