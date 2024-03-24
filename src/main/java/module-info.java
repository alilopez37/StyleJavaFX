module com.alilopez.ball {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alilopez.ball to javafx.fxml;
    exports com.alilopez.ball;
    exports com.alilopez.ball.controllers;
    exports com.alilopez.ball.models;
    opens com.alilopez.ball.controllers to javafx.fxml;
}