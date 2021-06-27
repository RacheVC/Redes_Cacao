/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import cacao.util.Tablero;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rache
 */
public class MesaJuegoController extends Controller implements Initializable {

    @FXML
    private GridPane MatrizGrafica;
    private int MatrizLogica[][] = new int[12][12];
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cargarMatrizGrafica();
        
        // TODO
    }    

    @Override
    public void initialize() {
     
    }
    
    public void cargarImagenPanel(Pane panel, String path) {
        try {
            // inicializamos la imagen con ruta enviada por parametro
            // y ancho y alto del panel enviado por parametro
            Image image = new Image(new FileInputStream(path), panel.getMaxWidth(), panel.getPrefHeight(), false, true);
            ImageView imageView = new ImageView(image);

            // bindeamos tamaño de imagenes al panel
            imageView.fitHeightProperty().bind(panel.heightProperty());
            imageView.fitWidthProperty().bind(panel.widthProperty());
            imageView.relocate(0, 0);

            // agregamos la imagen al panel
            panel.getChildren().add(imageView);

            // remover el ultimo objeto en el panel
            // panel.getChildren().remove(panel.getChildren().size() - 1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MesaJuegoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void cargarMatrizGrafica(){
   Tablero tablero = new Tablero(this.MatrizLogica);
       for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
               //  this.MatrizGrafica.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                // creamos un panel y seteamos el Id de este con los indices de la matriz
                Pane newPane = new Pane();
                
                newPane.setId(String.valueOf(i) + String.valueOf(j));
                newPane.setPrefSize(100, 100);
                if(i == 6 && j==6)  {
                   this.cargarImagenPanel(newPane, System.getProperty("user.dir") + "\\src\\cacao\\resources\\ImagenFija1.png"); 
                }
                if(i == 5 && j==5){
                   this.cargarImagenPanel(newPane, System.getProperty("user.dir") + "\\src\\cacao\\resources\\MinaFija.png"); 
                }// cargamos la imagen al panel creado
                
                // agregamos el panel a la matriz grafica
                this.MatrizGrafica.add(newPane, i, j);
                this.MatrizLogica[i][j] = 1;

            }
        }
   }
    
}
