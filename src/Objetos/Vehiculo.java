/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Enrique
 */
public class Vehiculo {

    String placa, marca;
    int modelo, estilo, fabricacion, precio_dia;
    boolean transmision, estado;
    //FOTO

    public Vehiculo(String placa, String marca, int modelo, int estilo, boolean transmision,
            int fabricacion, int precio_dia, boolean estado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.estilo = estilo;
        this.transmision = transmision;
        this.fabricacion = fabricacion;
        this.precio_dia = precio_dia;
        //FOTO
        this.estado = estado;
        
    }
    public String getPlaca(){
        return placa;
    }
    public String getMarca(){
        return marca;
    }
    public int getModelo(){
        return modelo;
    }
    public int getEstilo(){
        return estilo;
    }
    public boolean getTransmision(){
        return transmision;
    }
    public int getFabricacion(){
        return fabricacion;
    }
    public int getPrecio_dia(){
        return precio_dia;
    }
    //FOTO
    public boolean getEstado(){
        return estado;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModelo(int modelo){
        this.modelo = modelo;
    }
    public void setEstilo(int estilo){
        this.estilo = estilo;
    }
    public void setTransmision(boolean transmision){
        this.transmision = transmision;
    }
    public void setFabricacion(int fabricacion){
        this.fabricacion = fabricacion;
    }
    public void setPrecio_dia(int precio_dia){
        this.precio_dia = precio_dia;
    }
    //FOTO
    
    public void setEstado(boolean estado){
        this.estado = estado;
    }
}
