package unam.dgtic.core.ejercicio4;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQuery(name = "Automovil.buscarRapidos", query = "Select a from Automovil a where torque > 500")

@NamedNativeQuery(name = "Automovil.buscarPorColor", query = "select * from Automoviles where color = 'Azul'", resultClass = Automovil.class)

@NamedQuery(name = "Automovil.buscarTodosConDueno", query = "select distinct a from Automovil a JOIN FETCH a.duenos")

@Entity
@Table(name = "Automoviles")
public class Automovil {

    @Id
    @Column(name = "id_Automovil")
    private Integer idAutomovil;
    private String marca;
    private String modelo;
    private String color;
    private Integer torque;
    private Integer potencia;

    @OneToMany(mappedBy = "automovil", fetch = FetchType.EAGER)
    private List<Dueno> duenos = new ArrayList<>();

    public Automovil() {
    }

    public Automovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Automovil(Integer idAutomovil, String marca, String modelo, String color, Integer torque,
            Integer potencia) {
        this.idAutomovil = idAutomovil;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.torque = torque;
        this.potencia = potencia;
    }

    public Integer getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getTorque() {
        return torque;
    }

    public void setTorque(Integer torque) {
        this.torque = torque;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public List<Dueno> getDuenos() {
        return duenos;
    }

    public void setDuenos(List<Dueno> duenos) {
        this.duenos = duenos;
    }

    @Override
    public String toString() {
        return "Automovil [idAutomovil=" + idAutomovil + ", marca=" + marca + ", modelo=" + modelo + ", color="
                + color
                + ", torque=" + torque + ", potencia=" + potencia + ", \nduenos=" + duenos + "]\n";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idAutomovil == null) ? 0 : idAutomovil.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Automovil other = (Automovil) obj;
        if (idAutomovil == null) {
            if (other.idAutomovil != null)
                return false;
        } else if (!idAutomovil.equals(other.idAutomovil))
            return false;
        return true;
    }

}