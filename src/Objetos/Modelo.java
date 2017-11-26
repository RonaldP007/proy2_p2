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
public class Modelo {
    int identificador;
    String modelo;
    
    public Modelo(int identificador,String modelo){
        this.identificador = identificador;
        this.modelo = modelo;
    }
    public int getIdentificador(){
        return identificador;
    }
    public String getModelo(){
        return modelo;
    }
    public void setIdentificador(int identificador){
        this.identificador = identificador;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
}
