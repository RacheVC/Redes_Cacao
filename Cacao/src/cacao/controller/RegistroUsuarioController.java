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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rache
 */
public class RegistroUsuarioController extends Controller implements Initializable {

    @FXML
    private TextField TxtNombreUsuario;
    @FXML
    private DatePicker DpFechaNacimiento;
    @FXML
    private Button BtnGuardar;
    @FXML
    private ComboBox<String> CbxColores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
       
    }

    @FXML
    private void OnClickDpFechaNacimeinto(ActionEvent event) {
    }

    @FXML
    private void OnClickBtnGuardar(ActionEvent event) {
    }

    @FXML
    private void OnClickCbxColores(ActionEvent event) {
    }
    
}
