import java.util.Scanner;

public class EsPar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese número: ");
        int numero = input.nextInt();
        if (numero % 2 == 0)
            System.out.println("Es par.");
        else
            System.out.println("Es impar.");

        input.close();
    }
}
