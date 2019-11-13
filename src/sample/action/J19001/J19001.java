package sample.action.J19001;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class J19001 {

    private TextField textField;
    private TextArea textArea;

    public J19001(TextField textField, TextArea textArea) {
        this.textArea = textArea;
        this.textField = textField;
    }

    public void run() {

        String pathname = textField.getText();
        HashMap<String, Integer> map = new HashMap();

        //try-with-resources自动关闭文件
        try (BufferedReader br = new BufferedReader(new FileReader(pathname))) {

            // 读入行
            String line;
            // 单词
            String word;
            // 出现数目
            int num;
            // 正则表达式
            Pattern p = Pattern.compile("[A-Z]");
            textArea.setText("1.读入内容如下所示：\n");
            while ((line = br.readLine()) != null) {

                // 一次读入一行数据
                textArea.setText(textArea.getText() + line + "\n");
                Matcher m = p.matcher(line.toUpperCase());
                while (m.find()) {

                    word = m.group();
                    // 如果单词出现过，则加1，没出现过则直接值1
                    if( map.containsKey(word) ){
                        num = map.get(word);
                        map.put(word, num+1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
            textArea.setText(textArea.getText() + "2.各单词出现次数如下所示：\n");
            map.forEach((k, v) ->
                textArea.setText(textArea.getText() + "单词\"" + k + "\"出现次数: " + v + "\n")
            );

        } catch (IOException e) {
            textField.setText("ERROR！ 请重新输入");
            e.printStackTrace();
        }
    }
}
