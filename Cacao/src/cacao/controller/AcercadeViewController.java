/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import cacao.util.SceneAnimation;
import cacao.util.SceneManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Diana
 */
public class AcercadeViewController implements Initializable {

    @FXML
    private Label lblUni;
    @FXML
    private Label lblRed;
    @FXML
    private Label lblCacao;
    @FXML
    private Label lblProf;
    @FXML
    private Label lblInt;
    @FXML
    private Label lblDia;
    @FXML
    private Label lblRac;
    @FXML
    private Label lblHei;
    @FXML
    private Label lblAño;
    @FXML
    private Label lblIng;
    @FXML
    private ImageView IvCacao;
    @FXML
    private Button btnRegresar;
    @FXML
    private Label lblRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnClickRegresar(ActionEvent event) {
        Stage stage = null;
        SceneManager.Instance().loadContainerView(stage, "Cacao");
        SceneManager.Instance().setSlideDirection(SceneAnimation.SlideDirection.RIGHT_TO_LEFT);
        SceneManager.Instance().changeSceneTo("IpView");
    }
    
}
