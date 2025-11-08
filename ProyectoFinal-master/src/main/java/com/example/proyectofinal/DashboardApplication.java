package com.example.proyectofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                DashboardApplication.class.getResource("Main-view.fxml") );

                Scene scene = new Scene(fxmlLoader.load(), 600, 400);

                stage.setTitle("Inicio de Sesión");
                stage.setScene(scene);
                stage.show();
    }

}