/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao;

import cacao.controller.Cliente;
import cacao.util.SceneAnimation;
import cacao.util.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author rache
 */
public class Cacao extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        SceneManager.Instance().loadContainerView(stage, "Cacao");
        SceneManager.Instance().setSlideDirection(SceneAnimation.SlideDirection.RIGHT_TO_LEFT);
        SceneManager.Instance().changeSceneTo("IpView");
        /* Parent root = FXMLLoader.load(getClass().getResource("view/IpView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();*/
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
