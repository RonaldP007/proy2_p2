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
/*
    public usuarios( int cedula,String nombre, int telefono, FileInputStream fis, int longitudBytes, String direccion, String contraseña, boolean tipo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fis = fis;
        this.longitudBytes = longitudBytes;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }
*/
    public usuarios( int cedula,String nombre, int telefono, InputStream foto, String direccion, String contraseña, boolean tipo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.foto = foto;
        this.direccion = direccion;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setBytes(int longitudBytes) {
        this.longitudBytes = longitudBytes;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean getTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

}
