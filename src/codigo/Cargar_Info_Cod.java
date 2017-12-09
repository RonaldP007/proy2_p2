/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import base_datos.Cargar_Info_DB;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Extreme pc
 */
public class Cargar_Info_Cod {

    public void Cargar_Combos(JComboBox jcbMarcas, JComboBox jcbModelos, JComboBox jcbEstilos) {
        Cargar_Info_DB ci_db = new Cargar_Info_DB();
        ArrayList<String> marcas = ci_db.Info_marca_modelo_estilo("nombre_marca");
        ArrayList<String> modelos = ci_db.Info_marca_modelo_estilo("nombre_modelo");
        ArrayList<String> estilos = ci_db.Info_marca_modelo_estilo("nombre_estilo");
        for(int i = 0; i < marcas.size(); i++){
            jcbMarcas.addItem(marcas.get(i));
        }
        for(int i = 0; i < modelos.size(); i++){
            jcbModelos.addItem(modelos.get(i));
        }
        for(int i = 0; i < estilos.size(); i++){
            jcbEstilos.addItem(estilos.get(i));
        }
        
    }
    
    
}
