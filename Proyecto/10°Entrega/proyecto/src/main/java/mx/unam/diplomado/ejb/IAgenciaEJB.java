package mx.unam.diplomado.ejb;

import java.util.List;

import jakarta.ejb.Local;
import mx.unam.diplomado.agenciafaces.vo.viaje.Viaje;

@Local
public interface IAgenciaEJB {

    public List<Viaje> cargarViajes();

}
