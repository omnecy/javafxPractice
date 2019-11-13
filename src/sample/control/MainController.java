package sample.control;

import javafx.fxml.FXML;
import sample.SceneControl;

public class MainController {

    @FXML
    private void initialize() {}

    public void button19001Action() {
        SceneControl.toJ19001();
    }

    public void button19002Action() {
        SceneControl.toJ19002();
    }

    public void button19003Action() {
        SceneControl.toJ19003();
    }

}
