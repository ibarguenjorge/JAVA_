import java.util.Scanner;

public class Michi {
    private static char[][] tablero = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };
    private static char jugadorActual = 'X';

    public static void main(String[] args) {
        boolean juegoTerminado = false;
        Scanner scanner = new Scanner(System.in);

        while (!juegoTerminado) {
            imprimirTablero();
            int movimiento = obtenerMovimiento(scanner);
            realizarMovimiento(movimiento);
            juegoTerminado = verificarEstadoJuego();
            cambiarJugador();
        }
        scanner.close();
    }

    // Imprimir el tablero actual
    private static void imprimirTablero() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Obtener el movimiento del jugador
    private static int obtenerMovimiento(Scanner scanner) {
        int movimiento;
        do {
            System.out.println("Jugador " + jugadorActual + ", ingrese un número del 1 al 9 para hacer su movimiento:");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 9:");
                scanner.next(); // Limpiar la entrada inválida
            }
            movimiento = scanner.nextInt();
        } while (movimiento < 1 || movimiento > 9 || !esMovimientoValido(movimiento));
        return movimiento;
    }

    // Verificar si el movimiento es válido
    private static boolean esMovimientoValido(int movimiento) {
        switch (movimiento) {
            case 1: return tablero[0][0] == '1';
            case 2: return tablero[0][1] == '2';
            case 3: return tablero[0][2] == '3';
            case 4: return tablero[1][0] == '4';
            case 5: return tablero[1][1] == '5';
            case 6: return tablero[1][2] == '6';
            case 7: return tablero[2][0] == '7';
            case 8: return tablero[2][1] == '8';
            case 9: return tablero[2][2] == '9';
            default: return false;
        }
    }

    // Realizar el movimiento en el tablero
    private static void realizarMovimiento(int movimiento) {
        switch (movimiento) {
            case 1: tablero[0][0] = jugadorActual; break;
            case 2: tablero[0][1] = jugadorActual; break;
            case 3: tablero[0][2] = jugadorActual; break;
            case 4: tablero[1][0] = jugadorActual; break;
            case 5: tablero[1][1] = jugadorActual; break;
            case 6: tablero[1][2] = jugadorActual; break;
            case 7: tablero[2][0] = jugadorActual; break;
            case 8: tablero[2][1] = jugadorActual; break;
            case 9: tablero[2][2] = jugadorActual; break;
        }
    }

    // Verificar si hay un ganador o empate
    private static boolean verificarEstadoJuego() {
        // Comprobar filas, columnas y diagonales para determinar un ganador
        if (verificarGanador()) {
            imprimirTablero();
            System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
            return true;
        }

        // Comprobar si el tablero está lleno (empate)
        if (tableroLleno()) {
            imprimirTablero();
            System.out.println("¡El juego ha terminado en empate!");
            return true;
        }

        return false;
    }

    // Verificar si hay un ganador
    private static boolean verificarGanador() {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true;
            }
        }

        // Comprobar columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) {
                return true;
            }
        }

        // Comprobar diagonales
        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true;
        }

        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true;
        }

        return false;
    }

    // Verificar si el tablero está lleno
    private static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] != 'X' && tablero[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    // Cambiar el jugador actual
    private static void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
}
