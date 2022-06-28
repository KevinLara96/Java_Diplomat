package dgtic.modelo;

import java.util.ArrayList;

public class Cuenta {
    private String nombreBanco;
    private String numeroTarjeta;
    private ArrayList<Pago> pago = new ArrayList<>();

    public Cuenta() {

    }

    public boolean verificarPago() {
        /*
         * 1. Conectarme a la B.D
         * 2. Verificar que existe el pago.
         * 3. Obtener los datos del pago.
         */
        return true;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public ArrayList<Pago> getPago() {
        return pago;
    }

    public void setPago(ArrayList<Pago> pago) {
        this.pago = pago;
    }
}
