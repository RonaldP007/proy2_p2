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
public class Oficina {
    int identificador;
    String oficina;

    public Oficina(int identificador, String oficina) {
        this.identificador = identificador;
        this.oficina = oficina;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getOficina() {
        return oficina;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setEstilo(String oficina) {
        this.oficina = oficina;
    }
}
