import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero {
    public static void main(String[] args) {
        System.out.println("Adivina el número.\n");
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("¿Cuántos intentos quieres tener?");
        int intentos = input.nextInt();

        System.out.println("¿Cuál es el límite?");
        int tope = input.nextInt();

        int respuesta;
        int jugar;
        int partidasGanadas = 0;

        do {
            // double numero = Math.floor(Math.random() * 100);
            int numero = (random.nextInt(tope)) + 1;
            for (int i = intentos; i > 0; i--) {
                System.out.println("Quedan " + i + " intentos.");
                System.out.println("Ingrese su número:");
                respuesta = input.nextInt();

                if (respuesta == numero) {
                    System.out.println("Adivinaste.");
                    System.out.println("Usaste " + (10 - i + 1) + " intentos.");
                    partidasGanadas++;
                    break;
                } else if (respuesta > numero)
                    System.out.println("Menos.\n");
                else if (respuesta < numero)
                    System.out.println("Más.\n");

                if (i == 1)
                    System.out.println("Perdiste.");
            }
            System.out.println("¿Desea jugar otra vez?");
            System.out.println("1 -> Sí.");
            System.out.println("0 -> No.");
            jugar = input.nextInt();
        } while (jugar == 1);

        System.out.println("Partidas ganadas: " + partidasGanadas);
        input.close();
    }
}
