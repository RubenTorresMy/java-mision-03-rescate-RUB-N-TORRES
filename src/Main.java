
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int vidas = 10;
        int filaRobot = 0;
        int columnaRobot = 0;

        char[][] matriz = new char[10][10];

        // Rellenar el tablero con casillas libres
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = '*';
            }
        }

        // Colocar robot y meta
        matriz[0][0] = 'R';
        matriz[9][9] = 'F';

        int filaAleatoria;
        int columnaAleatoria;

        // Colocar cinco obstaculos
        for (int i = 0; i < 5; i++) {
            do {
                filaAleatoria = random.nextInt(10);
                columnaAleatoria = random.nextInt(10);
            } while (matriz[filaAleatoria][columnaAleatoria] != '*');

            matriz[filaAleatoria][columnaAleatoria] = 'X';
        }

        // Colocar una bateria
        do {
            filaAleatoria = random.nextInt(10);
            columnaAleatoria = random.nextInt(10);
        } while (matriz[filaAleatoria][columnaAleatoria] != '*');

        matriz[filaAleatoria][columnaAleatoria] = 'B';

        // Mostrar tablero inicial
        System.out.println("TABLERO INICIAL");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        do {
            // Pedir movimiento
            System.out.print("Introduce una direccion: ");
            char movimiento = Character.toUpperCase(sc.next().charAt(0));

            int nuevaFila = filaRobot;
            int nuevaColumna = columnaRobot;

            // Calcular nueva posicion
            if (movimiento == 'W') {
                nuevaFila--;
            } else if (movimiento == 'S') {
                nuevaFila++;
            } else if (movimiento == 'A') {
                nuevaColumna--;
            } else if (movimiento == 'D') {
                nuevaColumna++;
            } else {
                System.out.println("Direccion no valida.");
            }

            // Comprobar que el movimiento es valido
            if (movimiento == 'W' || movimiento == 'A'
                    || movimiento == 'S' || movimiento == 'D') {

                if (nuevaFila >= 0 && nuevaFila < 10
                        && nuevaColumna >= 0 && nuevaColumna < 10) {


                    // Borrar la posicion anterior
                    matriz[filaRobot][columnaRobot] = '*';

                    // Actualizar posicion
                    filaRobot = nuevaFila;
                    columnaRobot = nuevaColumna;

                    // Colocar el robot en la nueva casilla
                    matriz[filaRobot][columnaRobot] = 'R';

                    System.out.println("Movimiento realizado.");

                } else {
                    System.out.println("Movimiento fuera del tablero.");
                }
            }

            // Mostrar tablero final
            System.out.println();
            System.out.println("TABLERO FINAL");

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Vidas restantes: " + vidas);

        }while(vidas != 0);
    }
}
