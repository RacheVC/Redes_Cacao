/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.util;

import java.util.Date;
import java.util.List;

/**
 *
 * @author rache
 */
public class Jugador {

    private String nombre;
    private String color;
    private Date fechaNacimineto;
    private int cacaos;
    private int monedas;
    private int puntos;
    private int posicionJugador;
    private List<Ficha> FichasJugador;

    public Jugador(String nombre, String color, Date fechaNacimineto, int cacaos, int monedas, int puntos, int posicionJugador, List<Ficha> FichasJugador) {
        this.nombre = nombre;
        this.color = color;
        this.fechaNacimineto = fechaNacimineto;
        this.cacaos = cacaos;
        this.monedas = monedas;
        this.puntos = puntos;
        this.posicionJugador = posicionJugador;
        this.FichasJugador = FichasJugador;
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

    public Date getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(Date fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
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

    public List<Ficha> getLosetasRecolectores() {
        return FichasJugador;
    }

    public void setLosetasRecolectores(List<Ficha> FichasJugador) {
        this.FichasJugador = FichasJugador;
    }

}
