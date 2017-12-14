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
 * @author Ronald
 */
public class usuarios {

    String nombre, direccion, contraseña;
    int cedula, telefono, longitudBytes;
    FileInputStream fis;
    InputStream foto;
    boolean tipo;
    //This constructor receives elements and save like a object
    public usuarios( int cedula,String nombre, int telefono, InputStream foto, String direccion, String contraseña, boolean tipo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.foto = foto;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }
    //This method return a String called nombre
    public String getNombre() {
        return nombre;
    }
    //This method change String called nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //This method return a integer called cedula
    public int getCedula() {
        return cedula;
    }
    //This method change integer called cedula
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    //This method return a integer called telefono
    public int getTelefono() {
        return telefono;
    }
    //This method change integer called telefono
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    //This method return a InputStream called foto
    public InputStream getFoto() {
        return foto;
    }
    //This method change bytes called longitudBytes
    public void setBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }
    //This method change the FileInputStream called Fis
    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }
    //This method return a string called direccion
    public String getDireccion() {
        return direccion;
    }
    //This method change the string called direccion
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //This method return a string called contraseña
    public String getContraseña() {
        return contraseña;
    }
    //This method change the string called contraseña
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    //This methods return a boolean called tipo
    public boolean getTipo() {
        return tipo;
    }
    //This method change the boolean called tipo
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

}
