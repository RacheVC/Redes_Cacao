/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;
import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class Cliente {
    private Socket sCliente;
    private Scanner entrada;
    private PrintStream salida;
    private String host; //IP del servidor con el que me voy a conectar
    private int puerto;
    private String mensaje="";
    public Cliente(String h, int p){
        host=h;
        puerto=p;
    }
    public void iniciar(){
        try{
            //Estableciendo conexion con el servidor
            sCliente =new Socket(host,puerto);
            System.out.println("CONEXION INICIADA");
            System.out.println("Conectado a : "+ sCliente.getRemoteSocketAddress());
            //Obtengo una referencia a los flujos de datos de entrada y salida
            salida=new PrintStream(sCliente.getOutputStream());
            entrada=new Scanner(sCliente.getInputStream());
            //Este bloque de código se encarga de enviar mensajes al servidor hasta que
            //este introduzca la palabra “bye”
            Scanner lectura=new Scanner(System.in);
            while (!mensaje.equals("fin")){
                System.out.print("\nDigite mensaje :");
                mensaje=lectura.next();
                salida.println(mensaje);
                System.out.print(entrada.next());
            }
            finalizar();
        }
        catch(Exception e){
            e.printStackTrace();
            finalizar();
        }
    }
    
    public void finalizar(){
        try{
            salida.close();
            entrada.close();
            sCliente.close();}
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
