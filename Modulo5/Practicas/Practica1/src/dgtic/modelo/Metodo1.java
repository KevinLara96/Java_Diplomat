package dgtic.modelo;

public class Metodo1 {
    public static void main(String[] args) {
        Profesor profesor = new Profesor();
        Responsabilidades resp = new Responsabilidades();
        profesor.setResponsabilidad(resp);
        profesor.setNombre("Demo");
    }
}
