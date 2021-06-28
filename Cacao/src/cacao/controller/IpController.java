/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import cacao.util.AppContext;
import cacao.util.SceneManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rache
 */
public class IpController extends Controller implements Initializable {

    @FXML
    private TextField txtIpServidor;
    @FXML
    private Button BtnEntrar;

    @FXML
    private Button BtnConectarServidor;
    ServCliente servidorCliente;
    Servidor servidor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.servidorCliente = new ServCliente();
        this.servidor = new Servidor();
    }

    @Override
    public void initialize() {

    }

    @FXML
    private void OnClickEntrar(ActionEvent event) {
        String IpServidor = this.txtIpServidor.getText();
        this.servidorCliente.Conectar(IpServidor);
        AppContext.getInstance().set("ServidorCliente", this.servidorCliente);
        SceneManager.Instance().changeSceneTo("RegistroUsuarioView");

    }

    @FXML
    private void OnClickBtnConectar(ActionEvent event) {
        this.servidor.ConectarServidor();
    }

}
