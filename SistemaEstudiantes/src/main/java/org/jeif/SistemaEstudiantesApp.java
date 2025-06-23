package org.jeif;

import org.jeif.dao.EstudianteDAO;
import org.jeif.dominio.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaEstudiantesApp {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        // Definir lista fuera del ciclo while
        List<Estudiante> estudiantes = new ArrayList<>();

        // Iniciamos el menú
        var salir = false;
        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOpcionConsola(consola , estudianteDAO);
            } catch (Exception e){
                System.out.println("Ocurrió un error: "+e.getMessage());
            }
        }
    }

    private static void mostrarMenu(){
        System.out.println("*** Sistema de Estudiantes ***");
        System.out.println("""
                1. Listar Estudiante
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                """);
        System.out.print("Ingrese la opción: ");
    }

    private static boolean ejecutarOpcionConsola(Scanner consola ,  EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 ->{
                System.out.println("Listado de Estudiantes");
//                List<Estudiante>
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);

            }
            case 2 ->{
                System.out.print("Ingreso el Id del estudiante a buscar: ");
                var idBusca = Integer.parseInt(consola.nextLine());
                var estudiante1 = new Estudiante(idBusca);//, "Jorge", "Ibarguen", "977753217", "jorge@gmail.com");
                System.out.println("Estudiante antes de la busqueda: "+estudiante1);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante1);
                if (encontrado)
                    System.out.println("Estudiante encontrado: "+estudiante1);
                else
                    System.out.println("No se encontró: "+ estudiante1.getIdEstudiante());

            }
            case 3 ->{
                System.out.print("Ingrese el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Ingrese el apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Ingrese el telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Ingrese el email: ");
                var email = consola.nextLine();

                var nuevoEstudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);
                if (agregado)
                    System.out.println("Estudiante agregado: "+nuevoEstudiante);
                else
                    System.out.println("No se agregó el estudiante: "+nuevoEstudiante);

            }
            case 4 ->{
                System.out.print("Ingreso el Id del estudiante a modificar: ");
                var idModifica = Integer.parseInt(consola.nextLine());
                var estudianteModifica = new Estudiante(idModifica);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudianteModifica);
                if (encontrado){
                    System.out.println("Estudiante encontrado: "+estudianteModifica);
                    System.out.print("Ingrese el nombre: ");
                    var nombre = consola.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    var apellido = consola.nextLine();
                    System.out.print("Ingrese el telefono: ");
                    var telefono = consola.nextLine();
                    System.out.print("Ingrese el email: ");
                    var email = consola.nextLine();

                    var estudianteModificar = new Estudiante(idModifica,nombre,apellido, telefono, email);
                    var modificado = estudianteDAO.modificarEstudiante(estudianteModificar);
                    if (modificado)
                        System.out.println("Estudiante modificado: "+ estudianteModificar);
                    else
                        System.out.println("No se pudo modificar estudiante: "+estudianteModificar);
                }

            }
            case 5 ->{
                System.out.print("Ingreso el Id del estudiante a modificar: ");
                var idEliminar = Integer.parseInt(consola.nextLine());
                var estudianteEliminiar = new Estudiante(idEliminar);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudianteEliminiar);
                if (encontrado){
                    var estudianteEliminar = new Estudiante(idEliminar);
                    var eliminado = estudianteDAO.eliminarEstudiante(estudianteEliminar);
                    if (eliminado)
                        System.out.println("Estudiante eliminado satisfactoriamente: "+estudianteEliminar);
                    else
                        System.out.println("No se eliminó el estudiante: "+estudianteEliminar);
                } else
                    System.out.println("No se encontró el Id a aliminar: "+idEliminar);

            }

            case 6 ->{
                System.out.println("Hasto pronto");
                salir = true;
            }
            default -> System.out.println("Opción incorrecta: "+opcion);
        }
        return salir;
    }

}