package org.example.persistencia;

import org.example.modelo.Libro;

import java.sql.*;
import java.util.ArrayList;

public class DemoLibro2 {

    public DemoLibro2() {
    }
    public void insertaeStatement(){
        String elTitulo = "El Principito";
        String elAutor = "Antoine de Saint-Exupéry";
        try{
            Statement stm = ConexionSingleton.get_instance("libros2.db").getConnection().createStatement();

            String sqlInsert = "INSERT INTO libros2(titulo,autor) VALUES('" + elTitulo + "' , '" + elAutor + "')";
            int rowCount = stm.executeUpdate(sqlInsert);
            System.out.println("Se insertaron " + rowCount + " registros");
        }catch (SQLException sqle){
            System.out.println("Error al conectar" + sqle.getMessage());
        }


    }
    public void insertarPreparedStatement(){
        String elTitulo = "Harry Potter: La piedra filosofal";
        String elAutor = "J. K. Rowling";
        String sqlInsert = "INSERT INTO libros2(titulo,autor) VALUES(?,?)";
        try{
            PreparedStatement pstm = ConexionSingleton.get_instance("libros2.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1, elTitulo);
            pstm.setString(2, elAutor);
            int rowCount = pstm.executeUpdate();
        }catch (SQLException sqle){
            System.out.println("Error Prepared statement " + sqle.getMessage());
        }


    }

    public boolean insertarLibro (Libro libro){
            String sqlInsert = "INSERT INTO libros2(titulo,autor) VALUES(?,?)";
            int rowCount = 0;
        try{
            PreparedStatement pstm = ConexionSingleton.get_instance("libros2.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1, libro.getTitulo());
            pstm.setString(2, libro.getAutor());
            rowCount = pstm.executeUpdate();
            System.out.println("Se insertaron " + rowCount + " registros");

        }catch (SQLException sqle){
            System.out.println("Error Prepared Statement " + sqle.getMessage());
        }
        return rowCount > 0;
    }

    public Libro buscarLibroPorId(int id){
        String sql = "SELECT * FROM libros2 WHERE id = ? ;";
        Libro libro = null;
        try{
            PreparedStatement pstm = ConexionSingleton.get_instance("libros2.db").getConnection().prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rst = pstm.executeQuery();
            if(rst.next()){
                libro = new Libro(rst.getInt(1), rst.getString(3),rst.getString(2));
            }
        }catch (SQLException sqlException){
            System.out.println("Error al buscar");
        }
        return libro;
    }

    public ArrayList<Libro> obtenerTodos(){
        String sql = "SELECT * FROM libros2";
        ArrayList<Libro> resultado = new ArrayList<>();
        try{
            Statement stm = ConexionSingleton.get_instance("libros2.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Libro(rst.getInt(1), rst.getString(2), rst.getString(3)));
            }

        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }


}
