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

    public String getPlaca() {
        return placa;
    }

    public int getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public int getEstilo() {
        return estilo;
    }

    public boolean getTransmision() {
        return transmision;
    }

    public int getFabricacion() {
        return fabricacion;
    }

    public int getPrecio_dia() {
        return precio_dia;
    }

    public boolean getEstado() {
        return estado;
    }

    public InputStream getFoto() {
        return foto;
    }

    public int getBytes() {
        return longitudBytes;
    }

    public FileInputStream getFis() {
        return fis;
    }
    
    public void setBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public void setTransmision(boolean transmision) {
        this.transmision = transmision;
    }

    public void setFabricacion(int fabricacion) {
        this.fabricacion = fabricacion;
    }

    public void setPrecio_dia(int precio_dia) {
        this.precio_dia = precio_dia;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
