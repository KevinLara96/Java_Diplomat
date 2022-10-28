package mx.unam.diplomado.modelo.entidades;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Transient;

@NamedQuery(name = "Empleado.buscarTodos", query = "Select e from Empleado e")

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    private Integer idEmpleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPuesto", referencedColumnName = "idPuesto")
    private Puesto puesto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    @Transient
    private int idAgenciaE;
    @Transient
    private int idPuestoE;

    public Empleado() {
    }

    public Empleado(String nombre, String correo, String contrasena, String rfc, Float salario) {
        setNombre(nombre);
        setCorreo(correo);
        setContrasena(contrasena);
        setRfc(rfc);
        setSalario(salario);
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        if (idEmpleado <= 0 || idEmpleado == null) {
            Random rand = new Random();
            this.idEmpleado = rand.nextInt(1000);
        } else {
            this.idEmpleado = idEmpleado;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() <= 0 || nombre == null) {
            this.nombre = "Desconocido";
        } else {
            this.nombre = nombre;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        Random rand = new Random();

        if (!matcher.matches() || correo == null) {
            this.correo = "desconocido" + getNombre().substring(0, 3) +
                    rand.nextInt(100) + "@sak.com";
        } else {
            this.correo = correo;
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena.length() <= 0 || contrasena == null) {
            this.contrasena = "Usuario" + this.getNombre() + "1234#";
        } else {
            this.contrasena = contrasena;
        }
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        if (rfc.length() <= 0 || rfc == null) {
            this.rfc = "";
        } else {
            this.rfc = rfc;
        }
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        if (salario < 0) {
            this.salario = 5000.00f;
        } else {
            this.salario = salario;
        }
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Integer getIdPuestoE() {
        return idPuestoE;
    }

    public void setIdPuestoE(Integer idPuestoE) {
        this.idPuestoE = idPuestoE;
    }

    public int getIdAgenciaE() {
        return idAgenciaE;
    }

    public void setIdAgenciaE(int idAgenciaE) {
        this.idAgenciaE = idAgenciaE;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("\nEmpleado: \n");
        str.append("idEmpleado: ").append(idEmpleado);
        str.append(", nombre: ").append(this.nombre);
        str.append(", correo: ").append(this.correo);
        str.append(", rfc=" + this.rfc + ", salario=" + this.salario + "\n");

        return str.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idEmpleado == null) ? 0 : idEmpleado.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        if (idEmpleado == null) {
            if (other.idEmpleado != null)
                return false;
        } else if (!idEmpleado.equals(other.idEmpleado))
            return false;
        return true;
    }

}
