import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        while (true) {
        System.out.println("*** Aplicación Calculadora ***");
            // Mostrar el menú
            mostrarMenu();

            try {


                var operacion = Integer.parseInt(consola.nextLine());
                // Revisar que se encuentre en las opciones mencionadas
                if (operacion >= 1 && operacion <= 4) {
                // Ejecutamos la operacion deseada
                     ejecutarOperacion(operacion, consola);

                } else if (operacion == 5) { // Salir
                    System.out.println("Hasta pronto...");
                    break;
                } else {
                    System.out.println("Opción incorrecta " + operacion);
                }
            } // fin del try
            catch (Exception e) {
                System.out.println("Ocurrió un error: "+e.getMessage());;
            }

            // Imprimimos un salto de linea
            System.out.println();
        } // fin del while

    } // fin del main

    private static void mostrarMenu () {

        System.out.println("""
                    1. Suma
                    2. Resta
                    3. Multiplicación
                    4. División
                    5. Salir
                    """);
        System.out.print("Operación a realizar es ?");
    }

    private static void ejecutarOperacion(int operacion, Scanner consola){
        System.out.print("Proporciona valor operando 1:");
        var operando1 = Double.parseDouble(consola.nextLine());
        System.out.print("Proporciona valor operando 2:");
        var operando2 = Double.parseDouble(consola.nextLine());
        Double resultado;
        switch (operacion) {
            case 1 -> { // suma
                resultado = operando1 + operando2;
                System.out.println("Resultado de la suma: " + resultado);
            }
            case 2 -> { // resta
                resultado = operando1 - operando2;
                System.out.println("Resultado de la Resta: " + resultado);
            }
            case 3 -> { // multiplicacion
                resultado = operando1 * operando2;
                System.out.println("Resulado de la Multiplicación: " + resultado);
            }
            case 4 -> { // Division
                resultado = operando1 / operando2;
                System.out.println("Resultado de la División: " + resultado);
            }
            default -> System.out.println("Opción es erronea: " + operacion);

        }
    }



} // fin de clase
