package unam.dgtic.diplomado.modelo.beans.agencia;

import java.io.Serializable;
import java.util.List;

//import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import unam.dgtic.diplomado.controlador.servicio.agencia.ServicioAgencia;
import unam.dgtic.diplomado.modelo.entidades.agencia.AgenciaEntity;

@Named
@SessionScoped
public class AgenciaBean implements Serializable {

    // @EJB
    private ServicioAgencia servicioAgencia;

    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacionAgencia;
    private AgenciaEntity agenciaEntity;

    private String estatus;

    /*
     * Constructores.
     */
    public AgenciaBean() {

    }

    /*
     * Getters y Setters
     */
    public Integer getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Integer idAgencia) {
        this.idAgencia = idAgencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getUbicacionAgencia() {
        return ubicacionAgencia;
    }

    public void setUbicacionAgencia(String ubicacionAgencia) {
        this.ubicacionAgencia = ubicacionAgencia;
    }

    public AgenciaEntity getAgenciaEntity() {
        return agenciaEntity;
    }

    public void setAgenciaEntity(AgenciaEntity agenciaEntity) {
        this.agenciaEntity = agenciaEntity;
    }

    public void obtenerAgencia(int idAgencia) {
        this.agenciaEntity = servicioAgencia.obtenerAgencia(idAgencia);
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /*
     * Métodos Bean.
     */
    public List<AgenciaEntity> obtenerAgencias() {
        servicioAgencia = new ServicioAgencia();
        return (List<AgenciaEntity>) servicioAgencia.obtenerAgencias();
    }

    public void obtenerAgencia() {
        servicioAgencia = new ServicioAgencia();
        this.agenciaEntity = servicioAgencia.obtenerAgencia(this.idAgencia);
    }

    public void actualizarAgencia() {
        servicioAgencia = new ServicioAgencia();
        AgenciaEntity agenciaMod = servicioAgencia.obtenerAgencia(this.idAgencia);

        try {
            agenciaMod.setIdAgencia(this.idAgencia);
            agenciaMod.setNombreAgencia(this.agenciaEntity.getNombreAgencia());
            agenciaMod.setUbicacionAgencia(this.agenciaEntity.getUbicacionAgencia());

            servicioAgencia.actualizarAgencia(agenciaMod);
            this.estatus = "Agencia actualizada con éxito.";
        } catch (Exception e) {
            this.estatus = "ERROR. No se pudo actualizar la agencia: " +
                    e.getMessage();
        }
    }

    public void nuevaAgencia() {
        servicioAgencia = new ServicioAgencia();
        this.agenciaEntity = new AgenciaEntity();
        try {
            agenciaEntity.setIdAgencia(this.idAgencia);
            agenciaEntity.setNombreAgencia(this.nombreAgencia);
            agenciaEntity.setUbicacionAgencia(this.ubicacionAgencia);

            servicioAgencia.guardarAgencia(this.agenciaEntity);
            this.estatus = "Agencia registrada con éxito.";
        } catch (Exception e) {
            this.estatus = "No se pudo registrar la agencia: " +
                    e.getMessage();
        }
    }

    public void eliminarAgencia() {
        servicioAgencia = new ServicioAgencia();
        try {
            if (servicioAgencia.eliminarAgencia(this.idAgencia)) {
                this.estatus = "Agencia eliminada con éxito.";
            } else {
                this.estatus = "ERROR. No se pudo eliminar la agencia: ";
            }
        } catch (Exception e) {
            this.estatus = "ERROR. No se pudo eliminar la agencia: ";
        }
    }
}