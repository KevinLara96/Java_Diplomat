package mx.unam.diplomado.ejb;

import java.util.List;

import jakarta.ejb.Local;
import mx.unam.diplomado.agendafaces.vo.Viaje;

@Local
public interface IAgenciaEJBLocal {

    List<Viaje> cargaViajes();

}
