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
    private List<Ficha> FichasTrabajador;
    private List<Ficha> FichasSelva;
    private int turno;
    private String ganador;

    public Partida() {
    }

    public Partida(List<Jugador> jugador, List<Ficha> FichasTrabajador, List<Ficha> FichasSelva, int turno, String ganador) {
        this.jugador = jugador;
        this.FichasTrabajador = FichasTrabajador;
        this.FichasSelva = FichasSelva;
        this.turno = turno;
        this.ganador = ganador;
    }

    public void setJugador(List<Jugador> jugador) {
        this.jugador = jugador;
    }

    public void setFichaT(List<Ficha> FichasTrabajador) {
        this.FichasTrabajador = FichasTrabajador;
    }

    public void setFichaS(List<Ficha> FichasSelva) {
        this.FichasSelva = FichasSelva;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public List<Jugador> getJugador() {
        return jugador;
    }

    public List<Ficha> getFichaT() {
        return FichasTrabajador;
    }

    public List<Ficha> getFichaS() {
        return FichasSelva;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getGanador() {
        return ganador;
    }

    public void CreacionFichasTrabajadoresTipo1() {
        Jugador jugadorFichas = new Jugador();
        //Creación de las Fichas -> 1-1-1-1 (4)
        for (int i = 0; i < 4; i++) {
            String color = (String) AppContext.getInstance().get("Color");
            Ficha Trabajador = new Ficha("Trabajador", color, 1, 1, 1, 1);
            this.FichasTrabajador.add(Trabajador);
        }
        jugadorFichas.setLosetasRecolectores(FichasTrabajador);
    }

    public void CreacionFichasTrabajadoresTipo2() {
        Jugador jugadorFichas = new Jugador();
        //Creación de las Fichas -> 2-1-0-1 (5)
        for (int i = 0; i < 5; i++) {
            String color = (String) AppContext.getInstance().get("Color");
            Ficha Trabajador = new Ficha("Trabajador", color, 2, 1, 0, 1);
            this.FichasTrabajador.add(Trabajador);
        }
        jugadorFichas.setLosetasRecolectores(FichasTrabajador);
    }

    public void CreacionFichasTrabajadoresTipo3() {
        Jugador jugadorFichas = new Jugador();
        //Creación de la Ficha -> 3-0-0-1 (1)
        String color = (String) AppContext.getInstance().get("Color");
        Ficha Trabajador = new Ficha("Trabajador", color, 3, 0, 0, 1);
        this.FichasTrabajador.add(Trabajador);
        jugadorFichas.setLosetasRecolectores(FichasTrabajador);
    }

    public void CreacionFichasTrabajadoresTipo4() {
        Jugador jugadorFichas = new Jugador();
        //Creación de la Ficha -> 3-1-0-0 (1)
        String color = (String) AppContext.getInstance().get("Color");
        Ficha Trabajador = new Ficha("Trabajador", color, 3, 1, 0, 0);
        this.FichasTrabajador.add(Trabajador);
        jugadorFichas.setLosetasRecolectores(FichasTrabajador);
    }

    public void RemoverFichasTrabajadores(int cantidadJugadores) {
        Jugador jugadorFichas = new Jugador();
        if (cantidadJugadores == 3) {
            jugadorFichas.getLosetasRecolectores().remove(0);
        }
    }

}
