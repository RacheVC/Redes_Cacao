/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rache
 */
public class Servidor {
   
    
    public void  ConectarServidor(){
        Thread HiloConexion;
        HiloConexion = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket socketConnection = new ServerSocket(9990);
                    
                    while (true) {
                        //va un if que evalue cuantos clientes maximo
                        Socket cliente = socketConnection.accept();
                        Thread hiloCliente = new Thread(new Runnable() {
                               ObjectInputStream serverInputStream;
                               ObjectOutputStream serverOutputStream;
                            @Override
                            public void run() {
                                try {
                                    HashMap<String, Object> consulta = new HashMap<String, Object>();
                                 
                                    serverInputStream = new ObjectInputStream(cliente.getInputStream());
                                    serverOutputStream = new ObjectOutputStream(cliente.getOutputStream());
                                    while(true){
                                        consulta = (HashMap<String, Object>) serverInputStream.readObject();                                    
                                        if (consulta.get("Accion").equals("Registro")) {
                                            System.out.println("REGISTRO");
                                        }else if(consulta.get("Accion").equals("Salir")){
                                            break;
                                        }
                                            this.EnviarObjeto(consulta);
                                    }
                                    serverInputStream.close();
                                    serverOutputStream.close();
                                } catch (IOException | ClassNotFoundException ex) {
                                    System.out.println("HOLAA"  + ex);
                                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                             public void EnviarObjeto(HashMap<String, Object> consulta){
                                   try {
                                       serverOutputStream.writeObject(consulta);
                                       serverOutputStream.flush();
                                   } catch (IOException ex) {
                                       System.out.println("WRITEEE" + ex);
                                       Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                                   }
                             }
                        });
                        hiloCliente.start();
                        
                        break;
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        });
        HiloConexion.start();
    }
}
