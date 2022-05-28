public class Profesor extends Persona {
    private String curp;
    private String academia;

    public Profesor(String curp, String academia, String nombre, int edad) {
        super(nombre, edad);
        if (edad < 18)
            setEdad(0);
        setCurp(curp);
        setAcademia(academia);
    }

    public boolean altaEnNomina() {
        System.out.println("El profesor ha quedado registrado en nómina.");
        return true;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getAcademia() {
        return academia;
    }

    public void setAcademia(String academia) {
        if (academia.length() > 10)
            this.academia = academia;
        else {
            this.academia = "null";
            System.out.println("Academia inválida, debe tener una longitud mínima de 10 caracteres.");
        }
    }

    @Override
    public String toString() {
        return "Profesor [academia=" + academia + ", curp=" + curp + "]";
    }
}
