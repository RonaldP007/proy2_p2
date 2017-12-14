/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import base_datos.Renta_Vehiculos;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author Ronald
 */
public class Rentas_Veh {
    //This method insert information to a combobox with the license plate
    public void Info_placas_Combo(JComboBox combo1) {
        Renta_Vehiculos inf = new Renta_Vehiculos();
        ArrayList<String> datos = inf.Info_placas();
        for (int i = 0; i < datos.size(); i++) {
            combo1.addItem(datos.get(i));
        }
    }
    //This method insert information to a combobox with the offices
    public void Info_Oficinas_Combo(JComboBox combo4) {
        Renta_Vehiculos inf = new Renta_Vehiculos();
        ArrayList<String> datos_a = inf.Info_Oficinas();
        ArrayList<String> datos_b = new ArrayList();
        for (int i = 0; i < datos_a.size(); i += 2) {
            datos_b.add(datos_a.get(i) + "," + datos_a.get(i + 1));
        }
        for (int i = 0; i < datos_b.size(); i++) {
            combo4.addItem(datos_b.get(i));
        }
    }
    //This method search the price of the car with the license plate
    public int precio_vehic(String placa) {
        Renta_Vehiculos inf = new Renta_Vehiculos();
        ArrayList<Integer> precio_lista = inf.precio_vehiculo(placa);
        int precio = precio_lista.get(0);

        return precio;
    }
    //this method sends the information of the car and the person to another method to be rented
    public boolean guardar_rentas(String placa, int cedula, String nombre, int oficina_dev, int oficina_ret, Date fecha_dev, Date fecha_ret, int precio, String hora_dev, String hora_ret) {
        Renta_Vehiculos inf = new Renta_Vehiculos();
        boolean se_guardo = inf.Agregar_Renta_Veh(placa, cedula, nombre, oficina_dev, oficina_ret, fecha_dev, fecha_ret, precio, hora_dev, hora_ret);

        return se_guardo;
    }
}
