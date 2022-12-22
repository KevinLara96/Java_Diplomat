package unam.dgtic.diplomado;

import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.modelo.entidades.agencia.AgenciaEntity;

public class Pruebas {

    public static void main(String[] args) {

        ServicioAgencia servicioAgencia = new ServicioAgencia();
        Iterable<AgenciaEntity> agencias = servicioAgencia.obtenerAgencias();

        for (AgenciaEntity a : agencias) {
            System.out.println(a);
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
