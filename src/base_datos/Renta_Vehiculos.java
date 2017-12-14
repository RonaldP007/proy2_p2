/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ronald
 */
public class Renta_Vehiculos {

    static Connection conn;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static String query;
    static String jdbc = "jdbc:postgresql://localhost:5432/programacion";
    static String pass = "RPG007rpg";
    //This methods return the cars information of the database
    public ResultSet visualizar(String sql) {

        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
          
        }
        return rs;
    }
    //This method return the license plate of the database where car is available
    public ArrayList<String> Info_placas() {
        ArrayList<String> info = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT placa FROM vehiculos WHERE estado = true ORDER BY placa";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                info.add(rs.getString("placa"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }
    //This method return a arraylist of the offices
    public ArrayList<String> Info_Oficinas() {
        ArrayList<String> info = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT id_oficina,nombre_oficina FROM oficinas ORDER BY id_oficina";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
               info.add(String.valueOf(rs.getInt("id_oficina")));
               info.add(rs.getString("nombre_oficina"));
                
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }
    //This method return a arraylist prices of the car
     public ArrayList<Integer> precio_vehiculo(String placa) {
        ArrayList<Integer> precio = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT precio FROM vehiculos WHERE placa = '" + placa + "'";
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
               precio.add(rs.getInt("precio"));
                
            }
            conn.close();
            
        } catch (Exception ex) {
            System.out.println("Error de consulta");
        }
        return precio;
    }
     //This method add the rent in the database and return a boolean if it was possible to rent
     public boolean Agregar_Renta_Veh(String placa,int cedula,String nombre,int oficina_dev,int oficina_ret,Date fecha_dev,Date fecha_ret,int precio,String hora_dev,String hora_ret){
        boolean se_guardo;
        java.sql.Date Date1 = new java.sql.Date(fecha_ret.getTime());
        java.sql.Date Date2 = new java.sql.Date(fecha_dev.getTime());
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "INSERT INTO alquiler_vehiculo(fk_placa,fk_cedula_usu,nombre_usu,fk_oficina_ret,fk_oficina_dev,fecha_ret,fecha_dev,precio,hora_ret,hora_dev) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(query);
            pst.setString(1, placa);
            pst.setInt(2, cedula);
            pst.setString(3, nombre);
            pst.setInt(4, oficina_dev);
            pst.setInt(5, oficina_ret);
            pst.setDate(6, Date1);
            pst.setDate(7,  Date2);
            pst.setInt(8, precio);
            pst.setString(9, hora_dev);
            pst.setString(10, hora_ret);
            pst.executeUpdate();
            conn.close();
            se_guardo = true;
        } catch (SQLException ex) {
            se_guardo = false;
        }
        return se_guardo;
    }
     

}
