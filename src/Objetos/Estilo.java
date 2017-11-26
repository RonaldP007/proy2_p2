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
public class Estilo {

    int identificador;
    String estilo;

    public Estilo(int identificador, String estilo) {
        this.identificador = identificador;
        this.estilo = estilo;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
