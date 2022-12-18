package unam.dgtic.diplomado.modelo.entidades.cliente;

import java.util.List;
import java.util.regex.Pattern;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import unam.dgtic.diplomado.modelo.entidades.agencia.Agencia;
import unam.dgtic.diplomado.modelo.entidades.orden.Orden;
import unam.dgtic.diplomado.modelo.excepciones.ExcepcionAtributos;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombres;
    private String apellidos;
    private String calle;
    private String colonia;
    private String codigoPostal;
    private String telefono;
    private String rfc;
    private String correo;
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "idAgencia")
    private Agencia agencia;

    @OneToMany(mappedBy = "cliente")

    private List<Orden> ordenes;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombres, String apellidos) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) throws Exception {
        if (idCliente == null || idCliente <= 0) {
            throw new ExcepcionAtributos("ERROR. Id de cliente inválido.");
        } else {
            this.idCliente = idCliente;
        }
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) throws Exception {
        if (nombres == null || nombres.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Nombre(s) de cliente inválido(s).");
        } else {
            this.nombres = nombres;
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) throws Exception {
        if (apellidos == null || apellidos.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Apellidos de cliente inválidos.");
        } else {
            this.apellidos = apellidos;
        }
        this.apellidos = apellidos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) throws Exception {
        if (calle == null || calle.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Calle de cliente inválida.");
        } else {
            this.calle = calle;
        }
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) throws Exception {
        if (colonia == null || colonia.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Colonia de cliente inválida.");
        } else {
            this.colonia = colonia;
        }
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) throws Exception {
        if (codigoPostal == null || codigoPostal.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Código Postal de cliente inválido.");
        } else {
            this.codigoPostal = codigoPostal;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws Exception {
        if (telefono == null || telefono.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Teléfono de cliente inválido.");
        } else {
            this.telefono = telefono;
        }
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) throws Exception {
        if (rfc == null || rfc.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. RFC de cliente inválido.");
        } else {
            this.rfc = rfc;
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
            throw new ExcepcionAtributos("ERROR. Correo electrónico de cliente vacío.");
        } else {
            throw new ExcepcionAtributos("ERROR. Correo no válido de cliente.");
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) throws Exception {
        if (contrasena == null || contrasena.isEmpty()) {
            throw new ExcepcionAtributos("ERROR. Contraseña de cliente inválida.");
        } else {
            this.contrasena = contrasena;

        }
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) throws Exception {
        if (ordenes == null) {
            throw new ExcepcionAtributos("ERROR. Lista de órdenes vacía.");
        } else {
            this.ordenes = ordenes;
        }
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
        Cliente other = (Cliente) obj;
        if (idCliente == null) {
            if (other.idCliente != null)
                return false;
        } else if (!idCliente.equals(other.idCliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[idCliente=" + idCliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", calle="
                + calle + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", telefono=" + telefono
                + ", rfc=" + rfc + ", correo=" + correo + ", contrasena=" + contrasena + ", agencia="
                + agencia.getUbicacionAgencia()
                + ", ordenes=" + ordenes + "]";
    }

}