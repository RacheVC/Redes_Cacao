/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.util;

import java.util.List;

/**
 *
 * @author Heilen
 */
public class Partida {

    private List<Jugador> jugador;
    private String turno;
    private String ganador;

    public Partida() {
    }

    public Partida(List<Jugador> jugador, String turno, String ganador) {
        this.jugador = jugador;
        this.turno = turno;
        this.ganador = ganador;
    }

    public void setJugador(List<Jugador> jugador) {
        this.jugador = jugador;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public List<Jugador> getJugador() {
        return jugador;
    }

    public String getTurno() {
        return turno;
    }

    public String getGanador() {
        return ganador;
    }

}
