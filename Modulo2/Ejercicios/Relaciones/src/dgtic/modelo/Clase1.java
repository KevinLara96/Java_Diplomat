package dgtic.modelo;

public class Clase1 {
    private Clase2 rolDos;

    public Clase1() {
    }

    public Clase1(Clase2 rolDos) {
        this.rolDos = rolDos;
    }

    public Clase2 getRol2() {
        return rolDos;
    }

    public void setRolDos(Clase2 rolDos) {
        this.rolDos = rolDos;
    }

    @Override
    public String toString() {
        return "Clase1 [rolDos=" + rolDos + "]";
    }

}
