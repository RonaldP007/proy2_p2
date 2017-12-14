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
public class Reportes_DB {

    static Connection conn;
    static PreparedStatement pst;
    static Statement st;
    static ResultSet rs;
    static String query;
    //Conexion Andres jdbc:postgresql://localhost:5432/programacion   Admin
    //Conexion Ronald
    static String jdbc = "jdbc:postgresql://localhost:5432/programacion";
    static String pass = "Admin";

    public ArrayList<Object[]> rep1(Date inicio, Date fin) {
        java.sql.Date Date1 = new java.sql.Date(inicio.getTime());
        java.sql.Date Date2 = new java.sql.Date(fin.getTime());
        ArrayList<Object[]> info = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT fk_placa, fk_cedula_usu, nombre_usu, fecha_ret, fecha_dev FROM alquiler_vehiculo"
                    + " WHERE fecha_ret BETWEEN '" + Date1 + "' and '" + Date2 + "' ;";
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] info_estudiante = new Object[]{rs.getString("fk_placa"),
                    rs.getInt("fk_cedula_usu"),
                    rs.getString("nombre_usu"),
                    rs.getDate("fecha_ret"),
                    rs.getDate("fecha_dev"),};
                info.add(info_estudiante);
            }
            conn.close();
        } catch (SQLException ex) {
            info = null;
            ex.printStackTrace();
        }
        return info;
    }

    public ArrayList<Object[]> rep2(boolean estado) {
        ArrayList<Object[]> info = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT ve.placa,ma.nombre_marca,mo.nombre_modelo,es.nombre_estilo FROM vehiculos AS ve "
                    + "INNER JOIN marcas AS ma ON ma.id_marca = ve.fk_marca INNER JOIN modelos AS mo ON mo.id_modelo = ve.fk_modelo "
                    + "INNER JOIN estilos AS es ON es.id_estilo = ve.fk_estilo WHERE ve.estado = " + estado + " ;";
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] info_estudiante = new Object[]{rs.getString("placa"),
                    rs.getString("nombre_marca"),
                    rs.getString("nombre_modelo"),
                    rs.getString("nombre_estilo"),};
                info.add(info_estudiante);
            }
            conn.close();
        } catch (SQLException ex) {
            info = null;
            ex.printStackTrace();
        }
        return info;
    }

    public ArrayList<Object[]> rep3() {
        ArrayList<Object[]> info = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "SELECT u.cedula,u.nombre,u.telefono,u.direccion,u.foto_usuario,v.placa,v.foto,ma.nombre_marca,mo.nombre_modelo,es.nombre_estilo,v.transmision,v.fabricacion,v.precio \n"
                    + "FROM alquiler_vehiculo AS al \n"
                    + "INNER JOIN usuarios AS u ON u.cedula = al.fk_cedula_usu\n"
                    + "INNER JOIN vehiculos AS v ON v.placa = al.fk_placa\n"
                    + "INNER JOIN marcas AS ma ON ma.id_marca = v.fk_marca \n"
                    + "INNER JOIN modelos AS mo ON mo.id_modelo = v.fk_modelo\n"
                    + "INNER JOIN estilos AS es ON es.id_estilo = v.fk_estilo \n"
                    + "WHERE v.estado = false ;";
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] info_estudiante = new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getBinaryStream(5),
                    rs.getString(6),
                    rs.getBinaryStream(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getBoolean(11),
                    rs.getInt(12),
                    rs.getInt(13),};
                info.add(info_estudiante);
            }
            conn.close();
        } catch (SQLException ex) {
            info = null;
            ex.printStackTrace();
        }
        return info;
    }
}
