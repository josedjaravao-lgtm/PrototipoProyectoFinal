package Controller;

import Model.Client;
import Model.Account;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewClientsControler implements Initializable {

    @FXML
    private TableView<Client> clientTable;
    @FXML
    private TableColumn<Client, String> nameColumn;
    @FXML
    private TableColumn<Client, String> idColumn;
    @FXML
    private TableColumn<Client, String> ageColumn;
    @FXML
    private TableColumn<Client, String> mailColumn;
    @FXML
    private TableColumn<Client, String> phoneColumn;
    @FXML
    private TableColumn<Client, String> accountColumn;
    @FXML
    private Label welcomeText;

    private static ObservableList<Client> clientListStatic = FXCollections.observableArrayList();
    private ObservableList<Client> clientList = clientListStatic;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (clientListStatic.isEmpty()) {
            loadDummyData();
        }

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<>("mail"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        accountColumn.setCellValueFactory(cellData -> {
            Client client = cellData.getValue();
            if (client.getAccount() != null) {
                // Asume que Account tiene un getNumAccount() que devuelve String
                return new SimpleStringProperty(client.getAccount().getnumAccount());
            } else {
                return new SimpleStringProperty("N/A");
            }
        });

        clientTable.setItems(clientList);
    }

    public static void addClient(Client newClient) {
        clientListStatic.add(newClient);
    }

    private void loadDummyData() {

        Client client1 = new Client("Ana Perez", 21, "1032988652", "ana.perez@mail.com", "3204387063");
        Client client2 = new Client("Juan Lopez", 22, "1032688787", "juan.lopez@mail.com", "3218917298");

        Account acc1 = new Account("C-1001", client1);
        acc1.deposited(800000);
        Account acc2 = new Account("C-1002", client2);
        acc2.deposited(900000);

        client1.setAccount(acc1);
        client2.setAccount(acc2);

        clientListStatic.add(client1);
        clientListStatic.add(client2);

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