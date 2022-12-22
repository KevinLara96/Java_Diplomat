package unam.dgtic.diplomado.modelo.entidades.empleado;

import java.util.regex.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.entidades.agencia.AgenciaEntity;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "empleado")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "seq_post", allocationSize = 5)
    private Integer idEmpleado;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private AgenciaEntity agencia;

    @ManyToOne
    @JoinColumn(name = "idPuesto")
    private PuestoEntity puesto;

    public EmpleadoEntity() {
    }

    public EmpleadoEntity(Integer idEmpleado, String nombres, String apellidos, String correo, String contrasena,
            String rfc,
            Float salario, PuestoEntity puesto) {
        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rfc = rfc;
        this.salario = salario;
        this.puesto = puesto;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) throws Exception {
        if (idEmpleado == null || idEmpleado <= 0) {
            throw new ExcepcionAtributos("ERROR. Id de cliente inválido.");
        } else {
            this.idEmpleado = idEmpleado;
        }
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) throws Exception {
        if (nombres == null || nombres.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Nombre(s) de empleado inválido(s).");
        } else {
            this.nombres = nombres;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) throws Exception {
        if (apellidos == null || apellidos.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Apellidos de empleado inválidos.");
        } else {
            this.apellidos = apellidos;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) throws Exception {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        boolean correoRegex = pattern.matcher(correo).matches();
        if (correoRegex) {
            this.correo = correo;
        } else if (correo == null || correo == "") {
            throw new ExcepcionAtributos("ERROR. Correo electrónico de empleado vacío.");
        } else {
            throw new ExcepcionAtributos("ERROR. Correo no válido de empleado.");
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) throws Exception {
        if (contrasena == null || contrasena.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Contrasena de empleado inválido.");
        } else {
            this.contrasena = contrasena;
        }
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) throws Exception {
        if (rfc == null || rfc.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. RFC de empleado inválido.");
        } else {
            this.rfc = rfc;
        }
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) throws Exception {
        if (salario == null || salario <= 0) {
            throw new ExcepcionAtributos("ERROR. Salario de empleado inválido.");
        } else {
            this.salario = salario;
        }
    }

    public AgenciaEntity getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaEntity agencia) throws Exception {
        if (agencia == null) {
            throw new ExcepcionAtributos("ERROR. Agencia de empleado inválida.");
        } else {
            this.agencia = agencia;
        }
    }

    public PuestoEntity getPuesto() {
        return puesto;
    }

    public void setPuesto(PuestoEntity puesto) throws Exception {
        if (puesto == null) {
            throw new ExcepcionAtributos("ERROR. Puesto de empleado inválido.");
        } else {
            this.puesto = puesto;
        }
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
        EmpleadoEntity other = (EmpleadoEntity) obj;
        if (idEmpleado == null) {
            if (other.idEmpleado != null)
                return false;
        } else if (!idEmpleado.equals(other.idEmpleado))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empleado [idEmpleado=" + idEmpleado + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo="
                + correo + ", contrasena=" + contrasena + ", rfc=" + rfc + ", salario=" + salario
                + ", agencia=" + agencia.getUbicacionAgencia() + ", puesto=" + puesto.getPuesto()
                + "]";
    }

}
