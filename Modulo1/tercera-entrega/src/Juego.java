import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Personaje personaje1 = new Personaje("Personaje 1", 25, 300);
        Personaje personaje2 = new Personaje("Personaje 2", 50, 150);

        System.out.println("Bienvenido al juego. \n Los controles son los siguientes:");
        System.out.println("1. Atacar con personaje 1.");
        System.out.println("2. Defensa con personaje 1.");
        System.out.println("3. Atacar con personaje 2.");
        System.out.println("4. Defensa con personaje 2.");

        int jugar = 1;

        do {
            System.out.print("Jugada: ");
            int accion = input.nextInt();

            switch (accion) {
                case 1:
                    personaje1.atacar(personaje2); // P1 ataca a P2.

                    // Se muestra la vida de los jugadores.
                    System.out.println("Vida P1: " + personaje1.getVida());
                    System.out.println("Vida P2: " + personaje2.getVida());
                    break;

                case 2:
                    // Si P1 está en ataque, pasa a defensa y viceversa.
                    personaje1.setDefensa(!personaje1.isDefensa());
                    if (personaje1.isDefensa())
                        System.out.println("P1 en modo defensa.");
                    else
                        System.out.println("P1 en modo ataque.");
                    break;

                case 3:
                    personaje2.atacar(personaje1); // P2 ataca a P1.

                    // Se muestra la vida de los jugadores.
                    System.out.println("Vida P1: " + personaje1.getVida());
                    System.out.println("Vida P2: " + personaje2.getVida());
                    break;

                case 4:
                    // Si P2 está en ataque, pasa a defensa y vicecersa.
                    personaje2.setDefensa(!personaje2.isDefensa());
                    if (personaje2.isDefensa())
                        System.out.println("P2 en modo defensa.");
                    else
                        System.out.println("P2 en modo ataque.");
                    break;
            }

            if (!personaje1.isVivo()) { // Ganó P2.
                System.out.println("Ganó personaje 2.");
            } else if (!personaje2.isVivo()) { // Ganó P1.
                System.out.println("Ganó personaje 1.");
            }

            // Si ambos siguen vivos, se sigue jugando.
            if (personaje1.isVivo() && personaje2.isVivo()) {
                continue;
            }

            System.out.println("¿Desea volver a jugar?");
            System.out.println("1. -> Sí.");
            System.out.println("2. -> No.");
            System.out.print("Su respuesta: ");
            jugar = input.nextInt();

        } while (jugar == 1);
    }
}
