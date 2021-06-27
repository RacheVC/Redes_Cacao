/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.controller;

import cacao.util.AppContext;
import cacao.util.Jugador;
import cacao.util.SceneManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;

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
    String ColorLoseta = "";
    LocalDate date;
    ServCliente Servidor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.Servidor = (ServCliente) AppContext.getInstance().get("ServidorCliente");
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
        if (this.DpFechaNacimiento.getValue() != null && this.CbxColores.getValue() != null && !" ".equals(this.TxtNombreUsuario.getText())) {         
          Jugador  jugador = new Jugador(this.TxtNombreUsuario.getText(), this.CbxColores.getValue(), this.DpFechaNacimiento.getValue()); 
          //AppContext.getInstance().set("Fecha Nacimiento", this.DpFechaNacimiento.getValue());
          //AppContext.getInstance().set("Color", this.CbxColores.getValue());
          //AppContext.getInstance().set("Nombre", this.TxtNombreUsuario.getText());
          HashMap<String, Object> consulta = new HashMap<>();
          consulta.put("Accion", "Registro");
          consulta.put("Jugador", jugador);
          this.Servidor.EnviarAccion(consulta);
          SceneManager.Instance().changeSceneTo("MesaJuegoView");
          
        }if(this.DpFechaNacimiento.getValue() == null){
              JOptionPane.showMessageDialog(null, "Falta por completar la Fecha de Nacimiento", "Información Faltante", JOptionPane.WARNING_MESSAGE);
            
        }if(this.CbxColores.getValue() == null){
            JOptionPane.showMessageDialog(null, "No Escogio un Color", "Información Faltante", JOptionPane.WARNING_MESSAGE);
        }if(this.TxtNombreUsuario.equals(" ")){
            JOptionPane.showMessageDialog(null, "Falta por completar el espacio Nombre", "Información Faltante", JOptionPane.WARNING_MESSAGE);
        }
    }

}
