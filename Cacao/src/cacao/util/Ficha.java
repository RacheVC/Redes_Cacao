/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.util;

/**
 *
 * @author Heilen
 */
public class Ficha {

    private String tipo;
    private String color;
    private int posicionD;
    private int posicionAB;
    private int posicionI;
    private int posicionAR;

    public Ficha() {
    }

    public Ficha(String tipo, String color, int posicionD, int posicionAB, int posicionI, int posicionAR) {
        this.tipo = tipo;
        this.color = color;
        this.posicionD = posicionD;
        this.posicionAB = posicionAB;
        this.posicionI = posicionI;
        this.posicionAR = posicionAR;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPosicionD(int posicionD) {
        this.posicionD = posicionD;
    }

    public void setPosicionAB(int posicionAB) {
        this.posicionAB = posicionAB;
    }

    public void setPosicionI(int posicionI) {
        this.posicionI = posicionI;
    }

    public void setPosicionAR(int posicionAR) {
        this.posicionAR = posicionAR;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }

    public int getPosicionD() {
        return posicionD;
    }

    public int getPosicionAB() {
        return posicionAB;
    }

    public int getPosicionI() {
        return posicionI;
    }

    public int getPosicionAR() {
        return posicionAR;
    }
}
