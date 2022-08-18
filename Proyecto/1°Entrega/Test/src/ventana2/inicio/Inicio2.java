package ventana2.inicio;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import ventana1.datos.Dato1;

public class Inicio2 {
    public static void main(String[] args) {

        Dato1 e = null;

        try {
            FileInputStream fileIn = new FileInputStream("./src/ventana1/datos/Datos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Dato1) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(e.getDato1());
    }
}
