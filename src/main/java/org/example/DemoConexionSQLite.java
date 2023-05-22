package org.example;

import java.sql.*;

import org.sqlite.JDBC;

public class DemoConexionSQLite {
    public static void main(String[] args) {
        String DB_URL = "jdbc:sqlite:libros2.db";
        Connection conexion = null;

        try{
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(DB_URL);
            Statement stm = conexion.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM libros2; ");
            while (rst.next()){
                System.out.println(rst.getString(1) + "" + rst.getString(2));
            }
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }
}
