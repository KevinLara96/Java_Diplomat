package dgtic.vista.inicio.principal;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import dgtic.modelo.entidades.agencia.Agencia;
import dgtic.modelo.entidades.empleado.administrador.Administrador;

public class Inicio {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Creando agencia...");
        Agencia agencia = Agencia.getInstancia();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Agencia creada.\n");

        System.out.println("Creando administrador sys ...");
        Administrador sys = new Administrador(1, "sys", "sys@sak.com", "system1",
                "", 0.00f);
        TimeUnit.SECONDS.sleep(2);
        agencia.getAdministradores().add(sys);
        System.out.println("Usuario sys creado.");

        /* Persistencia de la agencia. */
        try {
            FileOutputStream fileOut = new FileOutputStream("src/dgtic/modelo/agencia/repositorio/Agencia.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(agencia);
            out.close();
            fileOut.close();
            System.out.println("Agencia creada.");
        } catch (Exception e) {
            System.out.println("No se pudo guardar la agencia.");
        }
    }
}
