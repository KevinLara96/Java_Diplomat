import java.util.Scanner;

public class RecorrerArreglo {
    public static void main(String[] args) {
        int arreglo[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int arreglo2[] = new int[arreglo.length];

        System.out.print("Ingrese el número de espacios a recorrer: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        n %= arreglo.length;
        for (int i = 0; i < arreglo.length; i++) {
            if ((n + i) >= arreglo.length)
                arreglo2[(n + i) - arreglo.length] = arreglo[i];
            else
                arreglo2[i + n] = arreglo[i];
        }

        for (int j : arreglo2) {
            System.out.print(j);
        }
        input.close();
    }
}
