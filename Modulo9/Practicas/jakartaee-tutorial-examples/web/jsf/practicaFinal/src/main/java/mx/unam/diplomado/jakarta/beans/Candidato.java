package mx.unam.diplomado.jakarta.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;

@Named
@SessionScoped
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1234567891234567891L;

    private String nombre;
    private String telefono;
    private String correo;
    private List<Candidato> candidatos = new ArrayList<>();

    public Candidato() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public void agregar(AjaxBehaviorEvent event) throws AbortProcessingException {

        candidatos.add(this);

        /*
         * Candidato candidato = new Candidato();
         * candidato.setCorreo(correo);
         * candidato.setNombre(correo);
         * candidato.setTelefono(correo);
         * 
         * candidatos.add(candidato);
         * System.out.println(candidatos.size());
         * 
         * return "index";
         */
    }
}
