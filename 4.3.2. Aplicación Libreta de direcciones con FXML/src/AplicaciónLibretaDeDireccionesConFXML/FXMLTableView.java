/*
 *  Autor : Sebastián Fernández López
 *  Descripción : Aplicación Libreta de direcciones con FXML
 */

package AplicaciónLibretaDeDireccionesConFXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTableView extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(". Aplicación Libreta de direcciones con FXML");
        Pane myPane = (Pane)FXMLLoader.load(getClass().getResource("fxml_tableview.fxml"));
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
