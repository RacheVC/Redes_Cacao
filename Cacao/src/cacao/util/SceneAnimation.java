/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacao.util;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author dpérez
 */
public class SceneAnimation {

    public enum SlideDirection {

        LEFT_TO_RIGHT(0),
        RIGHT_TO_LEFT(1),
        TOP_TO_BOTTOM(2),
        BOTTOM_TO_TOP(3);

        private final int value;

        private SlideDirection(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public static FadeTransition fadeIn(Node node, Double seconds) {
        FadeTransition ft = new FadeTransition(Duration.seconds(seconds));
        ft.setNode(node);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        return ft;
    }

    public static FadeTransition fadeOut(Node node, Double seconds) {
        FadeTransition ft = new FadeTransition(Duration.seconds(seconds));
        ft.setNode(node);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        return ft;
    }

    public static void slidePane(Pane parentPane, Node slideNode, SlideDirection direction, double endPoint, double seconds) {
        DoubleProperty traslateProperty;
        if (direction == SlideDirection.LEFT_TO_RIGHT || direction == SlideDirection.RIGHT_TO_LEFT) {
            traslateProperty = slideNode.translateXProperty();
            if (direction == SlideDirection.LEFT_TO_RIGHT) {
                slideNode.translateXProperty().setValue(-parentPane.getWidth());
            } else {
                slideNode.translateXProperty().setValue(parentPane.getWidth());
            }
        } else {
            traslateProperty = slideNode.translateYProperty();
            if (direction == SlideDirection.TOP_TO_BOTTOM) {
                slideNode.translateYProperty().setValue(-parentPane.getHeight());
            } else {

                slideNode.translateYProperty().setValue(parentPane.getHeight());
            }

        }
        parentPane.getChildren().add(slideNode);
        Timeline tl = new Timeline();
        KeyValue kv = new KeyValue(traslateProperty, endPoint, Interpolator.EASE_BOTH);
        KeyFrame kf = new KeyFrame(Duration.seconds(seconds), kv);
        tl.getKeyFrames().add(kf);
        tl.setOnFinished((event) -> {
            if (parentPane.getChildren().size() > 1) {
                parentPane.getChildren().remove(0);
            }
        });
        tl.play();
    }

    public static Timeline slide(Node slideNode, double startPoint, double endPoint, double seconds, boolean horizontal) {
        DoubleProperty traslateProperty;
        if (horizontal) {
            traslateProperty = slideNode.translateXProperty();
        } else {
            traslateProperty = slideNode.translateYProperty();
        }
        traslateProperty.setValue(startPoint);
        Timeline tl = new Timeline();
        KeyValue kv = new KeyValue(traslateProperty, endPoint, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(seconds), kv);
        tl.getKeyFrames().add(kf);
        return tl;
    }

}
