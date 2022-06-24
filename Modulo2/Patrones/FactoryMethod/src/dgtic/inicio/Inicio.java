package dgtic.inicio;

import dgtic.modelo.Reloj;
import dgtic.modelo.interfaz.*;

public class Inicio {
    public static void main(String[] args) {
        RelojFactory factory = new RelojCristalPlasticoFactory();
        Reloj reloj = factory.crea();

        System.out.println(reloj.toString());

        RelojFactory factoryDos = new RelojCristalVidrioFactory();
        Reloj relojDos = factoryDos.crea();
        System.out.println(relojDos.toString());
    }
}