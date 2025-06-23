import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        while (true) {
            System.out.println("**** Aplicación Calculadora ****");
            // Mostramos el menu
            mostrarMenu();
            try {
                var operacion = Integer.parseInt(consola.nextLine());
                //        Revisar que este dentro de las opciones mencionadas
                if (operacion >= 1 && operacion <= 4) {
                    // Ejecutamos operacion deseada
                    ejecutarOperacion(operacion, consola );
                } else if (operacion == 5) { // Salir
                    System.out.println("Hasta pronto...");
                    break;
                } else {
                    System.out.println("Opcion erronea: " + operacion);
                }
                // Imprimimos un salto antes de repetir el ciclo
                System.out.println();
            } // fin del try
            catch (Exception e){
                System.out.println("Ocurrio un error: " +e.getMessage());
            }
        } // fin del while
    } // fin del main

    private static void mostrarMenu(){
        // System.out.println("1. Suma \n2.Resta \n3.Multiplicacion");
        System.out.println("""
                    1. Suma
                    2. Resta
                    3. Multiplicación
                    4. Division
                    5. Salir
                    """);
        System.out.print("Operación a realizar? ");
    }

    private static void ejecutarOperacion(int operacion, Scanner consola){
        System.out.print("Proporciona valor operando1: ");
        var operando1 = Double.parseDouble(consola.nextLine());
        System.out.print("Proporciona valor operando2: ");
        var operando2 = Double.parseDouble(consola.nextLine());
        Double resultado;
        switch (operacion) {
            case 1 -> { // Suma
                resultado = operando1 + operando2;
                System.out.println("Resultado Suma: " + resultado);
            }
            case 2 -> { // Resta
                resultado = operando1 - operando2;
                System.out.println("Resultado Resta: " + resultado);
            }
            case 3 -> {// Multiplicacion
                resultado = operando1 * operando2;
                System.out.println("Resultado Multiplicacion: " + resultado);
            }
            case 4 -> {// Division
                resultado = operando1 / operando2;
                System.out.println("Resultado Division: " + resultado);
            }
            default -> System.out.println("Opción Erronea: " + operacion);
        }
    }

}// fin de clase

