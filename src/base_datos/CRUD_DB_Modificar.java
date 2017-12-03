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

    public boolean Modificar_Marca_DB(int cod_marca, String nuevo_nombre) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE marcas(id_marca,nombre_marca) SET nombre_marca = ? WHERE id_marca = ?";
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

    public boolean Modificar_Modelo_DB(int cod_modelo, String nuevo_nombre) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE modelos(id_modelo,nombre_modelo) SET nombre_modelo = ? WHERE id_modelo = ?";
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

    public boolean Modificar_Oficina_DB(int cod_oficina, String nuevo_nombre) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE oficinas(id_oficina,nombre_oficina) SET nombre_oficina = ? WHERE id_oficina = ?";
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

    public boolean Modificar_Estilo_DB(int cod_estilo, String nuevo_nombre) {
        boolean modificado;
        try {
            conn = DriverManager.getConnection(jdbc, "postgres", pass);
            query = "UPDATE estilos(id_estilo,nombre_estilo) SET nombre_estilo = ? WHERE id_estilo = ?";
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

}
