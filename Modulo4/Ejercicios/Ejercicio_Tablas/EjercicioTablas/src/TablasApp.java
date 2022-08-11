import mx.unam.tic.jdbc.dao.TablaDAO;
import mx.unam.tic.jdbc.dao.TablaDAOimpl;
import mx.unam.tic.jdbc.entidades.Tabla1;
import mx.unam.tic.jdbc.entidades.Tabla2;

public class TablasApp {
    public static void main(String[] args) throws Exception {
        TablaDAO dao = new TablaDAOimpl();
        Tabla1 tabla1 = dao.buscarRow(1);

        System.out.println("El registro tabla es: id=" + tabla1.getId() + ", dato1=" + tabla1.getDato1());
        System.out.println("Los registros asociados son: ");
        for (Tabla2 tabla2 : tabla1.getTablas2()) {
            System.out.println("La tabla 2 asociada es: id=" + tabla2.getId() + ", dato2=" + tabla2.getDato2());
        }
    }
}
