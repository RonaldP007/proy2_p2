/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import Objetos.Vehiculo;
import base_datos.CRUD_DB_Modificar;

/**
 *
 * @author Enrique
 */
public class CRUD_Codigo_Modificar {

    //This method send the brand for another method and return a boolean if it is modified
    public boolean Modificar_Marca_Cod(String cod_marca, String nuevo_nombre) {
        CRUD_DB_Modificar crud_dbm = new CRUD_DB_Modificar();
        boolean modificado = crud_dbm.Modificar_Marca_DB(Integer.parseInt(cod_marca), nuevo_nombre);
        return modificado;
    }

    //This method send the model for another method and return a boolean if it is modified
    public boolean Modificar_Modelo_Cod(String cod_modelo, String nuevo_nombre) {
        CRUD_DB_Modificar crud_dbm = new CRUD_DB_Modificar();
        boolean modificado = crud_dbm.Modificar_Modelo_DB(Integer.parseInt(cod_modelo), nuevo_nombre);
        return modificado;
    }

    //This method send the office for another method and return a boolean if it is modified
    public boolean Modificar_Oficina_Cod(String cod_oficina, String nuevo_nombre) {
        CRUD_DB_Modificar crud_dbm = new CRUD_DB_Modificar();
        boolean modificado = crud_dbm.Modificar_Oficina_DB(Integer.parseInt(cod_oficina), nuevo_nombre);
        return modificado;
    }

    //This method send the style for another method and return a boolean if it is modified
    public boolean Modificar_Estilo_Cod(String cod_estilo, String nuevo_nombre) {
        CRUD_DB_Modificar crud_dbm = new CRUD_DB_Modificar();
        boolean modificado = crud_dbm.Modificar_Estilo_DB(Integer.parseInt(cod_estilo), nuevo_nombre);
        return modificado;
    }

    //This method send the car for another method and return a boolean if it is modified and the image is modified
    public boolean Modificar_Vehiculo_Foto_Mod(Vehiculo vehiculo) {
        CRUD_DB_Modificar crud_db_mod = new CRUD_DB_Modificar();
        boolean modificado = crud_db_mod.Modificar_Vehiculo_Foto(vehiculo);
        return modificado;
    }

    //This method send the car for another method and return a boolean if it is modified and the image is not modified
    public boolean Modificar_Vehiculo_Sin_Foto_Mod(Vehiculo vehiculo) {
        CRUD_DB_Modificar crud_db_mod = new CRUD_DB_Modificar();
        boolean modificado = crud_db_mod.Modificar_Vehiculo_Sin_Foto(vehiculo);
        return modificado;
    }
    
    //This method send the car plate for another method and return a boolean
    public boolean Modificar_Vehiculo_Estado(String placa){
       CRUD_DB_Modificar crud_db_mod = new CRUD_DB_Modificar();
       boolean modificado = crud_db_mod.Modificar_Vehiculo_Estado(placa);
       return modificado;    
    }

}
