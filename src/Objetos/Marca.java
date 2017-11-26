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
public class Marca {
    int identificador;
    String marca;
    
    public Marca(int identificador,String marca){
        this.identificador = identificador;
        this.marca = marca;
    }
    public int getIdentificador(){
        return identificador;
    }
    public String getMarca(){
        return marca;
    }
    public void setIdentificador(int identificador){
        this.identificador = identificador;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
}
