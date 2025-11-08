package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label messageLabel;

    @FXML
    protected void onRegisterClientButtonClick(ActionEvent event) {
        try {
            welcomeText.setText("Abriendo formulario de registro...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/ClientRegistration-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Registro de Cliente");
            stage.setWidth(600);
            stage.setHeight(450);
            stage.show();



        } catch (IOException e) {
            e.printStackTrace();
            welcomeText.setText("Error al cargar la vista de registro.");
        }

    }
    @FXML
    protected void onViewClientsButtonClick(ActionEvent event) {
        try {
            welcomeText.setText("Abriendo listado de clientes.");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/Clients-view.fxml"));

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Clientes y Cuentas");
            stage.setWidth(800);
            stage.setHeight(500);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            welcomeText.setText("Error al cargar la vista de usuarios.");
        }
    }


        @FXML
        protected void onLoanManagementButtonClick () {
            welcomeText.setText("Función para gestión de préstamos no implementada aún.");
        }
    }
