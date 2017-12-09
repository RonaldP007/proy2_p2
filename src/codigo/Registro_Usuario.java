/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import Objetos.usuarios;
import base_datos.base_datos_Usuarios;
import java.io.FileInputStream;

/**
 *
 * @author Ronald
 */
public class Registro_Usuario {

  
    public boolean Guardar_Usuario(int cedula, String nombre, int telefono, String direccion, FileInputStream fis, int longitudBytes, String contraseña) {
        boolean guardado;
        MD5 md5 = new MD5();
        base_datos_Usuarios ae_db = new base_datos_Usuarios();
        guardado = ae_db.Guardar_Usuario_db(cedula, nombre, telefono, direccion, fis, longitudBytes, md5.Clave_MD5(contraseña));
        return guardado;
    }

    public usuarios Cargar_Usuario(int cedula) {

        base_datos_Usuarios ae_db = new base_datos_Usuarios();
        usuarios informacion_usuario = ae_db.Buscar_Usuario_DB(cedula);
        return informacion_usuario;
    }
    
    public usuarios Verificar_Usuario(String cedula){
        usuarios usuario = Cargar_Usuario(Integer.parseInt(cedula));
        return usuario;
    }
    
    public boolean Tipo_Usuario(usuarios usuario,String clave){
        MD5 md5 = new MD5();
        boolean tipo;
        tipo = (md5.Clave_MD5(clave).equals(usuario.getContraseña())) && usuario.getTipo() == true;
        return tipo;
    }
}
