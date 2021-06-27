/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author rache
 */
public class ServCliente implements Serializable{

    public ServCliente() {
    }

    public ObjectOutputStream clientOutputStream;
    public ObjectInputStream clientInputStream;
    public Socket socketConnection;

    public void Conectar(String ip) {
        try {
            this.socketConnection = new Socket(ip, 9990);
            clientOutputStream = new ObjectOutputStream(socketConnection.getOutputStream());
            clientInputStream = new ObjectInputStream(socketConnection.getInputStream());
            System.out.println("Cliente Conectado");
        } catch (IOException ex) {
            System.out.println("conexion" + ex);
        }

    }

    public HashMap<String, Object> EnviarAccion(HashMap<String, Object> consulta) {
        try {
            clientOutputStream.writeObject(consulta);

            return (HashMap<String, Object>) this.clientInputStream.readObject();
        } catch (IOException ex) {
            System.out.println("ADIOSS" + ex);
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("MMMMMM" + ex);
            return null;
        }
    }

    public void CerrarConexion() {
        try {
            this.clientOutputStream.close();
            this.clientInputStream.close();
        } catch (IOException ex) {
            System.out.println("AAAAAAA" + ex);
        }
    }

}
