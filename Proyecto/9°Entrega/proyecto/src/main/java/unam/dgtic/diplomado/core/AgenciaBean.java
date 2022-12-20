package unam.dgtic.diplomado.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AgenciaBean implements Serializable {

    private static final long serialVersionUID = -7258677092121565613L;

    private Integer idAgencia;
    private String nombreAgencia;
    private String ubicacion;
    private List<EmpleadoEntity> empleados;
    private List<ViajeEntity> destinos;

    public AgenciaBean() {
        this.nombreAgencia = "Agencia 1";
        this.ubicacion = "Ciudad de México";
        this.empleados = new ArrayList<>();
        this.destinos = new ArrayList<>();

        EmpleadoEntity emp = new EmpleadoEntity();
        emp.setIdEmpleado(1);
        emp.setNombre("SYS");
        emp.setCorreo("sys@sak.com");
        emp.setContrasena("system1");
        emp.setRfc("-");
        emp.setSalario(0.0f);

        AgenciaEntity agencia = new AgenciaEntity();
        agencia.setIdAgencia(this.getIdAgencia());
        agencia.setNombreAgencia(this.getNombreAgencia());
        agencia.setUbicacion(this.getUbicacion());
        emp.setAgencia(agencia);

        PuestoEntity puesto = new PuestoEntity(1, "SYS");
        emp.setPuesto(puesto);

        empleados.add(emp);
    }

    public List<EmpleadoBean> hola() {
        List<EmpleadoBean> tmp = new ArrayList<>();
        EmpleadoBean a = new EmpleadoBean();
        a.setNombre("NULL");
        tmp.add(a);

        return tmp;
    }

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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoEntity> empleados) {
        this.empleados = empleados;
    }

    public List<ViajeEntity> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<ViajeEntity> destinos) {
        this.destinos = destinos;
    }

    public String agregarEmpleado(EmpleadoBean empleadoBean, PuestoBean puestoBean) {
        EmpleadoEntity emp = new EmpleadoEntity();
        emp.setIdEmpleado(empleadoBean.getIdEmpleado());
        emp.setNombre(empleadoBean.getNombre());
        emp.setCorreo(empleadoBean.getCorreo());
        emp.setContrasena(empleadoBean.getContrasena());
        emp.setRfc(empleadoBean.getRfc());
        emp.setSalario(empleadoBean.getSalario());

        AgenciaEntity agencia = new AgenciaEntity();
        agencia.setIdAgencia(this.getIdAgencia());
        agencia.setNombreAgencia(this.getNombreAgencia());
        agencia.setUbicacion(this.getUbicacion());
        emp.setAgencia(agencia);

        PuestoEntity puesto = new PuestoEntity();
        puesto.setIdPuesto(1);
        puesto.setPuesto(puestoBean.getPuesto());
        emp.setPuesto(puesto);

        empleados.add(emp);
        empleados.sort(Comparator.comparing(EmpleadoEntity::getIdEmpleado));

        return "confirmacionEmpleado";
    }

    public String agregarViaje(ViajeBean viajeBean) {

        ViajeEntity viaje = new ViajeEntity();
        viaje.setIdViaje(viajeBean.getIdViaje());
        viaje.setOrigen(viajeBean.getOrigen());
        viaje.setDestino(viajeBean.getDestino());
        viaje.setPrecio(viajeBean.getPrecio());
        viaje.setDistancia(viajeBean.getDistancia());
        viaje.setFecha(viajeBean.getFecha());
        viaje.setTipoViaje(viajeBean.getTipoViaje());

        this.destinos.add(viaje);
        destinos.sort(Comparator.comparing(ViajeEntity::getIdViaje));

        return "index";
    }

}
