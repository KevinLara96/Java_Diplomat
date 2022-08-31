package dgtic.vista.aplicacion;

import dgtic.modelo.hibernate.HibernateUtil;

public class InicioAplicacion {
    public static void main(String[] args) {
        System.out.println("Iniciando aplicación.");
        HibernateUtil.init();

        int numeroIntentos = 3;
        while (numeroIntentos > 0) {
            if (InicioSesion.inicioSesion()) {
                Aplicacion.ejecutarAplicacion();
            } else {
                numeroIntentos--;
                System.out.println("Número de intentos restantes: " + numeroIntentos);
            }
        }
        System.out.println("Límite de intentos alcanzado. Terminando aplicación.");
    }
}