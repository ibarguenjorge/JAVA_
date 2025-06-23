package gm.estudiantes;

import gm.estudiantes.modelo.Estudiante;
import gm.estudiantes.servicio.EstudianteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion...");
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finalizada...");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("ejecutadno metodo run de Spring..."+nl);
		Scanner consola = new Scanner(System.in);
		EstudianteServicio estudianteServicio1 = new EstudianteServicio();

		// Definir lista fuera del ciclo while
		List<Estudiante> estudiantes = new ArrayList<>();

		//Iniciar el menú
		var salir = false;
		while (!salir){
			mostrarMenu();
			try {
				salir = ejecutarOpcionConsola(consola );
			} catch (Exception e){
				System.out.println("Ocurrió un error: "+e.getMessage());
			}
		}
	}

	private boolean ejecutarOpcionConsola(Scanner consola) {
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 -> {
				logger.info(nl +"Listado de Estudiantes"+nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach(estudiante -> logger.info(estudiante.toString() +nl ));
			}
			case 2 -> {
				logger.info(nl+"Ingrese Id de estudiante a bucar: "+nl);
				var idBuscar = Integer.parseInt(consola.nextLine());
				var encontrado = estudianteServicio.buscarEstudiantePorId(idBuscar);
				if (encontrado == null){
					logger.info("No se encontró el estudiante: "+idBuscar);
				} else
					logger.info("Estudiante encontrado: "+ encontrado);
			}
			case 3 -> {
				logger.info(nl+"Agregar Estudiante"+nl);
				logger.info(nl+"Ingrese el nombre: "+nl);
				var nombre = consola.nextLine();
				logger.info("Ingrese el apellido: ");
				var apellido = consola.nextLine();
				logger.info("Ingrese el telefono: ");
				var telefono = consola.nextLine();
				logger.info("Ingrese el email: ");
				var email = consola.nextLine();

				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);

				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: "+estudiante);

			}

			case 4 -> {
				logger.info(nl+"Ingreso el Id del estudiante a modificar: "+nl);
				var idBuscar = Integer.parseInt(consola.nextLine());
				var encontrado = estudianteServicio.buscarEstudiantePorId(idBuscar);
				if (encontrado != null){
					logger.info(nl+"Estudiante encontrado: "+ encontrado);
					logger.info(nl+"Ingrese el nombre: ");
					var nombre = consola.nextLine();
					logger.info(nl+"Ingrese el apellido: ");
					var apellido = consola.nextLine();
					logger.info(nl+"Ingrese el telefono: ");
					var telefono = consola.nextLine();
					logger.info(nl+"Ingrese el email: ");
					var email = consola.nextLine();

					encontrado.setNombre(nombre);
					encontrado.setApellido(apellido);
					encontrado.setTelefono(telefono);
					encontrado.setEmail(email);

					estudianteServicio.guardarEstudiante(encontrado);
					logger.info(nl+ "Datos del Estudiante modificados correctamente");

				} else
					logger.info("No se encontró el estudiante: "+idBuscar);
			}
			case 5 -> {
				logger.info(nl+"Ingreso el Id del estudiante a modificar: ");
				var idEliminar = Integer.parseInt(consola.nextLine());
				var encontrado = estudianteServicio.buscarEstudiantePorId(idEliminar);
				if (encontrado != null){
					estudianteServicio.eliminarEstudiante(encontrado);
					logger.info(nl+"Estudiante eliminado satisfactoriamente: "+encontrado);
				} else
					logger.info("No se encontró el Id a aliminar: "+idEliminar);
			}
			case 6 -> {
				System.out.println("Hasta pronto...");
				salir = true;
			}
			default -> System.out.println("Opcion incorrecta: "+opcion);
		}
		return salir;
	}

	private void mostrarMenu() {
		logger.info(nl);
		logger.info("""
				*** Sistema de Estudiantes SPRING ***
				1. Listar Estudiante
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir
				Elija una opción:""");
	}
}
