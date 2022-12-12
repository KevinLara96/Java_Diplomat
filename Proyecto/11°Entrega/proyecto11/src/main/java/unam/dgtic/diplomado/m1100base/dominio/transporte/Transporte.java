package unam.dgtic.diplomado.m1100base.dominio.transporte;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;

@Entity
@Table(name = "transporte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoTransporte")
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransporte")
    private Integer idTransporte;
    private String marca;
    private String modelo;
    private Integer capacidadUsuarios;
    private Integer capacidadCombustible;

    @Temporal(TemporalType.DATE)
    private Date fechaAdquisicion;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    public Transporte() {

    }

    public Transporte(Integer idTransporte, String marca, String modelo, Integer capacidadUsuarios,
            Integer capacidadCombustible, Date fechaAdquisicion) {
        this.idTransporte = idTransporte;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadUsuarios = capacidadUsuarios;
        this.capacidadCombustible = capacidadCombustible;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
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

    public Integer getCapacidadUsuarios() {
        return capacidadUsuarios;
    }

    public void setCapacidadUsuarios(Integer capacidadUsuarios) {
        this.capacidadUsuarios = capacidadUsuarios;
    }

    public Integer getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(Integer capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTransporte == null) ? 0 : idTransporte.hashCode());
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
        Transporte other = (Transporte) obj;
        if (idTransporte == null) {
            if (other.idTransporte != null)
                return false;
        } else if (!idTransporte.equals(other.idTransporte))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idTransporte=" + idTransporte + ", marca=" + marca + ", modelo=" + modelo
                + ", capacidadUsuarios=" + capacidadUsuarios + ", capacidadCombustible=" + capacidadCombustible
                + ", fechaAdquisicion=" + fechaAdquisicion;
    }

}
