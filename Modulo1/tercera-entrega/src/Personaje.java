public class Personaje {
    String nombre;
    int fuerza;
    double vida;
    boolean vivo;
    int posicion;
    boolean Defensa;

    public Personaje(String nombre, int fuerza, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.vida = vida;
        this.vivo = true;
    }

    public void atacar(Personaje oponente) {
        if (oponente.isDefensa())
            // Si el oponente se está cubriendo, solo se resta un porcentaje de vida.
            oponente.setVida(oponente.getVida() - (this.fuerza * 0.25));
        else
            // Si el oponente no se está cubriendo, se resta el total del ataque.
            oponente.setVida(oponente.getVida() - this.fuerza);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
        if (this.getVida() <= 0)
            this.setVivo(false);
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public boolean isDefensa() {
        return Defensa;
    }

    public void setDefensa(boolean defensa) {
        Defensa = defensa;
    }
}
