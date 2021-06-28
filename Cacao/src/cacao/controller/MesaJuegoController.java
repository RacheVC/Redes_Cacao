/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import cacao.util.AppContext;
import cacao.util.Partida;
import cacao.util.SceneManager;
import cacao.util.Tablero;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author rache
 */
public class MesaJuegoController extends Controller implements Initializable {

    @FXML
    private GridPane MatrizGrafica;

    private int MatrizLogica[][] = new int[12][12];

    @FXML
    private Button BtnSalir;
    ServCliente Servidor;
    @FXML
    private Label lbl_turnoJugador;
    @FXML
    private Label lbl_jugador1;
    @FXML
    private Label lbl_cacaos1;
    @FXML
    private Label lbl_monedas1;
    @FXML
    private Label lbl_soles1;
    @FXML
    private Label lbl_aguas1;
    @FXML
    private Label lbl_jugador2;
    @FXML
    private Label lbl_cacaos2;
    @FXML
    private Label lbl_monedas2;
    @FXML
    private Label lbl_soles2;
    @FXML
    private Label lbl_aguas2;
    @FXML
    private Label lbl_jugador3;
    @FXML
    private Label lbl_cacaos3;
    @FXML
    private Label lbl_monedas3;
    @FXML
    private Label lbl_soles3;
    @FXML
    private Label lbl_aguas3;
    @FXML
    private Label lbl_jugador4;
    @FXML
    private Label lbl_cacaos4;
    @FXML
    private Label lbl_monedas4;
    @FXML
    private Label lbl_soles4;
    @FXML
    private Label lbl_aguas4;
    @FXML
    private ImageView img_losetasSelvaReverso;
    @FXML
    private ImageView img_losetaSelva1;
    @FXML
    private ImageView img_losetaSelva2;
    @FXML
    private ImageView img_losetasRecolectoresReverso;
    @FXML
    private ImageView img_losetaRecolectores1;
    @FXML
    private ImageView img_losetaRecolectores2;
    @FXML
    private ImageView img_losetaRecolectores3;
    @FXML
    private ImageView img_tableroJugador;
    Partida partidaIniciada;
    int turno;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cargarMatrizGrafica();
        this.Servidor = (ServCliente) AppContext.getInstance().get("ServidorCliente");
            //this.AsignarTurnos();    
           // this.MostrarTurnos();
        this.partidaIniciada = new Partida();
        this.turno = 0;

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

    public void cargarMatrizGrafica() {
        Tablero tablero = new Tablero(this.MatrizLogica);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                //  this.MatrizGrafica.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                // creamos un panel y seteamos el Id de este con los indices de la matriz
                Pane newPane = new Pane();

                newPane.setId(String.valueOf(i) + String.valueOf(j));
                newPane.setPrefSize(100, 100);
                if (i == 6 && j == 6) {
                    this.cargarImagenPanel(newPane, System.getProperty("user.dir") + "\\src\\cacao\\resources\\Materiales para el juego Cacao\\Losetas de selva\\Minas\\Mina 2-Valor 1.png");
                }
                if (i == 5 && j == 5) {
                    this.cargarImagenPanel(newPane, System.getProperty("user.dir") + "\\src\\cacao\\resources\\Materiales para el juego Cacao\\Losetas de selva\\Plantanciones\\Plantación simple 1.png");
                }// cargamos la imagen al panel creado
                // agregamos el panel a la matriz grafica
                this.MatrizGrafica.add(newPane, i, j);
                this.MatrizLogica[i][j] = 1;

            }
        }
    }
    

    public void AsignarTurnos() {
        HashMap<String, Object> consulta = new HashMap<>();
        consulta.put("Accion", "Turnos");
        this.Servidor.EnviarAccion(consulta);
    }

    public void MostrarTurnos() {
        if (this.partidaIniciada.getTurno() == 0) {
            this.lbl_turnoJugador.setText(this.partidaIniciada.getJugador().get(0).getNombre());
           // this.lbl_jugador1.setText(value);
        }
        if (this.partidaIniciada.getTurno() == 1) {
            this.lbl_turnoJugador.setText(this.partidaIniciada.getJugador().get(1).getNombre());
        }
        if (this.partidaIniciada.getTurno() == 2) {
            this.lbl_turnoJugador.setText(this.partidaIniciada.getJugador().get(2).getNombre());
        }
        if (this.partidaIniciada.getTurno() == 3) {
            this.lbl_turnoJugador.setText(this.partidaIniciada.getJugador().get(3).getNombre());
        }

    }

    @FXML
    private void OnActionBtnSalir(ActionEvent event) {
        HashMap<String, Object> consulta = new HashMap<>();
        consulta.put("Accion", "Salir");
        this.Servidor.EnviarAccion(consulta);
        this.Servidor.CerrarConexion();
        SceneManager.Instance().changeSceneTo("IpView");

    }

}
