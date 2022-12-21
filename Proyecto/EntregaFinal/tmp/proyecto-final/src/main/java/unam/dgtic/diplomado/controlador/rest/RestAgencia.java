package unam.dgtic.diplomado.controlador.rest;

import java.io.Serializable;
import java.util.List;

import javax.naming.InitialContext;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;

@Named
@SessionScoped
public class RestAgencia implements Serializable {

    EntityManagerFactory mf = Persistence.createEntityManagerFactory("proyectofinal");
    EntityManager em = mf.createEntityManager();

    private ServicioAgencia servicioAgencia;

    public List<Agencia> getAgencias() {

        this.servicioAgencia = new ServicioAgencia(em);

        return (List<Agencia>) servicioAgencia.obtenerAgencias();
    }
}
