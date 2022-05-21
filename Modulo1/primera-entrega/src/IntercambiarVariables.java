import java.util.Scanner;

public class IntercambiarVariables {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese los dos número a intercambiar: ");
        System.out.print("Número A: ");
        int a = input.nextInt();
        System.out.print("Número B: ");
        int b = input.nextInt();

        int x = a;
        a = b;
        b = x;

        System.out.println("A: " + a);
        System.out.println("B: " + b);

        input.close();
    }
}
