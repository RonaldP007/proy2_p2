/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import java.sql.*;
/**
 *
 * @author Enrique
 */
public class CRUD_DB_Eliminar {

    static Connection conn;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static String query;
    //Conexion Andres jdbc:postgresql://localhost:5432/programacion   Admin
    //Conexion Ronald
    static String jdbc = "jdbc:postgresql://localhost:5432/programacion";
    static String pass = "Admin";
    //This method delete the styles in the database
    public boolean Eliminar_Estilo_DB(int estilo) {
        boolean eliminado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "DELETE FROM estilos WHERE id_estilo = ?;";
            pst = conn.prepareStatement(query);
            pst.setInt(1, estilo);
            pst.executeUpdate();
            conn.close();
            eliminado = true;
        } catch (SQLException ex) {
            eliminado = false;
        }
        return eliminado;
    }
    //This method delete the brands in the database
    public boolean Eliminar_Marca_DB(int marca) {
        boolean eliminado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "DELETE FROM marcas WHERE id_marca = ?;";
            pst = conn.prepareStatement(query);
            pst.setInt(1, marca);
            pst.executeUpdate();
            conn.close();
            eliminado = true;
        } catch (SQLException ex) {
            eliminado = false;
        }
        return eliminado;
    }
    //This method delete the models in the database
    public boolean Eliminar_Modelo_DB(int modelo) {
        boolean eliminado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "DELETE FROM modelos WHERE id_modelo = ?;";
            pst = conn.prepareStatement(query);
            pst.setInt(1, modelo);
            pst.executeUpdate();
            conn.close();
            eliminado = true;
        } catch (SQLException ex) {
            eliminado = false;
        }
        return eliminado;
    }
    //This method delete the offices in the database
    public boolean Eliminar_Oficina_DB(int oficina) {
        boolean eliminado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "DELETE FROM oficinas WHERE id_oficina = ?;";
            pst = conn.prepareStatement(query);
            pst.setInt(1, oficina);
            pst.executeUpdate();
            conn.close();
            eliminado = true;
        } catch (SQLException ex) {
            eliminado = false;
        }
        return eliminado;
    }
    //This method delete the cars in the database
    public boolean Eliminar_Vehiculo_DB(String placa) {
        boolean eliminado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "DELETE FROM vehiculos WHERE placa = ?;";
            pst = conn.prepareStatement(query);
            pst.setString(1, placa);
            pst.executeUpdate();
            conn.close();
            eliminado = true;
        } catch (SQLException ex) {
            eliminado = false;
        }
        return eliminado;
    }
    
}
