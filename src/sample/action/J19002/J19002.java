package sample.action.J19002;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class J19002 {

    private TextField text00;
    private TextField text01;
    private TextField text02;
    private TextField text10;
    private TextField text11;
    private TextField text12;
    private TextArea textArea;
    private Label label0;
    private Label label1;

    private int[][] arr0 = new int[1][1];
    private int[][] arr1 = new int[1][1];

    // 非0元素数量
    private int num0 = 0;
    private int num1 = 0;

    public J19002(TextField text00, TextField text01, TextField text02, TextField text10,
                  TextField text11, TextField text12, TextArea textArea, Label label0,
                  Label label1) {
        this.label0 = label0;
        this.label1 = label1;
        this.text00 = text00;
        this.text01 = text01;
        this.text02 = text02;
        this.text10 = text10;
        this.text11 = text11;
        this.text12 = text12;
        this.textArea = textArea;
    }

    public void add(int row, int col, int data, int[][] arr, int num) {

        if (row >= arr.length || col >= arr[0].length) {

            int max = Math.max(row, col);
            int[][] ar = new int[max + 1][max + 1];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    ar[i][j] = arr[i][j];
                }
            }
            arr = ar;
        }

        // 加数
        int plus = 0;
        if (arr[row][col] == 0) {
            plus = 1;
        }
        arr[row][col] = data;

        if (num == 0) {
            arr0 = arr;
            num0 += plus;
        } else if (num == 1) {
            arr1 = arr;
            num1 += plus;
        }

        textArea.setText("矩阵1：" + Arrays.deepToString(arr0) +
                "\n矩阵2：" + Arrays.deepToString(arr1));
        label0.setText("非0元素数量：" + num0);
        label1.setText("非0元素数量：" + num1);
    }

    public void add0() {

        int row = Integer.valueOf(text00.getText());
        int col = Integer.valueOf(text01.getText());
        int data = Integer.valueOf(text02.getText());

        add(row, col, data , arr0, 0);
    }

    public void add1() {

        int row = Integer.valueOf(text10.getText());
        int col = Integer.valueOf(text11.getText());
        int data = Integer.valueOf(text12.getText());

        add(row, col, data , arr1, 1);
    }

    public void clc() {
        arr0 = new int[1][1];
        arr1 = new int[1][1];
        num0 = 0;
        num1 = 0;
        textArea.setText("矩阵1：" + Arrays.deepToString(arr0) +
                "\n矩阵2：" + Arrays.deepToString(arr1));
        label0.setText("非0元素数量：" + num0);
        label1.setText("非0元素数量：" + num1);
    }

    public void x() {

        int max = Math.max(Math.max(arr0.length, arr0[0].length),
                Math.max(arr1.length, arr1[0].length));

        int[][] ar = new int[max + 1][max + 1];
        for (int i = 0; i < arr0.length; i++) {
            for (int j = 0; j < arr0[i].length; j++) {
                ar[i][j] = arr0[i][j];
            }
        }
        arr0 = ar;
        ar = new int[max + 1][max + 1];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                ar[i][j] = arr1[i][j];
            }
        }
        arr1 = ar;
        ar = new int[max + 1][max + 1];

        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                for (int k = 0; k < arr0[i].length; k++) {
                    ar[i][j] += arr0[i][k] * arr1[k][j];
                }
            }
        }

        CrossList cList = new CrossList(ar);
        StringBuilder s = cList.print();
        textArea.setText(textArea.getText() + "\n" + s);
    }
}
