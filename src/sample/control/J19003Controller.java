package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.SceneControl;
import sample.action.J19003.J19003;

public class J19003Controller {

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private TextArea textArea;

    private J19003 j19003;

    @FXML
    private void initialize() {
        j19003 = new J19003(button1, button2, button3, textArea);
    }

    public void attack() {
        j19003.attack();
    }

    public void button19000Action() {
        SceneControl.toJ19000();
    }
}
