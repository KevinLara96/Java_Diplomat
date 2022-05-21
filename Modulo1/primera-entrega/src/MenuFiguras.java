import java.util.Scanner;

public class MenuFiguras {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Menú figuras. Elija la figura.");
        System.out.println("1. Rectángulo\n");
        System.out.println("2. Triángulo rectángulo.\n");
        System.out.println("3. Triángulo escaleno.\n");
        System.out.println("9. Salir.");

        // char option = input.next().charAt(0);
        // System.out.println(option);

        input.close();
    }
}
