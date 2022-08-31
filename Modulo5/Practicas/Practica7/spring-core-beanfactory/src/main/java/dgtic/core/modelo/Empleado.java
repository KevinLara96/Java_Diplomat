package dgtic.core.modelo;

public class Empleado {
    private String nombre;
    private Integer edad;
    private Actividades uno;

    public Empleado() {
    }

    public Empleado(Actividades actividad) {
        this.uno = actividad;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Actividades getUno() {
        return uno;
    }

    public void setUno(Actividades actividad) {
        this.uno = actividad;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", edad=" + edad + "]";
    }
}