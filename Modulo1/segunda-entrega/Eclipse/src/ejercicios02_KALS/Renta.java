package ejercicios02_KALS;

public class Renta {
    private Cliente cliente;
    private Auto auto;
    private static int idRenta;

    public Renta(Cliente cliente, Auto auto) {
        this.cliente = cliente;
        this.auto = auto;
        idRenta++;
    }

    public String toString() {
        return "Renta No. " + idRenta + "\n" +
                "Cliente: " + this.cliente.getNombre() + "\n" +
                "Auto: " + this.auto.getModelo();
    }

    public static void main(String[] args) {

        Cliente clienteUno = new Cliente();
        clienteUno.setNombre("Kevin");
        clienteUno.setIdCliente(1);
        clienteUno.setRfc("ABCD");

        Auto autoUno = new Auto();
        autoUno.setMarca("Subaru");
        autoUno.setModelo("WRX");
        autoUno.setPrecio(250000);

        Renta rentaUno = new Renta(clienteUno, autoUno);
        System.out.println(rentaUno);
    }
}
