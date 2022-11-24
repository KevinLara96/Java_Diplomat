package unam.dgtic.diplomado.core.wsejb2.dao;

import java.util.*;

import jakarta.enterprise.context.ApplicationScoped;

import unam.dgtic.diplomado.core.wsejb2.pojo.*;

@ApplicationScoped
public class DAOPersonaDummy implements IDAOPersona {

    public List<Persona> cargaPersonas() {
        List<Persona> personas = new ArrayList<>();
        Persona persona1 = new Persona();

        persona1.setId(1);
        persona1.setNombre("Kevin");
        persona1.setApellidos("Lara");
        persona1.setFechaNacimiento("03/08/1996");

        personas.add(persona1);

        return personas;
    }
}
