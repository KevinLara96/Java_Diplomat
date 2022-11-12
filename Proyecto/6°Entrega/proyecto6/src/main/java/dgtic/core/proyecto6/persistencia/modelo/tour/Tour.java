package dgtic.core.proyecto6.persistencia.modelo.tour;

import dgtic.core.proyecto6.persistencia.modelo.agencia.Agencia;

public class Tour {

    private Integer idTour;
    private String ciudad;
    private Float precio;
    private String fecha;

    private Agencia agencia;

    public Tour() {

    }

    public Tour(Integer idTour, String ciudad, Float precio, String fecha, Agencia agencia) {
        this.idTour = idTour;
        this.ciudad = ciudad;
        this.precio = precio;
        this.fecha = fecha;
        this.agencia = agencia;
    }

    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        result = prime * result + ((idTour == null) ? 0 : idTour.hashCode());
        result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
        result = prime * result + ((precio == null) ? 0 : precio.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
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
        Tour other = (Tour) obj;
        if (idTour == null) {
            if (other.idTour != null)
                return false;
        } else if (!idTour.equals(other.idTour))
            return false;
        if (ciudad == null) {
            if (other.ciudad != null)
                return false;
        } else if (!ciudad.equals(other.ciudad))
            return false;
        if (precio == null) {
            if (other.precio != null)
                return false;
        } else if (!precio.equals(other.precio))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (agencia == null) {
            if (other.agencia != null)
                return false;
        } else if (!agencia.equals(other.agencia))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tour [idTour=" + idTour + ", ciudad=" + ciudad + ", precio=" + precio + ", fecha=" + fecha
                + ", agencia=" + agencia + "]";
    }

}
