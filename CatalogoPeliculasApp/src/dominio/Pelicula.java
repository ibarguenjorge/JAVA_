package dominio;

import java.util.Objects;

public class Pelicula {
    private String nombre;

    public Pelicula(){}

    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
//        return "Pelicula{" +
//                "nombre='" + nombre + '\'' +
//                '}';
        return this.nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    public static void main(String[] args) {
        var pelicula1 = new Pelicula("batman");
        var pelicula2 = new Pelicula("superman");
        System.out.println("Se agrego: "+pelicula1);
        System.out.println("Se agrego: "+pelicula2);
    }
}
