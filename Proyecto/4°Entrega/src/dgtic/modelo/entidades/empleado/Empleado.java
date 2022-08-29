package dgtic.modelo.entidades.empleado;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.*;

import dgtic.modelo.entidades.agencia.Agencia;
import dgtic.modelo.entidades.puesto.Puesto;

@Entity
@Table(name = "empleado")
public class Empleado {
    private Integer idEmpleado;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rfc;
    private Float salario;
    private Puesto puesto;
    private Agencia agencia;

    public Empleado() {
    }

    @Id
    @Column(name = "idEmpleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "nombre")
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

    @Column(name = "correo")
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

    @Column(name = "contrasena")
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

    @Column(name = "rfc")
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

    @Column(name = "salario")
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

    @OneToOne(targetEntity = Puesto.class, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idPuesto", referencedColumnName = "idPuesto", nullable = false)
    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @ManyToOne(targetEntity = Agencia.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "idAgencia")
    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("Empleado: \nnombre=").append(this.nombre);
        str.append(", correo=").append(this.correo);
        str.append(", rfc=" + this.rfc + ", salario=" + this.salario);

        return str.toString();
    }

}
