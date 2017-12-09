/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import Objetos.Vehiculo;
import base_datos.CRUD_DB_Agregar;
import base_datos.Cargar_Info_DB;
import java.io.FileInputStream;

/**
 *
 * @author Enrique
 */
public class CRUD_Codigo_Agregar {

    public boolean Agregar_Estilo_Cod(String estilo) {
        CRUD_DB_Agregar crud_db = new CRUD_DB_Agregar();
        boolean agregado = crud_db.Agregar_Estilo_DB(estilo);
        return agregado;
    }

    public boolean Agregar_Marca_Cod(String marca) {
        CRUD_DB_Agregar crud_db = new CRUD_DB_Agregar();
        boolean agregado = crud_db.Agregar_Marca_DB(marca);
        return agregado;
    }

    public boolean Agregar_Modelo_Cod(String modelo) {
        CRUD_DB_Agregar crud_db = new CRUD_DB_Agregar();
        boolean agregado = crud_db.Agregar_Modelo_DB(modelo);
        return agregado;
    }

    public boolean Agregar_Oficina_Cod(String oficina) {
        CRUD_DB_Agregar crud_db = new CRUD_DB_Agregar();
        boolean agregado = crud_db.Agregar_Oficina_DB(oficina);
        return agregado;
    }

    public boolean Agregar_Vehiculo_Cod(String placa, String marca, String modelo,
            String estilo, boolean transmision, String fabricacion, String precio_dia,
            int longitudBytes, FileInputStream fis, boolean estado) {
        Cargar_Info_DB ci_db = new Cargar_Info_DB();
        int  id_marca = ci_db.Info_Id_marca_modelo_estilo("marca", marca);
        int  id_modelo = ci_db.Info_Id_marca_modelo_estilo("modelo", modelo);
        int  id_estilo = ci_db.Info_Id_marca_modelo_estilo("estilo", estilo);

        Vehiculo vehiculo = new Vehiculo(placa, id_marca, id_modelo, id_estilo, transmision,
                Integer.parseInt(fabricacion), Integer.parseInt(precio_dia),
                longitudBytes, fis, null, estado);
        CRUD_DB_Agregar crud_db = new CRUD_DB_Agregar();
        boolean agregado = crud_db.Agregar_Vehiculo_DB(vehiculo);
        return agregado;
    }

}
