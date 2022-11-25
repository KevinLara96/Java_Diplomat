package mx.unam.diplomado.agencia.dao;

import java.util.List;

import mx.unam.diplomado.agenciafaces.vo.viaje.Viaje;

public interface IAgenciaDAO {

    public List<Viaje> cargaViajes();

}
