/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import cacao.util.SceneAnimation;
import cacao.util.SceneManager;

/**
 * FXML Controller class
 *
 * @author jorgeElFurioso
 */
public class ContenedorController extends Controller implements Initializable {

    @FXML
    private ToolBar toolBar;
    @FXML
    private Button btnHome;
    @FXML
    private StackPane mainContainer;
    @FXML
    private BorderPane root;

    private String actualScene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.btnHome.setVisible(false);
    }

    public ToolBar getTopBar() {
        return this.toolBar;
    }

    public void setTopBar(ToolBar toolBar) {
        this.toolBar = toolBar;
    }

    @Override
    public void initialize() {

    }

    public BorderPane getRootNode() {
        return this.root;
    }

    public void setRootNode(BorderPane rootNode) {
        this.root = rootNode;
    }

    public StackPane getStackPaneContent() {
        return this.mainContainer;
    }

    public void setStackPaneContent(StackPane mainContainer) {
        this.mainContainer = mainContainer;
    }

    public String getActualScene() {
        return actualScene;
    }

    public void setActualScene(String actualScene) {
        this.actualScene = actualScene;
    }

    public void verificarElementosDeTopBar() {
        if (actualScene.equals("InicioView")) {
            btnHome.setVisible(false);
        } else {
            btnHome.setVisible(true);
            SceneAnimation.fadeIn(btnHome, 1.2).play();
        }
    }

//    @FXML
//    private void handleBtnAcerca(ActionEvent event) {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(sokoban.Sokoban.class.getResource("view/Acerca.fxml"));
//            loader.load();
//            VBox root = (VBox) loader.getRoot();
//            // loginStage.getIcons().add(new Image("restuna/resourses/general/icono-app.png"));
//            Scene scene = new Scene(root);
//  
//            Stage acercaStage = new Stage();
//            acercaStage.setScene(scene);
//            acercaStage.initOwner(this.theStage);
//            acercaStage.initModality(Modality.NONE);
//            acercaStage.initStyle(StageStyle.TRANSPARENT);
//            acercaStage.setOpacity(0.95);
//            double centerXPosition = theStage.getX() + theStage.getWidth()/2d;
//            double centerYPosition = theStage.getY() + theStage.getHeight()/2d;
//            acercaStage.setX(centerXPosition - root.getPrefWidth()/2);
//            acercaStage.setY(centerYPosition - root.getPrefHeight()/2);
//            acercaStage.focusedProperty().addListener((observable, oldValue, newValue) -> {
//                if(!newValue){
//                    acercaStage.close();
//                }
//            });
//            Animation.fadeIn(root, 1.5).play();
//            acercaStage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(InicioController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }   
    @FXML
    private void actionBtnHome(ActionEvent event) {
        if (!actualScene.equals("InicioView")) {
            System.out.println("ESCENA CAMBIADA");
            SceneManager.Instance().changeSceneTo("InicioView");
        }
    }

}
