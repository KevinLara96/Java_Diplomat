package dgtic.modelo;

public class AlmacenarAdicionalImpl implements AlmacenarIntfAdicional {

    @Override
    public void guardarMensaje(String mensaje) {
        System.out.println("Mensaje de texto");

    }

    @Override
    public void guardarMensaje(Object objetc) {
        System.out.println(objetc.toString());

    }

    @Override
    public void setCifrado(Cifrado tipo) {
        System.out.println(tipo.name());

    }

}
