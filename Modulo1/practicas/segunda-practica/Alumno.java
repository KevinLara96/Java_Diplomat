public class Alumno extends Persona {
    private long boleta;
    private String carrera;

    public Alumno(long boleta, String carrera, String nombre, int edad) {
        super(nombre, edad);
        if (edad < 14)
            setEdad(0);
        setBoleta(boleta);
        setCarrera(carrera);
    }

    public boolean inscribirse() {
        System.out.println("Alumno inscrito con éxito.");
        return true;
    }

    public long getBoleta() {
        return boleta;
    }

    public void setBoleta(long boleta) {
        if (boleta >= 2000000000 && boleta <= 2999999999L)
            this.boleta = boleta;
        else {
            this.boleta = 0;
            System.out.println("Número de boleta incorrecto. Debe ser un valor entre 2000000000 y 2999999999");
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if (carrera.length() > 5)
            this.carrera = carrera;
        else {
            this.carrera = "null";
            System.out.println("Carrera inválida, la longitud mínima es de 5 caracteres");
        }
    }

    @Override
    public String toString() {
        return "Alumno [boleta=" + boleta + ", carrera=" + carrera + "]";
    }
}
