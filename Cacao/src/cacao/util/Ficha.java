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

    private int posicion;
    private String tipo;
    private String color;

    public Ficha() {
    }

    public Ficha(int posicion, String tipo, String color) {
        this.posicion = posicion;
        this.tipo = tipo;
        this.color = color;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getColor() {
        return color;
    }
}
