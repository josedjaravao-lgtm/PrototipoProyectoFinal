package Controller;

import Model.Client;
import Model.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientRegistrationController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField idField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField phoneField;
    @FXML
    private Label welcomeText;


    private void showAlert(String title, String content) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(title);
        errorAlert.setHeaderText(null);
        errorAlert.setContentText(content);
        errorAlert.showAndWait();
    }

    @FXML
    protected void onRegisterButtonClick() {
        String name = nameField.getText().trim();
        String ageStr = ageField.getText().trim();
        String id = idField.getText().trim();
        String mail = mailField.getText().trim();
        String phone = phoneField.getText().trim();

        if (name.isEmpty() || ageStr.isEmpty() || id.isEmpty()
                || mail.isEmpty() || phone.isEmpty()) {
            showAlert("Error de Validación", "Por favor, complete todos los campos para registrar al cliente.");
            return;
        }

        if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
            showAlert("Error de Formato", "El campo Nombre solo debe contener letras.");
            return;
        }

        int ageValue;
        try {
            ageValue = Integer.parseInt(ageStr);
            if (ageValue < 18 || ageValue > 120) {
                showAlert("Error de Formato", "La edad debe ser un número entre 18 y 120.");
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Error de Formato", "El campo Edad debe ser un número entero válido.");
            return;
        }

        if (!id.matches("\\d+")) {
            showAlert("Error de Formato", "El campo Documento (ID) solo debe contener números.");
            return;
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (!mail.matches(emailRegex)) {
            showAlert("Error de Formato", "Por favor, ingrese un formato de correo electrónico válido.");
            return;
        }

        if (!phone.matches("\\d+")) {
            showAlert("Error de Formato", "El campo Teléfono solo debe contener números.");
            return;
        }

        Client newClient = new Client(name, ageValue, id, mail, phone);

        String newAccountNumber = "C-" + (System.currentTimeMillis() % 10000);
        Account newAccount = new Account(newAccountNumber, newClient);
        newClient.setAccount(newAccount);

        ViewClientsControler.addClient(newClient);

        System.out.println("Nuevo Cliente Registrado:");
        System.out.println(newClient.toString());

        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Registro Exitoso");
        successAlert.setHeaderText(null);
        successAlert.setContentText("El cliente " + name + " ha sido registrado con la cuenta N° " + newAccountNumber);
        successAlert.showAndWait();

        nameField.clear();
        ageField.clear();
        idField.clear();
        mailField.clear();
        phoneField.clear();
    }

    @FXML
    protected void onGoBackButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/proyectofinal/Dashboard-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setWidth(600);
            stage.setHeight(450);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
            welcomeText.setText("Error al cargar la vista de registro.");
        }
    }
}