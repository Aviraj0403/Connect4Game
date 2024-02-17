package com.aviraj.first.connectfour;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Page");

        GridPane grid = new GridPane();
        grid.setAlignment(javafx.geometry.Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label userNameLabel = new Label("User Name:");
        grid.add(userNameLabel, 0, 1);

        TextField userNameTextField = new TextField();
        grid.add(userNameTextField, 1, 1);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 3);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 4);

        loginButton.setOnAction(event -> {
            String userName = userNameTextField.getText();
            String password = passwordField.getText();

            if (isValidCredentials(userName, password)) {
                actionTarget.setFill(Color.GREEN);
                actionTarget.setText("Login successful!");
            } else {
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Invalid credentials.");
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isValidCredentials(String userName, String password) {
        // In a real application, you would implement your logic for validating credentials here.
        // For this example, let's assume valid credentials are "username" and "password".
        return userName.equals("username") && password.equals("password");
    }
}
