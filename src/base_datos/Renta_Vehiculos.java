/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import Objetos.usuarios;
import static base_datos.base_datos_Usuarios.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public ResultSet visualizar() {

        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT v.placa,ma.nombre_marca,mod.nombre_modelo,est.nombre_estilo,v.transmision,year,v.precio,v.foto FROM vehiculos AS v"
                   + " INNER JOIN marcas AS ma ON v.fk_modelo = ma.id_marca" +" INNER JOIN modelos AS mod ON v.fk_modelo = mod.id_modelo" 
                    +" INNER JOIN estilos AS est ON v.fk_estilo = est.id_estilo"+" WHERE v.estado = true ORDER BY v.placa";
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception ex) {
            System.out.println("Error de consulta");
        }
        return rs;
    }

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

}
