/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import cacao.util.AppContext;
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

    ServCliente Servidor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.btnHome.setVisible(false);
        this.Servidor = (ServCliente) AppContext.getInstance().get("ServidorCliente");

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
        if (actualScene.equals("IpView")) {
            btnHome.setVisible(false);
        } else {
            btnHome.setVisible(true);
            SceneAnimation.fadeIn(btnHome, 1.2).play();
        }
    }

    @FXML
    private void actionBtnHome(ActionEvent event) {
        if (!actualScene.equals("IpView")) {
            System.out.println("ESCENA CAMBIADA");
            SceneManager.Instance().changeSceneTo("AcercadeView");
        }
    }

}
