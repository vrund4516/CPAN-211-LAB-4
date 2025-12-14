package ca.humber.vrund.lab4_main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Lab4_Main extends Application {

    private double x = 100;
    private double y = 100;
    private static final double STEP = 10;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 600, 400);

        scene.setOnKeyPressed(e -> {
            double newX = x;
            double newY = y;

            KeyCode code = e.getCode();
            switch (code) {
                case RIGHT -> newX += STEP; // east
                case LEFT  -> newX -= STEP; // west
                case UP    -> newY -= STEP; // north (y decreases)
                case DOWN  -> newY += STEP; // south
                default    -> { return; }   // ignore other keys
            }

            pane.getChildren().add(new Line(x, y, newX, newY));
            x = newX;
            y = newY;
        });

        stage.setTitle("CPAN 211 - Lab 4 (Event-Driven)");
        stage.setScene(scene);
        stage.show();

        // Ensure arrow keys work immediately
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
