package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;
    // Al estar como final se debe agregar el constructor
    // se está aplicando el PATRON DE DISEÑO SERVICE
    // la interfaz no permite crear objetois
    // se crean objetos en la clase que implementa la interface
    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }



    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: "+pelicula);

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Regresa el indice de la la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1)
            System.out.println("No se encontró la película "+pelicula);
        else
            System.out.println("Pelicula encontrada en el índice: "+indice);
    }

    public static void main(String[] args) {
        // creamos objetos tipo leicula
        var pelicula1 = new Pelicula("Batman");
        var pelicula2 = new Pelicula("Superman");
        // Creamos el servicio (patron de sieño service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        // Agregamos las peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        // Listamos las peliculas
        servicioPeliculas.listarPeliculas();
        // Buscamos una pelicula
        // Se debe implementar el metodo equal y hascode
        servicioPeliculas.buscarPelicula(new Pelicula("Alien"));
    }
}
