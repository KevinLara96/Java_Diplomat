package mx.unam.diplomado.ejb;

import java.util.List;

import jakarta.ejb.Stateless;
import mx.unam.diplomado.agencia.dao.AgenciaDAO;
import mx.unam.diplomado.agencia.dao.IAgenciaDAO;
import mx.unam.diplomado.agenciafaces.vo.viaje.Viaje;

@Stateless
public class AgenciaEJB implements IAgenciaEJB {

    private IAgenciaDAO daoAgencia;

    @Override
    public List<Viaje> cargarViajes() {
        daoAgencia = AgenciaDAO.getInstance();
        return daoAgencia.cargaViajes();
    }
}