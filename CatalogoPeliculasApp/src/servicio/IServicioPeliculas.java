package servicio;
// Interfaz no contiene la definicion de los metodos

import dominio.Pelicula;

public interface IServicioPeliculas {
    // se agregan los nombres o firmas de los metodos
    // PATRON DE DISEÑO SERVICE
    // 1. PRIMERO SE DEFINE LA INTERFAZE
    // 2. LA IMPLEMENTACION EN OTRA CLASE (ServicioPeliculasLista)

    public void listarPeliculas();

    public void agregarPelicula(Pelicula pelicula);

    public void buscarPelicula(Pelicula pelicula);


}
