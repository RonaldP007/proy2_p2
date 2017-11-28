/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import base_datos.CRUD_DB_Eliminar;

/**
 *
 * @author Enrique
 */
public class CRUD_Codigo_Eliminar {

    public boolean Eliminar_Estilo_Cod(String estilo) {
        CRUD_DB_Eliminar crud_dbe = new CRUD_DB_Eliminar();
        boolean eliminado = crud_dbe.Eliminar_Estilo_DB(Integer.parseInt(estilo));
        return eliminado;
    }

    public boolean Eliminar_Marca_Cod(String marca) {
        CRUD_DB_Eliminar crud_dbe = new CRUD_DB_Eliminar();
        boolean eliminado = crud_dbe.Eliminar_Marca_DB(Integer.parseInt(marca));
        return eliminado;
    }

    public boolean Eliminar_Modelo_Cod(String modelo) {
        CRUD_DB_Eliminar crud_dbe = new CRUD_DB_Eliminar();
        boolean eliminado = crud_dbe.Eliminar_Modelo_DB(Integer.parseInt(modelo));
        return eliminado;
    }

    public boolean Eliminar_Oficina_Cod(String oficina) {
        CRUD_DB_Eliminar crud_dbe = new CRUD_DB_Eliminar();
        boolean eliminado = crud_dbe.Eliminar_Oficina_DB(Integer.parseInt(oficina));
        return eliminado;
    }
    
}
