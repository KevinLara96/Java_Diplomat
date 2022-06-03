public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() >= 10)
            this.nombre = nombre;
        else {
            this.nombre = "null";
            System.out.println("Nombre inválido. Debe tener longitud mínima de 10 caracteres");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0 && edad < 120)
            this.edad = edad;
        else {
            this.edad = 0;
            System.out.println("Edad inválida. El rango válido es de 0 a 120 anios.");
        }
    }

    @Override
    public String toString() {
        return "Persona [edad=" + edad + ", nombre=" + nombre + "]";
    }
}
