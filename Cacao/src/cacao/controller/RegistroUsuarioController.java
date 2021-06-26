/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author rache
 */
public class RegistroUsuarioController extends Controller implements Initializable {

    @FXML
    private JFXTextField TxtNombreUsuario;
    @FXML
    private JFXDatePicker DpFechaNacimiento;
    @FXML
    private JFXButton BtnGuardar;
    @FXML
    private ComboBox<String> CbxColores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Se le asigna elementos al ComboBox.
        ObservableList listaColores = FXCollections.observableArrayList();
        listaColores.add("Rojo");
        listaColores.add("Blanco");
        listaColores.add("Morado");
        listaColores.add("Amarillo");
        listaColores.add("Rosado");
        listaColores.add("Verde claro");
        listaColores.add("Negro");
        listaColores.add("Café");
        listaColores.add("Celeste");
        listaColores.add("Azul");
        listaColores.add("Anaranjado");
        listaColores.add("Verde oliva");
        listaColores.add("Turquesa intenso");
        listaColores.add("Borgoña");
        listaColores.add("Salmón");
        listaColores.add("Beige");
        listaColores.add("Lila");
        listaColores.add("Mostaza");
        listaColores.add("Verde lima");
        listaColores.add("Fucsia");
        CbxColores.setItems(listaColores);
    }

    @Override
    public void initialize() {

    }

    @FXML
    private void OnClickCbxColores(ActionEvent event) {
    }

    @FXML
    private void OnClickDpFechaNacimeinto(ActionEvent event) {
    }

    @FXML
    private void OnClickBtnGuardar(ActionEvent event) {
    }

}
