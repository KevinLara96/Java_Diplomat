package unam.dgtic.diplomado.m1100base.dominio.cliente;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.m1100base.dominio.agencia.Agencia;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private Integer idCliente;
    private String nombre;
    private String calle;
    private String colonia;
    private String telefono;
    private String rfc;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    @ManyToMany
    @JoinTable(name = "cliente_orden", joinColumns = @JoinColumn(name = "idCliente"), inverseJoinColumns = @JoinColumn(name = "idOrden"))
    private List<Orden> ordenes;

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String calle, String colonia, String telefono, String rfc) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.calle = calle;
        this.colonia = colonia;
        this.telefono = telefono;
        this.rfc = rfc;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
        Cliente other = (Cliente) obj;
        if (idCliente == null) {
            if (other.idCliente != null)
                return false;
        } else if (!idCliente.equals(other.idCliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idCliente=" + idCliente + ", nombre=" + nombre + ", calle=" + calle + ", colonia=" + colonia
                + ", telefono=" + telefono + ", rfc=" + rfc + ", agencia=" + agencia.getUbicacion() + "]\n";
    }

}
