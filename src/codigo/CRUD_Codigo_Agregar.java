/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import base_datos.CRUD_DB_Agregar;

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
    
}
