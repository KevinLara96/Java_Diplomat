package unam.dgtic.diplomado.core.wsejb2.ejb;

import java.util.*;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.dgtic.diplomado.core.wsejb2.dao.IDAOPersona;
import unam.dgtic.diplomado.core.wsejb2.pojo.Persona;

@Stateless
public class ServicioPersona {

    @Inject
    private IDAOPersona daoPersona;

    public List<Persona> cargaPersonas() {
        return daoPersona.cargaPersonas();
    }

}
