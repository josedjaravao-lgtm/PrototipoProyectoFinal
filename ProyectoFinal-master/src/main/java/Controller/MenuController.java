package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private Label messageLabel;


        @FXML
        private void showEntrar(ActionEvent event) {
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/Login-view.fxml"));

                Parent root = loader.load();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Bienvenido");
                stage.setWidth(800);
                stage.setHeight(600);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                messageLabel.setText("Error al cargar el Dashboard.");
            }
        }
    @FXML
    private void showSalir(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        Platform.exit();
    }
    }

