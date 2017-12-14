/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author Enrique
 */
public class Vehiculo {

    String placa;
    int modelo, estilo, marca;
    int fabricacion, precio_dia;
    boolean transmision, estado;
    FileInputStream fis;
    InputStream foto;
    int longitudBytes;
    //This constructor receives elements and save like a object
    public Vehiculo(String placa, int marca, int modelo, int estilo, boolean transmision,
            int fabricacion, int precio_dia, int longitudBytes, FileInputStream fis, InputStream foto, boolean estado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.estilo = estilo;
        this.fis = fis;
        this.foto = foto;
        this.transmision = transmision;
        this.fabricacion = fabricacion;
        this.precio_dia = precio_dia;
        this.longitudBytes = longitudBytes;
        this.estado = estado;

    }
    //This method return a String called placa
    public String getPlaca() {
        return placa;
    }
    //This method returns a integer called marca 
    public int getMarca() {
        return marca;
    }
    //This method return a integer called modelo
    public int getModelo() {
        return modelo;
    }
    //This method return a integer called modelo
    public int getEstilo() {
        return estilo;
    }
    //This method return a boolean called transmision
    public boolean getTransmision() {
        return transmision;
    }
    //This method return a integer called fabricacion
    public int getFabricacion() {
        return fabricacion;
    }
    //This method return a integer called precio_dia
    public int getPrecio_dia() {
        return precio_dia;
    }
    //This method return a boolean called estado
    public boolean getEstado() {
        return estado;
    }
    //This method return a num binary called foto
    public InputStream getFoto() {
        return foto;
    }
    //This method return a boolean called transmision
    public int getBytes() {
        return longitudBytes;
    }
    //This method return a boolean called transmision
    public FileInputStream getFis() {
        return fis;
    }
    //This method change a bytes of the image
    public void setBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }
    //This method change a direction in stream of the image
    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }
    //This method change the placa string
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    //This method change the marca integer
    public void setMarca(int marca) {
        this.marca = marca;
    }
    //This method change the modelo integer
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    //This method change the estilo integer
    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }
    //This method change the transmision boolean
    public void setTransmision(boolean transmision) {
        this.transmision = transmision;
    }
    //This method change the fabricacion integer
    public void setFabricacion(int fabricacion) {
        this.fabricacion = fabricacion;
    }
    //This method change the precio_dia integer
    public void setPrecio_dia(int precio_dia) {
        this.precio_dia = precio_dia;
    }
    //This method change the estado boolean
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
