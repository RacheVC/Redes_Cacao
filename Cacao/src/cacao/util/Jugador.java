/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.util;

import java.util.List;

/**
 *
 * @author rache
 */
public class Jugador {
    
    private String nombre;
    private String fechaNacimineto;
    private String color;
    private int cacaos;
    private int monedas;
    private int puntos;
    private List<Ficha> FichasJugador;
    private int posicionJugador;

    public Jugador(String nombre, String fechaNacimineto, String color, int cacaos, int monedas, int puntos, int posicionJugador) {
        this.nombre = nombre;
        this.fechaNacimineto = fechaNacimineto;
        this.color = color;
        this.cacaos = cacaos;
        this.monedas = monedas;
        this.puntos = puntos;
        this.posicionJugador = posicionJugador;
    }

     public String getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(String fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCacaos() {
        return cacaos;
    }

    public void setCacaos(int cacaos) {
        this.cacaos = cacaos;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(int posicionJugador) {
        this.posicionJugador = posicionJugador;
    }
    
    

}
