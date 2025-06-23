package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMNBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMNBRE_ARCHIVO);
        try {
            // Si ya existe el archivo, No se vuelve a crear
            if(archivo.exists()){
                System.out.println("El archivo ya existe!!!");
            }
            else {
                // Sino existe , se crea vacio
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (Exception e){
            System.out.println("Ocurrió un error al abrir el archivo: "+e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
    // volvemos a abrir el archivo
        var archivo = new File(NOMNBRE_ARCHIVO);
        try {
            System.out.println("Listado de Películas");
            // Abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            // Leemos todas las linea
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de termina el chiclo volvemos a leer la sigueinte linea
                linea = entrada.readLine();
            }
            // Cerrar el archivo
            entrada.close();
        } catch (Exception e){
            System.out.println("Ocurrió un error en la lectura de archivo: "+e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMNBRE_ARCHIVO);
        try {
            // Revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            // Agregamos la pelicula (toString)
            salida.println(pelicula);
            salida.close();

        } catch (Exception e){
            System.out.println();
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMNBRE_ARCHIVO);
        try {
            // Abrir el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();

            while (lineaTexto != null){
                //Buscamos sin importar mayusculas/minusculas
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                // Leemosla sigueinte linea abntes de la siguiente iteacion
                lineaTexto = entrada.readLine();
                indice++;

            } // fin del while
            // Imprimimos resultado de la busqueda
            if (encontrada)
                System.out.println("Pelicula "+lineaTexto+" encontrada en linea: "+ indice);
            else
                System.out.println("No se ha encontrado la pelicula "+pelicula.getNombre());
            entrada.close();

        } catch (Exception e){
            System.out.println("Error al buscar la pelicula: "+e.getMessage());
        }
    }
}
