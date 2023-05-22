package org.example.persistencia;

import org.example.modelo.Libro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroDAO implements InterfazDAO{
    public LibroDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO libros2(titulo,autor) VALUES(?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("libros2.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Libro)obj).getTitulo());
        pstm.setString(2, ((Libro)obj).getAutor());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE libros2 SET titulo = ?, autor = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("libros2.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Libro)obj).getTitulo());
        pstm.setString(2, ((Libro)obj).getAutor());
        pstm.setInt(3, ((Libro)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM libros2 WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("libros2.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();


        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM libros2";
        ArrayList<Libro> resultado = new ArrayList<>();

            Statement stm = ConexionSingleton.get_instance("libros2.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Libro(rst.getInt(1), rst.getString(2), rst.getString(3)));
            }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM libros2 WHERE id = ? ;";
        Libro libro = null;
        try{
            PreparedStatement pstm = ConexionSingleton.get_instance("libros2.db").getConnection().prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if(rst.next()){
                libro = new Libro(rst.getInt(1), rst.getString(3),rst.getString(2));
            }
        }catch (SQLException sqlException){
            System.out.println("Error al buscar");
        }
        return libro;
    }
}
