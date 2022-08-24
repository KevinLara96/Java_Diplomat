package dgtic.modelo.autobus;

import java.io.Serializable;
import java.util.Random;

import dgtic.modelo.autobus.interfaces.Clase;
import dgtic.modelo.autobus.interfaces.TipoTuribus;
import dgtic.modelo.autobus.interfaces.TipoUso;

public class Autobus implements Serializable {
    private int claveAutobus;
    private String modelo;
    private String marca;
    private int capacidad;
    public Clase clase;
    public TipoUso tipoUso;
    public TipoTuribus tipoTuribus;

    public Autobus(int claveAutobus, String modelo, String marca, int capacidad) {
        setClaveAutobus(claveAutobus);
        setModelo(modelo);
        setMarca(marca);
        setCapacidad(capacidad);
    }

    public int getClaveAutobus() {
        return claveAutobus;
    }

    public void setClaveAutobus(int claveAutobus) {
        if (claveAutobus <= 0) {
            Random rand = new Random();
            this.claveAutobus = rand.nextInt(1000);
        } else {
            this.claveAutobus = claveAutobus;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            this.capacidad = 30;
        } else {
            this.capacidad = capacidad;
        }
    }

    public Clase getClase() {
        return clase;
    }

    public TipoUso getTipoUso() {
        return tipoUso;
    }

    public TipoTuribus getTipoTuribus() {
        return tipoTuribus;
    }

    @Override
    public String toString() {
        return "Autobus [" +
                "\n claveAutobus: " + claveAutobus +
                "\n marca=" + marca +
                "\n modelo=" + modelo +
                "\n capacidad=" + capacidad +
                "\n clase=" + clase +
                "\n tipoUso=" + tipoUso +
                "\n tipoTuribus=" + tipoTuribus + "]";

    }

    public static class Builder {
        private Autobus autobusBuilder;

        public Builder(int claveAutobus, String modelo, String marca, int capacidad) {
            autobusBuilder = new Autobus(claveAutobus, modelo, marca, capacidad);
        }

        public BuildViaje setTipoViaje(TipoUso tipoUso) {
            autobusBuilder.tipoUso = tipoUso;
            return new BuildViaje(autobusBuilder);
        }

        public BuildTour setTipoTour(TipoUso tipoUso) {
            autobusBuilder.tipoUso = tipoUso;
            return new BuildTour(autobusBuilder);
        }
    }

    public static class BuildViaje {
        private Autobus autobus;

        public BuildViaje(Autobus autobus) {
            this.autobus = autobus;
        }

        public BuildViaje setClase(Clase clase) {
            this.autobus.clase = clase;
            this.autobus.tipoTuribus = TipoTuribus.NA;
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
            this.autobus.clase = Clase.NA;
            return this;
        }

        public Autobus build() {
            return autobus;
        }
    }
}
