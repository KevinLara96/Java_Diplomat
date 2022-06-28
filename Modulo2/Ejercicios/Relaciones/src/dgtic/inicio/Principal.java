package dgtic.inicio;

import dgtic.modelo.*;

public class Principal {
    public static void main(String[] args) {
        // Clase1 objUno = new Clase1();
        // Clase2 objDos = new Clase2();
        // objUno.setReferencia(objDos);
        // objDos.setReferencia(objUno);

        Clase1 objUno = new Clase1();
        Clase2 objDos = new Clase2();
        objUno.setRolDos(objDos);
        objDos.setRolUno(objUno);
    }
}
