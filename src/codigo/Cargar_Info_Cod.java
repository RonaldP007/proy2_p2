/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import Objetos.Vehiculo;
import base_datos.Cargar_Info_DB;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 *
 * @author Extreme pc
 */
public class Cargar_Info_Cod {
    //This method load the information in the comboboxs of models,brands and styles
    public void Cargar_Combos(JComboBox jcbMarcas, JComboBox jcbModelos, JComboBox jcbEstilos) {
        Cargar_Info_DB ci_db = new Cargar_Info_DB();
        ArrayList<String> marcas = ci_db.Info_marca_modelo_estilo("nombre_marca");
        ArrayList<String> modelos = ci_db.Info_marca_modelo_estilo("nombre_modelo");
        ArrayList<String> estilos = ci_db.Info_marca_modelo_estilo("nombre_estilo");
        for (int i = 0; i < marcas.size(); i++) {
            jcbMarcas.addItem(marcas.get(i));
        }
        for (int i = 0; i < modelos.size(); i++) {
            jcbModelos.addItem(modelos.get(i));
        }
        for (int i = 0; i < estilos.size(); i++) {
            jcbEstilos.addItem(estilos.get(i));
        }

    }
    //This method call other method and return the object vehiculo
    public Vehiculo Buscar_Vehiculo(String placa) {
        Cargar_Info_DB ci_db = new Cargar_Info_DB();
        Vehiculo vehiculo = ci_db.Vehiculo(placa);
        return vehiculo;
    }
    //This method return the String of the models, brands or styles with the identification
    public String nombre_marca_modelo_estilo(int id, String nombre) {
        Cargar_Info_DB ci_db = new Cargar_Info_DB();
        String nombres = ci_db.Info_Nombre_marca_modelo_estilo(id, nombre);
        return nombres;
    }
    //This method return the id of the models,brands and styles with the name
    public int Buscar_Id_Cod(String nombre_columna, String nombre) {
        Cargar_Info_DB ci_db = new Cargar_Info_DB();
        int id_numero = ci_db.Info_Id_marca_modelo_estilo(nombre_columna, nombre);
        return id_numero;
    }
    //This method set a text of the models, brands or styles in a text area
    public void Info_CRUD(JTextArea txtArea, String nombre) {
        Cargar_Info_DB ci_db = new Cargar_Info_DB();
        ArrayList<String[]> informacion = ci_db.Info_CRUDS("nombre_" + nombre, nombre);
        String info = "";
        for (int i = 0; i < informacion.size(); i++) {
            info += informacion.get(i)[0] + '\t' + informacion.get(i)[1] + System.lineSeparator();
        }
        txtArea.setText(info);
    }
    public void Info_CRUD_Vehiculo(JTextArea txtArea) {
        Cargar_Info_DB ci_db = new Cargar_Info_DB();
        ArrayList<Vehiculo> informacion = ci_db.Vehiculo();
        String info = "";
        for (int i = 0; i < informacion.size(); i++) {
            String transmision,estado;
            String placa = informacion.get(i).getPlaca();
            String marca = nombre_marca_modelo_estilo(informacion.get(i).getMarca(), "marca");
            String modelo = nombre_marca_modelo_estilo(informacion.get(i).getModelo(), "modelo");
            String estilo = nombre_marca_modelo_estilo(informacion.get(i).getEstilo(), "estilo");
            if(informacion.get(i).getTransmision()){
                transmision = "Automatico";
            }else{
                transmision = "Manual";
            }
            String fabricacion = String.valueOf(informacion.get(i).getFabricacion());
            String precio = String.valueOf(informacion.get(i).getPrecio_dia());
            if(informacion.get(i).getEstado()){
                estado = "Disponible";
            }else{
                estado = "Ocupado";
            }
            info += placa + '\t' + marca+'\t' + modelo+'\t' +estilo+'\t'+transmision +'\t'+
                    fabricacion+ '\t' + precio + '\t' +estado
                    + System.lineSeparator();
        }
        txtArea.setText(info);
    }
}
