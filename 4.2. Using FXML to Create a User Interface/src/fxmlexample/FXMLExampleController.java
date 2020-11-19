/*
    Autor : Sebastián Fernández López
    Descripción : FXMLExampleController
*/

package fxmlexample;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
 
public class FXMLExampleController {
    @FXML private Text actiontarget;
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }

}
