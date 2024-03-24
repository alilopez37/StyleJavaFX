package com.alilopez.ball.controllers;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.Timer;

import com.alilopez.ball.models.Ball;
import com.alilopez.ball.models.ThreadBall;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HomeController implements Observer {
    private Ball ball;
    @FXML
    private Button detenerBtn;

    @FXML
    private TextField userTextField;
    private Integer x;
    private Integer y;
    ThreadBall tBall;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane container;

    @FXML
    private Button iniciarBtn;

    @FXML
    void onClickedIniciarBtn(MouseEvent event) {
        tBall = new ThreadBall();
        tBall.addObserver(this);
        Thread hilo = new Thread(tBall);
        hilo.start();
    }

    @FXML
    void onClickedDetenerBtn(MouseEvent event) {
        tBall.setStatus(false);
    }


    @FXML
    void initialize() {
        x = 100;
        y = 100;
        ball = new Ball();
        ball.setFill(Color.DARKRED);
        ball.setRadius(10);
        ball.setLayoutX(x);
        ball.setLayoutY(y);

        container.getChildren().add(ball);
        container.getStylesheets().add("style.css");
        userTextField.getStyleClass().addAll ("text-user");
    }

    @Override
    public void update(Observable observable, Object o) {
        String data = (String)o;
        System.out.println(data);
        String[] pos = data.split(":");
        Platform.runLater(()->{
            ball.setLayoutX(Integer.parseInt(pos[0]));
            ball.setLayoutY(Integer.parseInt(pos[1]));
        });
    }
}
