package unam.dgtic.diplomado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.controlador.servicio.cliente.ServicioOrden;
import unam.dgtic.diplomado.modelo.entidades.cliente.Cliente;
import unam.dgtic.diplomado.modelo.entidades.cliente.Orden;

public class Pruebas {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectofinal");
        EntityManager em = emf.createEntityManager();

        ServicioOrden servicioOrden = new ServicioOrden(em);

        Iterable<Orden> ordens = servicioOrden.obtenerOrdenes();
        for (Orden o : ordens) {
            System.out.println(o);
            for (Cliente c : o.getClientesAsociados()) {
                System.out.println("Clientes asociados: ");
                System.out.println(c.getIdCliente() + "," + c.getNombres() + " " + c.getApellidos());
            }
            System.out.println("\n");
        }

        Orden orden = servicioOrden.obtenerOrden(111);
        System.out.println(orden);

        /*
         * Orden orden2 = new Orden();
         * try {
         * orden2.setIdOrden(5);
         * orden2.setNombreOrden("Orden 3");
         * orden2.setUbicacionOrden("Cancún");
         * 
         * servicioOrden.guardarOrden(orden2);
         * 
         * } catch (Exception e) {
         * System.out.println("No se pudo crear orden");
         * }
         * 
         * try {
         * orden2 = servicioOrden.obtenerOrden(4);
         * orden2.setUbicacionOrden("Cancún");
         * servicioOrden.actualizarOrden(orden2);
         * } catch (Exception e) {
         * System.out.println("No se pudo actualizar la orden");
         * 
         * }
         * 
         */

        servicioOrden.eliminarOrden(4);
    }
}
