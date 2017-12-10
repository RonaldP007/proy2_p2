/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import Objetos.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Extreme pc
 */
public class Cargar_Info_DB {

    static Connection conn;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static String query;
    //Conexion Andres jdbc:postgresql://localhost:5432/programacion   Admin
    //Conexion Ronald
    static String jdbc = "jdbc:postgresql://localhost:5432/programacion";
    static String pass = "Admin";

    public ArrayList<String> Info_marca_modelo_estilo(String nombre_columna) {
        ArrayList<String> info = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT " + nombre_columna + " FROM " + (nombre_columna.replace("nombre_", "")) + 's' + ";";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                info.add(rs.getString(nombre_columna));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

    public int Info_Id_marca_modelo_estilo(String nombre_columna, String nombre) {
        int id = 0;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT " + "id_" + nombre_columna + " FROM " + nombre_columna + 's' + " WHERE"
                    + " nombre_" + nombre_columna + " = '" + nombre + "';";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            id = rs.getInt("id_" + nombre_columna);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /*
    SELECT ve.placa,ma.nombre_marca,mo.nombre_modelo,es.nombre_estilo,ve.transmision,ve.fabricacion,ve.precio,ve.foto,ve.estado FROM vehiculos AS ve INNER JOIN marcas AS ma 
    ON ma.id_marca = ve.fk_marca INNER JOIN modelos AS mo ON mo.id_modelo = ve.fk_modelo INNER JOIN estilos AS es ON es.id_estilo = ve.fk_estilo WHERE placa = '?';
     */
    public Vehiculo Vehiculo(String placa) {
        Vehiculo vehiculo;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT ve.placa,ma.id_marca,mo.id_modelo,es.id_estilo,ve.transmision,ve.fabricacion,ve.precio,ve.foto,ve.estado FROM vehiculos AS ve INNER JOIN marcas AS ma "
                    + "ON ma.id_marca = ve.fk_marca INNER JOIN modelos AS mo ON mo.id_modelo = ve.fk_modelo INNER JOIN estilos AS es ON es.id_estilo = ve.fk_estilo WHERE placa = '" + placa + "';";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            vehiculo = new Vehiculo(rs.getString("placa"), rs.getInt("id_marca"),
                    rs.getInt("id_modelo"), rs.getInt("id_estilo"), rs.getBoolean("transmision"),
                    rs.getInt("fabricacion"), rs.getInt("precio"), 0, null,
                    rs.getBinaryStream("foto"), rs.getBoolean("estado"));
            conn.close();
        } catch (SQLException e) {
            vehiculo = null;
            e.printStackTrace();
        }
        return vehiculo;
    }

    public String Info_Nombre_marca_modelo_estilo(int id, String nombre) {
        String nombre_tipo;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT nombre_" + nombre + " FROM " + nombre + 's' + " WHERE id_" + nombre + " = " + id + ";";
            st = conn.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            nombre_tipo = rs.getString("nombre_"+nombre);
            conn.close();
        } catch (SQLException e) {
            nombre_tipo = "";
            e.printStackTrace();
        }
        return nombre_tipo;
    }
}
