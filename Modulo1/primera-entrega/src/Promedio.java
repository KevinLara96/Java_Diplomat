import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {
        System.out.println("Ingrese las 3 calificaciones: ");

        Scanner input = new Scanner(System.in);
        int calificacion;
        float promedio = 0.0f;

        for (int i = 0; i < 3; i++) {
            System.out.print("Calificación " + (i + 1) + ": ");
            calificacion = input.nextInt();
            promedio += calificacion;
            System.out.println();
        }
        promedio /= 3;
        System.out.println("El promedio es: " + promedio);

        input.close();
    }
}
