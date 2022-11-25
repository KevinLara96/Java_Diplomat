package mx.unam.diplomado;

import java.util.List;

import mx.unam.diplomado.agencia.dao.AgenciaDAO;
import mx.unam.diplomado.agenciafaces.vo.viaje.Viaje;

public class Main {

    public static void main(String[] args) {

        AgenciaDAO instance = AgenciaDAO.getInstance();

        List<Viaje> viajes = instance.cargaViajes();

        for (Viaje v : viajes) {
            System.out.println(v);
        }

        System.out.println("\n\n");

    }
}
