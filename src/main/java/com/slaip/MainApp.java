package com.slaip;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("DB Editor");
        stage.setScene(scene);
        stage.show();
//        ArticleDao articleDao = new ArticleDao();
//        articleDao.getArticles().forEach(System.out::println);
    }

}