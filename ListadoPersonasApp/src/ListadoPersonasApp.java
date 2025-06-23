import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        // Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        // Empezamos el menú
        var salir = false;
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: "+e.getMessage());
            }
            System.out.println();
        }
    }



    private static void mostrarMenu(){
        System.out.println("""
               **** Lista Personas App
               1. Agregar
               2. Listar
               3. Salir
                """);
        System.out.print("Proporciona la opción:");


    }

    private static boolean ejecutarOperacion(Scanner consola , List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opcion proporcionada
        switch (opcion){
            case 1 -> { // Agergar persona a la lista
                System.out.print("Proporciona el nombre:");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el telefono:");
                var tel = consola.nextLine();
                System.out.print("Proporciona el email:");
                var email = consola.nextLine();
                // Crear el objeto Persona
                var persona = new Persona(nombre , tel , email);
                // Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size()+" elementos...");
            }  // fin caso 1

            case 2 -> {
                System.out.println("Listado de Personas");
                // Mejora usango Lambda y metodo de referencia
//                personas.forEach((persona) -> System.out.println(persona));
                 personas.forEach(System.out::println );
            } // fin del caso 2
            case 3 ->{ // Salir del ciclo
                System.out.println("Hasto pronto");
                salir = true;
            } // fin del case 3
            default -> System.out.println("Opción erronea: "+opcion);
        } // fin del switch
        return salir;
    }
}