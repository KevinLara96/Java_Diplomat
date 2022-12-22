package unam.dgtic.diplomado.modelo.entidades.transporte;

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
import unam.dgtic.diplomado.modelo.entidades.agencia.AgenciaEntity;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "transporte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoTransporte")
public class TransporteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransporte")
    private Integer idTransporte;
    private String marca;
    private String modelo;
    private Integer capacidadCombustible;
    private Date fechaAdquisicion;
    private Integer asientosBasicos;
    private Integer asientosPrimeraClase;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private AgenciaEntity agencia;

    public TransporteEntity() {

    }

    public TransporteEntity(Integer idTransporte, String marca, String modelo, Integer capacidadCombustible,
            Date fechaAdquisicion, Integer asientosBasicos, Integer asientosPrimeraClase) {
        this.idTransporte = idTransporte;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadCombustible = capacidadCombustible;
        this.fechaAdquisicion = fechaAdquisicion;
        this.asientosBasicos = asientosBasicos;
        this.asientosPrimeraClase = asientosPrimeraClase;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) throws Exception {
        if (idTransporte == null || idTransporte <= 0) {
            throw new ExcepcionAtributos("ERROR. Id de transporte inválido.");
        } else {
            this.idTransporte = idTransporte;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws Exception {
        if (marca == null || marca.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Marca de transporte inválida.");
        } else {
            this.marca = marca;
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws Exception {
        if (modelo == null || modelo.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Modelo de transporte inválida.");
        } else {
            this.modelo = modelo;
        }
    }

    public Integer getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(Integer capacidadCombustible) throws Exception {
        if (capacidadCombustible == null || capacidadCombustible <= 30) {
            throw new ExcepcionAtributos("ERROR. Capacidad de combustible inválida.");
        } else {
            this.capacidadCombustible = capacidadCombustible;
        }
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) throws Exception {
        if (fechaAdquisicion == null || fechaAdquisicion.toString().isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Fecha de adquisición de transporte inválida.");
        } else {
            this.fechaAdquisicion = fechaAdquisicion;
        }
    }

    public Integer getAsientosBasicos() {
        return asientosBasicos;
    }

    public void setAsientosBasicos(Integer asientosBasicos) throws Exception {
        if (asientosBasicos == null || asientosBasicos <= 0) {
            throw new ExcepcionAtributos("ERROR. Número de asientos básicos inválido.");
        } else {
            this.asientosBasicos = asientosBasicos;
        }
    }

    public Integer getAsientosPrimeraClase() {
        return asientosPrimeraClase;
    }

    public void setAsientosPrimeraClase(Integer asientosPrimeraClase) throws Exception {
        if (asientosPrimeraClase == null || asientosPrimeraClase <= 0) {
            throw new ExcepcionAtributos("ERROR. Número de asientos de primera clase inválido.");
        } else {
            this.asientosPrimeraClase = asientosPrimeraClase;
        }
    }

    public AgenciaEntity getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaEntity agencia) throws Exception {
        if (agencia == null) {
            throw new ExcepcionAtributos("ERROR. Agencia inválida.");
        } else {
            this.agencia = agencia;
        }
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
        TransporteEntity other = (TransporteEntity) obj;
        if (idTransporte == null) {
            if (other.idTransporte != null)
                return false;
        } else if (!idTransporte.equals(other.idTransporte))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idTransporte=" + idTransporte + ", tipoTransporte=" +
                ", marca=" + marca + ", modelo=" + modelo
                + ", capacidadCombustible=" + capacidadCombustible
                + ", fechaAdquisicion=" + fechaAdquisicion + ", agencia=" + agencia.getUbicacionAgencia();
    }

}
