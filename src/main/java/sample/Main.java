package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import processing.core.PApplet;

public class Main extends Application {
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group group = new Group();
//        group.getChildren().add(sphere);

        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);


        Polygon poly = new Polygon();
        poly.getPoints().addAll(0.0, 0.0,
                20.0, 10.0,
                10.0, 20.0);
        poly.translateXProperty().set(WIDTH / 2.0);
        poly.translateYProperty().set(HEIGHT / 2.0);

        group.getChildren().add(poly);


        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event ->{
            ObservableList<Double> pts = poly.getPoints();
            Double d = pts.get(1);
            switch (event.getCode()) {
                case W:
                    poly.translateXProperty().set(poly.getTranslateX() + 100);
                    pts.set(1, d += 20.0);

                    break;
                case S:
                    poly.translateXProperty().set(poly.getTranslateX() - 100);
                    pts.set(1, d -= 20.0);

                    break;
            }
        });

        primaryStage.setTitle("Genuine Coder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        PApplet.main("sample.Show");
        launch(args);
    }
}
