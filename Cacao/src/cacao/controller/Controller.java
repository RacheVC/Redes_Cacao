package cacao.controller;

import javafx.stage.Stage;

public abstract class Controller {

    public Stage theStage;

    public Controller() {

    }

    public abstract void initialize();

    public Stage getTheStage() {
        return theStage;
    }

    public void setTheStage(Stage theStage) {
        this.theStage = theStage;
    }

}
