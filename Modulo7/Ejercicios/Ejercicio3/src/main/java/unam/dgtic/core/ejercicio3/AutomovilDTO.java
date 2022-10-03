package unam.dgtic.core.ejercicio3;

public class AutomovilDTO {
    private String marca;
    private String modelo;
    private String color;
    private Integer torque;
    private Integer potencia;
    private String dueno;

    public AutomovilDTO(String marca, String modelo, String color, Integer torque, Integer potencia, String dueno) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.torque = torque;
        this.potencia = potencia;
        this.dueno = dueno;
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

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    @Override
    public String toString() {
        return "AutomovilDTO [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", torque=" + torque
                + ", potencia=" + potencia + ", dueno=" + dueno + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((marca == null) ? 0 : marca.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((torque == null) ? 0 : torque.hashCode());
        result = prime * result + ((potencia == null) ? 0 : potencia.hashCode());
        result = prime * result + ((dueno == null) ? 0 : dueno.hashCode());
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
        AutomovilDTO other = (AutomovilDTO) obj;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (torque == null) {
            if (other.torque != null)
                return false;
        } else if (!torque.equals(other.torque))
            return false;
        if (potencia == null) {
            if (other.potencia != null)
                return false;
        } else if (!potencia.equals(other.potencia))
            return false;
        if (dueno == null) {
            if (other.dueno != null)
                return false;
        } else if (!dueno.equals(other.dueno))
            return false;
        return true;
    }

}