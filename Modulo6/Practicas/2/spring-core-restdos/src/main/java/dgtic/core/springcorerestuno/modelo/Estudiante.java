package dgtic.core.springcorerestuno.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante {

    private String cuenta;
    private String nombre;
    private String edad;
    private List<Materia> materia = new ArrayList<>();

    public Estudiante(String cuenta, String nombre, String edad, Materia... materias) {
        super();
        this.cuenta = cuenta;
        this.nombre = nombre;
        this.edad = edad;
        this.materia.addAll(Arrays.asList(materias));
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public List<Materia> getMateria() {
        return materia;
    }

    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }

}
