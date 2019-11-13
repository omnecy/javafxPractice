package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.control.EnumFxml;

import java.io.IOException;

public class SceneControl {

    private static Stage primaryStage;
    private static Parent root19000;
    private static Parent root19001;
    private static Parent root19002;
    private static Parent root19003;
    private static Scene scene19000;
    private static Scene scene19001;
    private static Scene scene19002;
    private static Scene scene19003;

    public SceneControl(Stage primaryStage) throws IOException {
        //
        this.primaryStage = primaryStage;
        //
        root19000 = FXMLLoader.load(getClass().getResource(EnumFxml.J19000.getUrl()));
        root19001 = FXMLLoader.load(getClass().getResource(EnumFxml.J19001.getUrl()));
        root19002 = FXMLLoader.load(getClass().getResource(EnumFxml.J19002.getUrl()));
        root19003 = FXMLLoader.load(getClass().getResource(EnumFxml.J19003.getUrl()));
        //
        scene19000 = new Scene(root19000, 1024, 768);
        scene19001 = new Scene(root19001, 1024, 768);
        scene19002 = new Scene(root19002, 1024, 768);
        scene19003 = new Scene(root19003, 1024, 768);
        //
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);
        primaryStage.setTitle("#19000 主界面");
        primaryStage.setScene(scene19000);
        primaryStage.show();
    }

    public static void toJ19000() {
        primaryStage.setTitle("#19000 主界面");
        primaryStage.setScene(scene19000);
    }

    public static void toJ19001() {
        primaryStage.setTitle("#19001 单词统计");
        primaryStage.setScene(scene19001);
    }

    public static void toJ19002() {
        primaryStage.setTitle("#19002 稀疏矩阵乘法");
        primaryStage.setScene(scene19002);
    }

    public static void toJ19003() {
        primaryStage.setTitle("#19003 攻击力计算");
        primaryStage.setScene(scene19003);
    }
}
