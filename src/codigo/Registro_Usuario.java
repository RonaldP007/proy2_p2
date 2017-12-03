/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import Objetos.usuarios;
import base_datos.base_datos_Usuarios;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 *
 * @author Ronald
 */
public class Registro_Usuario {

  
    public boolean Guardar_Usuario(int cedula, String nombre, int telefono, String direccion, FileInputStream fis, int longitudBytes, String contraseña) {

        boolean guardado;
        base_datos_Usuarios ae_db = new base_datos_Usuarios();
        guardado = ae_db.Guardar_Usuario_db(cedula, nombre, telefono, direccion, fis, longitudBytes, contraseña);

        return guardado;
    }

    public ArrayList<usuarios> Cargar_Usuario(int cedula) {

        base_datos_Usuarios ae_db = new base_datos_Usuarios();
        ArrayList<usuarios> informacion_usuario = ae_db.Buscar_Usuario_DB(cedula);
        return informacion_usuario;
    }
}
