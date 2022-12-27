package unam.dgtic.diplomado;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.controlador.servicio.transporte.ServicioTransporte;
import unam.dgtic.diplomado.modelo.entidades.transporte.AvionEntity;
import unam.dgtic.diplomado.modelo.entidades.transporte.TransporteEntity;
import unam.dgtic.diplomado.modelo.entidades.transporte.factory.AvionFactory;
import unam.dgtic.diplomado.modelo.entidades.transporte.factory.TransporteFactory;

public class Pruebas {

    public static void main(String[] args) {

        ServicioTransporte servicioTransporte = new ServicioTransporte();
        ServicioAgencia servicioAgencia = new ServicioAgencia();

        List<TransporteEntity> transportes = servicioTransporte.obtenerTransportes();

        for (TransporteEntity transporteEntity : transportes) {
            System.out.println(transporteEntity);
        }

        TransporteFactory transporteFactory = new AvionFactory();
        AvionEntity avionEntity = (AvionEntity) transporteFactory.crear();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            String dateInString = "27/11/1998";
            Date date = sdf.parse(dateInString);

            avionEntity.setIdTransporte(100);
            avionEntity.setTipoTransporte("Avión");
            avionEntity.setMarca("Prueba");
            avionEntity.setModelo("Prueba");
            avionEntity.setCapacidadCombustible(50);
            avionEntity.setFechaAdquisicion(date);
            avionEntity.setAsientosBasicos(5);
            avionEntity.setAsientosPrimeraClase(5);
            avionEntity.setAgencia(servicioAgencia.obtenerAgencia(1));
            avionEntity.setPuertoAsignado("Prueba");

            servicioTransporte.guardarTransporte(avionEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\n");
        System.out.println(servicioTransporte.obtenerTransporte(100));

        try {
            avionEntity.setPuertoAsignado("Nuevo");
            servicioTransporte.actualizarTransporte(avionEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*
         * while (true) {
         * System.out.println("\nMenú principal:\n");
         * System.out.println("1. Consulta grupo.");
         * System.out.println("2. Consulta individual.");
         * System.out.println("3. Creación.");
         * System.out.println("4. Modificación.");
         * System.out.println("5. Eliminación.");
         * System.out.println("6. Salir.");
         * System.out.print("Su opción: ");
         * 
         * switch (0) {
         * case 1:
         * 
         * break;
         * 
         * case 2: {
         * 
         * break;
         * }
         * 
         * case 3: {
         * break;
         * }
         * 
         * case 4: {
         * 
         * break;
         * }
         * 
         * case 5: {
         * 
         * break;
         * }
         * 
         * case 6:
         * 
         * break;
         * }
         * }
         */
    }
}
