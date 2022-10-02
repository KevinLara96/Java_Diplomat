package unam.dgtic.core.ejercicio2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Automoviles")
public class Automovil {

    @Id
    @Column(name = "id_automovil", nullable = false)
    private Integer idAutomovil;
    private String marca;
    private String modelo;
    private String color;
    private Integer torque;
    private Integer potencia;

    public Automovil() {
    }

    public Automovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Automovil(Integer idAutomovil, String marca, String modelo, String color, Integer torque, Integer potencia) {
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

    @Override
    public String toString() {
        return "Automovil [idAutomovil=" + idAutomovil + ", marca=" + marca + ", modelo="
                + modelo + ", color= " + color
                + ", potencia=" + potencia + ", torque=" + torque + "]";
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