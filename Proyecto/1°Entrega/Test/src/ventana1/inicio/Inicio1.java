package ventana1.inicio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ventana1.datos.*;

public class Inicio1 {
    public static void main(String[] args) {
        Dato1 dato1 = new Dato1();
        dato1.setDato1("Lara");
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/ventana1/datos/Datos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dato1);
            out.close();
            fileOut.close();
            System.out.println("Se escribió");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
