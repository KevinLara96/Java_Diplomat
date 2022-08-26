package dgtic.vista.inicio.principal;

import java.util.concurrent.TimeUnit;

import dgtic.controlador.servicio.tablas.ServiciosAgencia;
import dgtic.controlador.servicio.tablas.ServiciosAgenciaImpl;
import dgtic.modelo.entidades.agencia.Agencia;
import dgtic.modelo.entidades.empleado.Empleado;
import dgtic.modelo.hibernate.HibernateUtil;

public class Inicio {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Creando agencia...");
        Agencia agencia = Agencia.getInstancia();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Agencia creada.\n");

        System.out.println("Creando administrador sys ...");
        Empleado sys = new Empleado();
        sys.setIdEmpleado(1);
        sys.setNombre("sys");
        sys.setCorreo("sys@sak.com");
        sys.setContrasena("system1");
        sys.setRfc("");
        sys.setSalario(0.00f);
        TimeUnit.SECONDS.sleep(2);
        agencia.getEmpleados().add(sys);
        System.out.println("Usuario sys creado.");

        HibernateUtil.init();
        ServiciosAgencia servicio = ServiciosAgenciaImpl.getInstance();
        servicio.guardaAgencia(agencia);

    }
}
