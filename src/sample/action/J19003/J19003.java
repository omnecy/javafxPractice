package sample.action.J19003;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class J19003 {

    private Button button1;
    private Button button2;
    private Button button3;
    private TextArea textArea;

    // 能量控制,初始能量为5
    private int num = 3;

    public J19003(Button button1, Button button2, Button button3, TextArea textArea) {

        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.textArea = textArea;
    }

    public synchronized void attack() {

        try {
            if (num > 0) {
                textArea.setText(textArea.getText() + "attack!!!\n");
                num -= 1;
                setColor(num);
                Thread.sleep(1000);
            } else if (num == 0) {
                textArea.setText(textArea.getText() + "上弹中。。。。。。\n");
                Thread.sleep(5000);
                textArea.setText(textArea.getText() + "完成上弹。。。。。。\n");
                num = 3;
                setColor(num);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setColor(int num) {

        switch (num) {
            case 0:
                button1.setStyle("-fx-background-color:black");
                button2.setStyle("-fx-background-color:black");
                button3.setStyle("-fx-background-color:black");
                break;
            case 1:
                button1.setStyle("-fx-background-color:white");
                button2.setStyle("-fx-background-color:black");
                button3.setStyle("-fx-background-color:black");
                break;
            case 2:
                button1.setStyle("-fx-background-color:white");
                button2.setStyle("-fx-background-color:white");
                button3.setStyle("-fx-background-color:black");
                break;
            case 3:
                button1.setStyle("-fx-background-color:white");
                button2.setStyle("-fx-background-color:white");
                button3.setStyle("-fx-background-color:white");
                break;
        }
    }
}
