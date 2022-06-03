import java.security.PublicKey;

import javax.print.DocFlavor.STRING;

public class Personaje {
    String nombre;
    int fuerza;
    int vida;
    boolean vivo;
    int posicion;

    public Personaje(String nombre, int fuerza, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.vida = vida;
        this.vivo = true;
    }

    public atacar(Personaje oponente){
        if(oponente.isDefensa())
            oponente.
    }
}
