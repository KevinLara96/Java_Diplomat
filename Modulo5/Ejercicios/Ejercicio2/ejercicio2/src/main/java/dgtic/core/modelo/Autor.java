package dgtic.core.modelo;

public class Autor {

    private String nombre;
    private String edad;

    public Autor() {

    }

    public Autor(String nombre, String edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombres(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Autor [nombre=" + nombre + ", edad=" + edad + "]";
    }

}
