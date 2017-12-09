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
public class CRUD_DB_Agregar {

    static Connection conn;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static String query;
    //Conexion Andres jdbc:postgresql://localhost:5432/programacion   Admin
    //Conexion Ronald
    static String jdbc = "jdbc:postgresql://localhost:5432/programacion";
    static String pass = "Admin";
    
    public boolean Agregar_Estilo_DB(String estilo) {
        boolean se_guardo;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "INSERT INTO estilos(nombre_estilo) VALUES (?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, estilo);
            pst.executeUpdate();
            conn.close();
            se_guardo = true;
        } catch (SQLException ex) {
            se_guardo = false;
        }
        return se_guardo;
    }

    public boolean Agregar_Marca_DB(String marca) {
        boolean se_guardo;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "INSERT INTO marcas(nombre_marca) VALUES (?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, marca);
            pst.executeUpdate();
            conn.close();
            se_guardo = true;
        } catch (SQLException ex) {
            se_guardo = false;
        }
        return se_guardo;
    }

    public boolean Agregar_Modelo_DB(String modelo) {
        boolean se_guardo;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "INSERT INTO modelos(nombre_modelo) VALUES (?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, modelo);
            pst.executeUpdate();
            conn.close();
            se_guardo = true;
        } catch (SQLException ex) {
            se_guardo = false;
        }
        return se_guardo;
    }

    public boolean Agregar_Oficina_DB(String oficina) {
        boolean se_guardo;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "INSERT INTO oficinas(nombre_oficina) VALUES (?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, oficina);
            pst.executeUpdate();
            conn.close();
            se_guardo = true;
        } catch (SQLException ex) {
            se_guardo = false;
        }
        return se_guardo;
    }

    public boolean Agregar_Vehiculo_DB(Vehiculo vehiculo) {
        boolean se_guardo;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "INSERT INTO vehiculos VALUES (?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, vehiculo.getPlaca());
            pst.setInt(2,vehiculo.getMarca());
            pst.setInt(3,vehiculo.getModelo());
            pst.setInt(4,vehiculo.getEstilo());
            pst.setBoolean(5, vehiculo.getTransmision());
            pst.setInt(6, vehiculo.getFabricacion());
            pst.setInt(7,vehiculo.getPrecio_dia());
            pst.setBinaryStream(8, vehiculo.getFis(), vehiculo.getBytes());
            pst.setBoolean(9,vehiculo.getEstado());
            pst.executeUpdate();
            conn.close();
            se_guardo = true;
        } catch (SQLException ex) {
            se_guardo = false;
        }
        return se_guardo;
    }
    
}
