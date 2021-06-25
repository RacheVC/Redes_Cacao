package cacao.util;

import cacao.controller.ContenedorController;
import cacao.controller.Controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;


public class SceneManager {
    
    public static final int SLIDE_TRANSITION = 0;
    public static final int APPEAR_TRANSITION = 1;

    private Stage theStage;
    private ContenedorController contenedorController;
    private final HashMap<String, FXMLLoader> loaders = new HashMap<>();
    private int transitionEffect;
    private SceneAnimation.SlideDirection slideDirection;
    private static SceneManager _instance = null;
 
    

    public SceneManager() {
       this.transitionEffect = SLIDE_TRANSITION;
       this.slideDirection = SceneAnimation.SlideDirection.LEFT_TO_RIGHT;
    }

    
    public static SceneManager Instance() {
        if (_instance == null) {
            synchronized (SceneManager.class) {
                if (_instance == null) {
                    _instance = new SceneManager();
                }
            }
        }
        return _instance;
    }

    public Stage getTheStage() {
        return theStage;
    }
    
    public int getTransitionEffect() {
        return transitionEffect;
    }

    public void setTransitionEffect(int transitionEffect) {
        this.transitionEffect = transitionEffect;
    }

    public SceneAnimation.SlideDirection getSlideDirection() {
        return slideDirection;
    }

    public void setSlideDirection(SceneAnimation.SlideDirection slideDirection) {
        this.slideDirection = slideDirection;
    }
    
   
    private FXMLLoader getLoader(String sceneName) {
        try {
            FXMLLoader loader = loaders.get(sceneName);
            if(loader == null){
            loader = new FXMLLoader(cacao.Cacao.class.getResource("view/" + sceneName + ".fxml"));
            loader.load();
            ((Controller) loader.getController()).setTheStage(this.theStage);
            SceneManager.Instance().loaders.put(sceneName, loader);
            }
            return loader;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SceneManager.class.getName()).log(Level.SEVERE, "Creando loader [" + sceneName + "].", ex);
            return null;
        }
    }

        /**
     * Load the main container for the scenes
     * @param theStage the primary stage
     * @param tittle
     */
    public void loadContainerView(Stage theStage, String tittle) {
        this.theStage = theStage;
        this.theStage.setTitle(tittle);
        this.theStage.setMinWidth(800.d);
        this.theStage.setMinHeight(600.d);
        this.contenedorController = (ContenedorController) getLoader("ContenedorView").getController();
        Scene scene = new Scene(this.contenedorController.getRootNode());
        this.theStage.setScene(scene);
        this.theStage.setMaximized(true);
        this.theStage.show();
    }

    /**
     * Este método cambia la actual a la indicada
     * @param sceneName nombre de la escena
     */
    public void changeSceneTo(String sceneName) {
         SceneManager.Instance().getTheStage().getScene().setOnKeyPressed(null);
        FXMLLoader loader = getLoader(sceneName);
        Controller controller = (Controller) loader.getController();
        controller.initialize();
        this.contenedorController.setActualScene(sceneName);
        this.contenedorController.verificarElementosDeTopBar();
        if(transitionEffect == SLIDE_TRANSITION){
            SceneAnimation.slidePane(this.contenedorController.getStackPaneContent(), loader.getRoot(), this.slideDirection, 0.0, 0.6);
        }else{
            this.contenedorController.getStackPaneContent().getChildren().clear();
            this.contenedorController.getStackPaneContent().getChildren().add(loader.getRoot());
            SceneAnimation.fadeIn(this.contenedorController.getStackPaneContent(), 0.6);
        }
    }
    
     /**
     * Este método permite crear una ventana modal
     * @param  sceneName  nombre de la escena
     */
    public void madeModal(String sceneName) {
        FXMLLoader loader = getLoader(sceneName);
        Controller controller = loader.getController();
        controller.initialize();
        Stage stage = new Stage();
        stage.setOnHidden((WindowEvent event) -> {
            controller.getTheStage().getScene().setRoot(new Pane());
            controller.getTheStage().setScene(null);
            controller.setTheStage(null);
        });
        controller.setTheStage(stage);
        stage.setScene(new Scene(loader.getRoot()));
        stage.initStyle(StageStyle.DECORATED);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(this.theStage);
        stage.centerOnScreen();
        SceneAnimation.fadeIn(stage.getScene().getRoot(),0.5);
        stage.showAndWait();   
    }
    
    /**
     * Resetea todos los loders cargados
     */
    public void reset(){
        this.loaders.clear();
    }
    

    /**
     * Esta método cierra la ventana princiapl de la aplicación
     */
    public void finalizeMainView(){
        this.theStage.close();
    }
     

}
