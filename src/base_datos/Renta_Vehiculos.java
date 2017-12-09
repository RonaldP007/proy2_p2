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
    
    public ResultSet visualizar(){
        

        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT placa,transmision,year,precio,foto FROM vehiculos WHERE estado = true ORDER BY placa";
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        }catch(Exception ex){
            System.out.println("Error de consulta");
        }
        return rs;
    }
}
