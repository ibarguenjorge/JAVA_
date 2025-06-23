package org.jeif.dao;

import org.jeif.dominio.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.jeif.conexion.Conexion.getConexion;

public class EstudianteDAO {
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante order by id_estudiante";
        try {
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var estudiante = new Estudiante(0);
                estudiante.setIdEstudiante(rs.getInt("id_estudiante"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            System.out.println("Ocurrión un error al seleccionar datos: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Ocurrió un error al cerrar conexión: "+e.getMessage());
            }
        }
        return estudiantes;
    }
    // find by Id
    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet   rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM estudiante WHERE id_estudiante = ?" ;
        try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, estudiante.getIdEstudiante());
           rs = ps.executeQuery();
           if (rs.next()){
               estudiante.setNombre(rs.getString("nombre"));
               estudiante.setApellido(rs.getString("apellido"));
               estudiante.setTelefono(rs.getString("telefono"));
               estudiante.setEmail(rs.getString("email"));
               return true;
           }
        } catch (Exception e){
            System.out.println("Ocurrió un error al buscr estudiante: "+e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar conexión: "+e.getMessage());
            }

        }
        return false;
    }

    public boolean agregarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO estudiante(nombre, apellido, telefono, email) " +
                "VALUES (?, ?, ?, ? )";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al agregar estudiante: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conexión: "+e.getMessage());
            }
        }
        return false;
    }

    public boolean modificarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE estudiante SET nombre = ? , apellido = ?" +
                ", telefono = ? , email = ? WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;

        } catch (Exception e){
            System.out.println("Error al modificar estudiante: " +e.getMessage());

        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar conexión: "+e.getMessage());
            }
        }
        return false;

    }
    public boolean eliminarEstudiante(Estudiante estudiante){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM estudiante WHERE id_estudiante = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e){
            System.out.println("Error al eliminar el estudiante: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar conexión: "+e.getMessage());
            }

        }
        return false;

    }

    public static void main(String[] args) {
        var estudianteDao = new EstudianteDAO();

        // Modificamos un estudiante existente(5)
//        var estudianteModificar = new Estudiante(5,"Jorge","Ibargüen",
//                "977753217","jorgejorge@gmail.com");
//        var modificado = estudianteDao.modificarEstudiante(estudianteModificar);
//        if (modificado)
//            System.out.println("Estudiante modificado: "+ estudianteModificar);
//        else
//            System.out.println("No se pudo modificar estudiante: "+estudianteModificar);

        // Agregar estudiante
//        var nuevoEstudiante = new Estudiante("Jorge ERicson","Ibarguen","555555554","jjjjjjjjjj@gmail.com");
//        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
//        if (agregado)
//            System.out.println("Estudiante agregado: "+nuevoEstudiante);
//        else
//            System.out.println("No se agregó el estudiante: "+nuevoEstudiante);

        // Eliminar estudiante 6
        var estudianteEliminar = new Estudiante(4);
        var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
        if (eliminado)
            System.out.println("Estudiante eliminado satisfactoriamente: "+estudianteEliminar);
        else
            System.out.println("No se eliminó el estudiante: "+estudianteEliminar);


        //Listar los estudiantes
        System.out.println("Listado de Estudiantes");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);

        // Buscar por Id
        var estudiante1 = new Estudiante(7, "Jorge", "Ibarguen", "977753217", "jorge@gmail.com");
        System.out.println("Estudiante antes de la busqueda: "+estudiante1);
        var encontrado = estudianteDao.buscarEstudiantePorId(estudiante1);
        if (encontrado)
            System.out.println("Estudiante encontrado: "+estudiante1);
        else
            System.out.println("No se encontró: "+estudiante1.getIdEstudiante());

    }

}
