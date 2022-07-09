package dgtic.inicio.principal;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;

import dgtic.modelo.agencia.Agencia;
import dgtic.modelo.empleado.administrador.Administrador;
import dgtic.modelo.empleado.puesto.Puesto;

public class Inicio {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Creando agencia...");
        Agencia agencia = Agencia.getInstancia();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Agencia creada.\n");

        System.out.println("Creando administrador sys ...");
        Administrador sys = new Administrador("sys", "sys@sak.com", "system1",
                "", 0.00f, Puesto.SYS, "sys123", 1);
        TimeUnit.SECONDS.sleep(1);
        agencia.getAdministradores().add(sys);
        System.out.println("Usuario sys creado.");

        /* Persistencia de la agencia. */
        try {
            FileOutputStream fileOut = new FileOutputStream("src/dgtic/modelo/agencia/repositorio/Agencia.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(agencia);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            System.out.println("No se pudo guardar la agencia.");
        }
    }
}
