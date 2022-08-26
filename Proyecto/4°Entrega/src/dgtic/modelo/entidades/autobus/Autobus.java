package dgtic.modelo.entidades.autobus;

import java.io.Serializable;
import java.util.Random;

import javax.persistence.*;

@Entity
@Table(name = "autobus")
public class Autobus implements Serializable {
    private Integer idAutobus;
    private String modelo;
    private String marca;
    private Integer capacidad;
    private Integer idClaseBus;
    private Integer idClaseTuribus;

    public Autobus() {
    }

    public Autobus(int claveAutobus, String modelo, String marca, int capacidad,
            Integer idClaseBus, Integer idClaseTuribus) {
        setIdAutobus(claveAutobus);
        setModelo(modelo);
        setMarca(marca);
        setCapacidad(capacidad);
        setIdClaseBus(idClaseBus);
        setIdClaseTuribus(idClaseTuribus);
    }

    @Id
    @Column(name = "idAutobus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(int claveAutobus) {
        if (claveAutobus <= 0) {
            Random rand = new Random();
            this.idAutobus = rand.nextInt(1000);
        } else {
            this.idAutobus = claveAutobus;
        }
    }

    @Column(name = "modelo")
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo.length() <= 0) {
            this.modelo = "Desconocido";
        } else {
            this.modelo = modelo;
        }
    }

    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca.length() <= 0) {
            this.marca = "Desconocido";
        } else {
            this.marca = marca;
        }
    }

    @Column(name = "capacidad")
    public void setCapacidad(Integer capacidad) {
        if (capacidad <= 0) {
            this.capacidad = 30;
        } else {
            this.capacidad = capacidad;
        }
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    @OneToOne(targetEntity = ClaseBus.class, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idClaseBus", referencedColumnName = "idClaseBus", nullable = false)
    public Integer getIdClaseBus() {
        return idClaseBus;
    }

    public void setIdClaseBus(Integer idClaseBus) {
        this.idClaseBus = idClaseBus;
    }

    @OneToOne(targetEntity = ClaseTuribus.class, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idClaseTuribus", referencedColumnName = "idClaseTuribus", nullable = false)
    public Integer getIdClaseTuribus() {
        return idClaseTuribus;
    }

    public void setIdClaseTuribus(Integer idClaseTuribus) {
        this.idClaseTuribus = idClaseTuribus;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("Autobus: ");
        str.append("\nidAutobus: ").append(idAutobus);
        str.append("\nMarca: ").append(marca);
        str.append("\nModelo; ").append(modelo);
        str.append("\nCapacidad: ").append(capacidad);
        str.append("\nClaseBus: ").append(idClaseBus);
        str.append("\nClaseTuribus: ").append(idClaseTuribus);
        return str.toString();
    }

    public static class Builder {
        private Autobus autobusBuilder;

        public Builder(Integer idAutobus, String modelo, String marca, int capacidad,
                Integer idClaseBus, Integer idClaseTuribus) {
            autobusBuilder = new Autobus(idAutobus, modelo, marca, capacidad, idClaseBus, idClaseTuribus);
        }

        public BuildViaje setTipoViaje() {
            return new BuildViaje(autobusBuilder);
        }

        public BuildTour setTipoTour() {
            return new BuildTour(autobusBuilder);
        }
    }

    public static class BuildViaje {
        private Autobus autobus;

        public BuildViaje(Autobus autobus) {
            this.autobus = autobus;
        }

        public BuildViaje setClase() {
            return this;
        }

        public Autobus build() {
            return autobus;
        }
    }

    public static class BuildTour {
        private Autobus autobus;

        public BuildTour(Autobus autobus) {
            this.autobus = autobus;
        }

        public BuildTour setTipoTuribus() {
            return this;
        }

        public Autobus build() {
            return autobus;
        }
    }
}
