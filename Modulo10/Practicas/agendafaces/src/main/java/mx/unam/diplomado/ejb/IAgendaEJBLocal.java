package mx.unam.diplomado.ejb;

import java.util.List;

import jakarta.ejb.Local;
import mx.unam.diplomado.agendafaces.vo.Contacto;
import mx.unam.diplomado.agendafaces.vo.TipoContacto;

@Local
public interface IAgendaEJBLocal {

    List<Contacto> cargaContactos();

    List<TipoContacto> cargaTipoContactos();

}
