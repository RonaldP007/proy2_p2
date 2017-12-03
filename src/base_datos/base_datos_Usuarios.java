/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_datos;

import Objetos.usuarios;
import java.io.FileInputStream;
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
public class base_datos_Usuarios {

    static Connection conn;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static String query;
    static String jdbc = "jdbc:postgresql://localhost:5432/programacion";
    // pass Andres
    // static String pass = "Admin";
    //pass Ronald
     static String pass = "RPG007rpg";

    public boolean Guardar_Usuario_db(int cedula, String nombre, int telefono, String direccion, FileInputStream fis, int longitudBytes, String contraseña) {
        boolean se_guardo = false;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "INSERT INTO usuarios VALUES (?,?,?,?,?,?,?);";
            pst = conn.prepareStatement(query);
            pst.setInt(1, cedula);
            pst.setString(2, nombre);
            pst.setInt(3, telefono);
            pst.setString(4, direccion);
            pst.setBinaryStream(5, fis, longitudBytes);
            pst.setString(6, contraseña);
            pst.setBoolean(7, false);
            pst.executeUpdate();
            conn.close();
            se_guardo = true;
        } catch (SQLException ex) {
            se_guardo = false;
        }
        return se_guardo;
    }

    public ArrayList<usuarios> Buscar_Usuario_DB(int cedula) {
        ArrayList<usuarios> informacion_usuario = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT u.cedula, u.nombre, u.telefono, u.direccion, u.foto_usuario, u.contraseña, u.tipo FROM usuarios as u where cedula = " + cedula + ";";

            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                usuarios usuario = new usuarios( rs.getString("nombre"),
                    rs.getInt("cedula"),
                    rs.getInt("telefono"),
                    rs.getBinaryStream("foto_usuario"),
                    rs.getString("direccion"),
                    rs.getString("contraseña"),
                    rs.getBoolean("tipo"));

                informacion_usuario.add(usuario);
            }
            conn.close();
        } catch (SQLException ex) {
            informacion_usuario = null;
            ex.printStackTrace();
        }
        return informacion_usuario;
    }   
}

