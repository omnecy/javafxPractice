package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.SceneControl;
import sample.action.J19002.J19002;

public class J19002Controller {

    @FXML
    private TextField text00;
    @FXML
    private TextField text01;
    @FXML
    private TextField text02;
    @FXML
    private TextField text10;
    @FXML
    private TextField text11;
    @FXML
    private TextField text12;
    @FXML
    private TextArea textArea;
    @FXML
    private Label label0;
    @FXML
    private Label label1;

    private J19002 j19002;

    @FXML
    private void initialize() {
        j19002 = new J19002(text00, text01, text02, text10, text11, text12, textArea, label0, label1);
    }

    // 点击1号加号
    public void button1Plus() {
        j19002.add0();
    }
    public void button2Plus() {
        j19002.add1();
    }
    // 点击1号clc
    public void button1Clc() {
        j19002.clc();
    }
    public void button2Clc() {
        j19002.clc();
    }
    //点击乘
    public void buttonX() {
        j19002.x();
    }

    // 返回主界面
    public void button19000Action() {
        SceneControl.toJ19000();
    }
}
