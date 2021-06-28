/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.util;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 *
 * @author rache
 */
public class Jugador implements Serializable {

    private String nombre;
    private String color;
    private LocalDate fechaNacimineto;
    private int cacaos;
    private int monedas;
    private int puntos;
    private int posicionJugador;
    private List<Ficha> FichasJugador;
    private Period Edad;

    public Jugador() {
    }

    public Jugador(String nombre, String color, LocalDate fechaNacimineto, Period Edad) {
        this.nombre = nombre;
        this.color = color;
        this.fechaNacimineto = fechaNacimineto;
        this.Edad = Edad;
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

    public LocalDate getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(LocalDate fechaNacimineto) {
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

    public Period getEdad() {
        return Edad;
    }

    public void setEdad(Period Edad) {
        this.Edad = Edad;
    }

  

}
