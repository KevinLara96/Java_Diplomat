package unam.dgtic.diplomado;

import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.controlador.servicio.empleado.ServicioEmpleado;
import unam.dgtic.diplomado.controlador.servicio.empleado.ServicioPuesto;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

public class Pruebas {

    public static void main(String[] args) {

        ServicioAgencia servicioAgencia = new ServicioAgencia();
        ServicioEmpleado servicioEmpleado = new ServicioEmpleado();
        ServicioPuesto servicioPuesto = new ServicioPuesto();

        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        try {
            empleadoEntity.setIdEmpleado(20);
            empleadoEntity.setNombres("Nombre");
            empleadoEntity.setApellidos("Ubicacion");
            empleadoEntity.setCorreo("hola@avk.com");
            empleadoEntity.setContrasena("Hola");
            empleadoEntity.setRfc("RFC");
            empleadoEntity.setSalario(100.0f);
            empleadoEntity.setAgencia(servicioAgencia.obtenerAgencia(2));
            empleadoEntity.setPuesto(servicioPuesto.obtenerPuesto(1));

            servicioEmpleado.guardarEmpleado(empleadoEntity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Iterable<EmpleadoEntity> empleados = servicioEmpleado.obtenerEmpleados();
        for (EmpleadoEntity a : empleados) {
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
