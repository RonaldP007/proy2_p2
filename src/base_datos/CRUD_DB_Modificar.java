/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import Objetos.Vehiculo;
import java.sql.*;

/**
 *
 * @author Enrique
 */
public class CRUD_DB_Modificar {

    static Connection conn;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static String query;
    //Conexion Andres jdbc:postgresql://localhost:5432/programacion   Admin
    //Conexion Ronald
    static String jdbc = "jdbc:postgresql://localhost:5432/programacion";
    static String pass = "Admin";
    //This method modify the brands in the database
    public boolean Modificar_Marca_DB(int cod_marca, String nuevo_nombre) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE marcas SET nombre_marca = ? WHERE id_marca = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, nuevo_nombre);
            pst.setInt(2, cod_marca);
            pst.executeUpdate();
            conn.close();
            modificado = true;
        } catch (SQLException ex) {
            modificado = false;
        }
        return modificado;
    }
    //This method modify the models in the database
    public boolean Modificar_Modelo_DB(int cod_modelo, String nuevo_nombre) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE modelos SET nombre_modelo = ? WHERE id_modelo = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, nuevo_nombre);
            pst.setInt(2, cod_modelo);
            pst.executeUpdate();
            conn.close();
            modificado = true;
        } catch (SQLException ex) {
            modificado = false;
        }
        return modificado;
    }
    //This method modify the offices in the database
    public boolean Modificar_Oficina_DB(int cod_oficina, String nuevo_nombre) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE oficinas SET nombre_oficina = ? WHERE id_oficina = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, nuevo_nombre);
            pst.setInt(2, cod_oficina);
            pst.executeUpdate();
            conn.close();
            modificado = true;
        } catch (SQLException ex) {
            modificado = false;
        }
        return modificado;
    }
    //This method modify the styles in the database
    public boolean Modificar_Estilo_DB(int cod_estilo, String nuevo_nombre) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE estilos SET nombre_estilo = ? WHERE id_estilo = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, nuevo_nombre);
            pst.setInt(2, cod_estilo);
            pst.executeUpdate();
            conn.close();
            modificado = true;
        } catch (SQLException ex) {
            modificado = false;
        }
        return modificado;
    }
    //This method modify the cars in the database if change the image
    public boolean Modificar_Vehiculo_Foto(Vehiculo vehiculo) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE vehiculos SET fk_marca = ?,fk_modelo = ?,fk_estilo = ?,transmision = ?,fabricacion = ?,precio = ?,foto = ?,estado = ? WHERE placa = '"+vehiculo.getPlaca()+"';";
            pst = conn.prepareStatement(query);
            pst.setInt(1, vehiculo.getMarca());
            pst.setInt(2, vehiculo.getModelo());
            pst.setInt(3, vehiculo.getEstilo());
            pst.setBoolean(4, vehiculo.getTransmision());
            pst.setInt(5, vehiculo.getFabricacion());
            pst.setInt(6, vehiculo.getPrecio_dia());
            pst.setBinaryStream(7,vehiculo.getFis(),vehiculo.getBytes());
            pst.setBoolean(8, vehiculo.getEstado());
            pst.executeUpdate();
            conn.close();
            modificado = true;
        } catch (SQLException ex) {
            modificado = false;
        }
        return modificado;
    }
    //This method modify the cars in the database if not change the image
    public boolean Modificar_Vehiculo_Sin_Foto(Vehiculo vehiculo) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE vehiculos SET fk_marca = ?,fk_modelo = ?,fk_estilo = ?,transmision = ?,fabricacion = ?,precio = ?,estado = ? WHERE placa = '"+vehiculo.getPlaca()+"';";
            pst = conn.prepareStatement(query);
            pst.setInt(1, vehiculo.getMarca());
            pst.setInt(2, vehiculo.getModelo());
            pst.setInt(3, vehiculo.getEstilo());
            pst.setBoolean(4, vehiculo.getTransmision());
            pst.setInt(5, vehiculo.getFabricacion());
            pst.setInt(6, vehiculo.getPrecio_dia());
            pst.setBoolean(7, vehiculo.getEstado());
            pst.executeUpdate();
            conn.close();
            modificado = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            modificado = false;
        }
        return modificado;
    }
    
     //This method modify the cars state in the database
     public boolean Modificar_Vehiculo_Estado(String placa) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE vehiculos SET estado = false WHERE placa = '"+placa+"';";
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            conn.close();
            modificado = true;
        } catch (SQLException ex) {
            modificado = false;
        }
        return modificado;
    }

}
