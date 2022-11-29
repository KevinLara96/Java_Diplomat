package mx.unam.diplomado.ejb;

import java.util.List;
import jakarta.ejb.Stateless;
import mx.unam.diplomado.agencia.dao.AgenciaDAOJDBC;
import mx.unam.diplomado.agencia.dao.IAgenciaDAO;
import mx.unam.diplomado.agendafaces.vo.Viaje;

/**
 * Session Bean implementation class AgendaEJB
 */
@Stateless(name = "IAgenciaEJBLocal")
public class AgenciaEJB implements IAgenciaEJBLocal {

    private IAgenciaDAO daoAgencia;

    public List<Viaje> cargaViajes() {
        daoAgencia = AgenciaDAOJDBC.getInstance();
        return daoAgencia.cargaViajes();
    }

}
