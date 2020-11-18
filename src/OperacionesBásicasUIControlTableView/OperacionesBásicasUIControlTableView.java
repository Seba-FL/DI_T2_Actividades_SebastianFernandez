/*
 * Autor : Sebastián Fernández López
 * Descripción : Operaciones básicas UI Control TableView
*/
package OperacionesBásicasUIControlTableView;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author UsuarioDAM
 */
public class OperacionesBásicasUIControlTableView extends Application {

    private final TableView<Person> table = new TableView<>();

    private final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("Jacob", "Smith", "jacob.smith@example.com"),
            new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person("Ethan", "Williams", "ethan.williams@example.com"),
            new Person("Emma", "Jones", "emma.jones@example.com"),
            new Person("Michael", "Brown", "michael.brown@example.com")
    );

    final HBox hbox = new HBox();

    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));

        Scene scene = new Scene(new Group());
        stage.setTitle("Operaciones básicas UI Control TableView");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label lb_AdrresBk = new Label("Address Book");
        lb_AdrresBk.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn<Person, String> tc_FirstNamCol = new TableColumn<>("First Name");
        tc_FirstNamCol.setMinWidth(100);
        tc_FirstNamCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));

        tc_FirstNamCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        tc_FirstNamCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setFirstName(t.getNewValue());
                });

        TableColumn<Person, String> tc_LastNamCol = new TableColumn<>("Last Name");
        tc_LastNamCol.setMinWidth(100);
        tc_LastNamCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
        tc_LastNamCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        tc_LastNamCol.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    ((Person) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())).setLastName(t.getNewValue());
                });

        TableColumn<Person, String> tc_EmailCol = new TableColumn<>("Email");
        tc_EmailCol.setMinWidth(200);
        tc_EmailCol.setCellValueFactory(
            new PropertyValueFactory<>("email"));
        tc_EmailCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());       
        tc_EmailCol.setOnEditCommit(
            (TableColumn.CellEditEvent<Person, String> t) -> {
                ((Person) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
        });

        /*
        // Tabla Columna -> Email
        TableColumn tb_FirstEmailCol = new TableColumn("Primary");
        TableColumn tb_SecondEmailCol = new TableColumn("Secondary");
        tc_EmailCol.getColumns().addAll(tb_FirstEmailCol, tb_SecondEmailCol);
         */
        table.setItems(data);
        table.getColumns().addAll(tc_FirstNamCol, tc_LastNamCol, tc_EmailCol);

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(tc_FirstNamCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(tc_LastNamCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(tc_EmailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Person(
                    addFirstName.getText(),
                    addLastName.getText(),
                    addEmail.getText()));
            addFirstName.clear();
            addLastName.clear();
            addEmail.clear();
        });

        hbox.getChildren().addAll(addFirstName, addLastName, addEmail, addButton);
        hbox.setSpacing(3);

        final VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().addAll(lb_AdrresBk, table, hbox);

        ((Group) scene.getRoot()).getChildren().addAll(vBox);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
    }

    public static class Person {

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }
    }

}