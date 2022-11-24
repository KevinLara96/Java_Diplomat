package unam.dgtic.diplomado.core.wsejb2.pojo;

import lombok.Getter;
import lombok.Setter;

public class Persona {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String apellidos;

    @Getter
    @Setter
    private String fechaNacimiento;
}
