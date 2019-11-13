package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.SceneControl;
import sample.action.J19001.J19001;

public class J19001Controller {

    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;

    private J19001 j19001;

    @FXML
    private void initialize() {
        j19001 = new J19001(textField, textArea);
    }

    public void button19000Action() {
        SceneControl.toJ19000();
    }

    public void setOnKeyEvent(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            j19001.run();
        }

    }

}
