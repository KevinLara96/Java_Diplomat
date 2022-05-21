public class Repaso01 {
    public static void main(String[] args) {
        int numero = 0;
        double otroNumero;
        String texto = "algo";

        if (numero > 10)
            System.out.println("La condición es verdadera");
        else
            System.out.println("La condición es falsa");

        while (numero < 10)
            numero++;
    }

    public static void imprime(int arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }
}
