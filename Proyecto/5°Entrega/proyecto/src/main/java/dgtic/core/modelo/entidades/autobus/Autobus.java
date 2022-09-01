package dgtic.core.modelo.entidades.autobus;

import java.io.Serializable;
import java.util.Random;

import dgtic.core.modelo.entidades.agencia.Agencia;

public class Autobus implements Serializable {
    private Integer idAutobus;
    private String modelo;
    private String marca;
    private Integer capacidad;
    private ClaseBus claseBus;
    private ClaseTuribus claseTuribus;
    private Agencia agencia;

    public Autobus() {
    }

    public Autobus(int claveAutobus, String modelo, String marca, int capacidad) {
        // setIdAutobus(claveAutobus);
        setModelo(modelo);
        setMarca(marca);
        setCapacidad(capacidad);
    }

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

    public ClaseBus getClaseBus() {
        return claseBus;
    }

    public void setClaseBus(ClaseBus claseBus) {
        this.claseBus = claseBus;
    }

    public ClaseTuribus getClaseTuribus() {
        return claseTuribus;
    }

    public void setClaseTuribus(ClaseTuribus claseTuribus) {
        this.claseTuribus = claseTuribus;
    }

    public void setIdAutobus(Integer idAutobus) {
        this.idAutobus = idAutobus;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("\nAutobus: \n");
        str.append("idAutobus: ").append(idAutobus);
        str.append(" / Marca: ").append(marca);
        str.append(" / Modelo: ").append(modelo);
        str.append(" / Capacidad: ").append(capacidad);
        // str.append(" / ClaseBus: ").append(claseBus.getIdClaseAutobus());
        // str.append(" / ClaseTuribus: ").append(claseTuribus.getIdClaseTuribus());
        return str.toString();
    }

    public static class Builder {
        private Autobus autobusBuilder;

        public Builder() {
            autobusBuilder = new Autobus();
        }

        public Builder(Integer idAutobus, String modelo, String marca, int capacidad) {
            autobusBuilder = new Autobus(idAutobus, modelo, marca, capacidad);
        }

        public BuildBus setClaseBus() {
            return new BuildBus(autobusBuilder);
        }

        public BuildTuribus setClaseTuribus() {
            return new BuildTuribus(autobusBuilder);
        }
    }

    public static class BuildBus {
        private Autobus autobus;

        public BuildBus(Autobus autobus) {
            this.autobus = autobus;
        }

        public BuildBus setClaseBus() {
            return this;
        }

        public Autobus build() {
            return autobus;
        }
    }

    public static class BuildTuribus {
        private Autobus autobus;

        public BuildTuribus(Autobus autobus) {
            this.autobus = autobus;
        }

        public BuildTuribus setClaseTuribus() {
            return this;
        }

        public Autobus build() {
            return autobus;
        }
    }
}
