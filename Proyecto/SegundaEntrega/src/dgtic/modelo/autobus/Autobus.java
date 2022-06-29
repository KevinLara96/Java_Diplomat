package dgtic.modelo.autobus;

import java.io.Serializable;

import dgtic.modelo.autobus.interfaces.Clase;
import dgtic.modelo.autobus.interfaces.TipoTuribus;
import dgtic.modelo.autobus.interfaces.TipoUso;

public class Autobus implements Serializable {
    private String modelo;
    private String marca;
    private int capacidad;
    private Clase clase;
    private TipoUso tipoUso;
    private TipoTuribus tipoTuribus;

    public Autobus(String modelo, String marca, int capacidad) {
        this.modelo = modelo;
        this.marca = marca;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Autobus [" +
                "\n clase=" + clase +
                "\n marca=" + marca +
                "\n modelo=" + modelo +
                "\n capacidad=" + capacidad +
                "\n tipoUso=" + tipoUso +
                "\n tipoTuribus=" + tipoTuribus + "]";

    }

    public static class Builder {
        private Autobus autobus;

        public Builder(String modelo, String marca, int capacidad) {
            autobus = new Autobus(modelo, marca, capacidad);
        }

        public BuildViaje setTipoViaje(TipoUso tipoUso) {
            autobus.tipoUso = tipoUso;
            return new BuildViaje(autobus);
        }

        public BuildTour setTipoTour(TipoUso tipoUso) {
            autobus.tipoUso = tipoUso;
            return new BuildTour(autobus);
        }
    }

    public static class BuildViaje {
        private Autobus autobus;

        public BuildViaje(Autobus autobus) {
            this.autobus = autobus;
        }

        public BuildViaje setClase(Clase clase) {
            this.autobus.clase = clase;
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

        public BuildTour setTipoTuribus(TipoTuribus tipoTuribus) {
            this.autobus.tipoTuribus = tipoTuribus;
            return this;
        }

        public Autobus build() {
            return autobus;
        }
    }
}
