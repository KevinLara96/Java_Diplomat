package unam.dgtic.diplomado;

import java.util.List;

import unam.dgtic.diplomado.controlador.servicio.producto.ServicioProducto;
import unam.dgtic.diplomado.modelo.entidades.orden.OrdenEntity;
import unam.dgtic.diplomado.modelo.entidades.producto.ProductoEntity;

public class Pruebas {

    public static void main(String[] args) {

        ServicioProducto servicioProducto = new ServicioProducto();
        ProductoEntity productoEntity = new ProductoEntity();

        try {
            productoEntity.setIdProducto(10);
            productoEntity.setNombreProducto("tmp");
            productoEntity.setMultiplicador(1.5f);
            productoEntity.setEstatus("Activo");
            productoEntity.setOrdenes((List<OrdenEntity>) servicioProducto.productoJoinCliente(10));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(productoEntity);

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
