package dgtic.modelo.empleado.puesto;

public enum Puesto {
    SYS(1),
    ADMINISTRADOR(2),
    CONDUCTOR(3);

    public final int ID_PUESTO;

    Puesto(int ID_PUESTO) {
        this.ID_PUESTO = ID_PUESTO;
    }

}
