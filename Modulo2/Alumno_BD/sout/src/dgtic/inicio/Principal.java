package dgtic.inicio;

import dgtic.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

import dgtic.inicio.*;
import dgtic.servicio.*;

public class Principal {
    public static void main(String[] args) {
        List<Alumno> lista = new ArrayList<>();
        lista = ServicioBD.consulta();

        Consulta consulta = new Consulta();

        List<Alumno> alm = lista.stream().filter(alum -> (alum.getNombre().equals("José"))).collect(toList());

        String cadena = new Exportaciones().exportarCSV(consulta.buscarCalificaciones(alm.get(0)));
        System.out.println(cadena);
    }
}
