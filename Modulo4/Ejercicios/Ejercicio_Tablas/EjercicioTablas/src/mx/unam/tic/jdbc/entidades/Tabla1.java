package mx.unam.tic.jdbc.entidades;

import java.util.List;

public class Tabla1 {
    private Integer id;
    private String dato1;
    private List<Tabla2> tablas2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDato1() {
        return dato1;
    }

    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }

    public List<Tabla2> getTablas2() {
        return tablas2;
    }

    public void setTablas2(List<Tabla2> tablas2) {
        this.tablas2 = tablas2;
    }

}
