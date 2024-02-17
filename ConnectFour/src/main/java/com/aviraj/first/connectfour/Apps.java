package com.aviraj.first.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Apps extends Application {
    private Controller controller;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Apps.class.getResource("game.fxml"));
        GridPane rootGridPane=loader.load();


        controller=loader.getController();
        controller.createPlayGround();

        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(stage.widthProperty());

        Pane menuPane=(Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        stage.setScene(scene);
        stage.setTitle("Connect Four");
        stage.setResizable(false);
        stage.show();
    }

    private MenuBar createMenu()
    {
//        file Menu
        Menu fileMenu= new Menu("File");
       //new Game
        MenuItem newGame=new MenuItem("New Game");
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.resetGame();
            }
        });
        //reset game
        MenuItem resetGame= new MenuItem("Reset Game");
        resetGame.setOnAction(event -> {
            controller.resetGame();
        });
        //seperation
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem exitGame= new MenuItem(" Exit");
        exitGame.setOnAction(event -> exitGame());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);
       //Help Menu
        Menu helpMenu= new Menu("Help");
         //about Game
        MenuItem aboutGame=new MenuItem("About Connect-4");
        aboutGame.setOnAction(event -> aboutConnect4());
        SeparatorMenuItem separator=new SeparatorMenuItem();
        //about me
        MenuItem aboutMe= new MenuItem(" About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

/*

    private void aboutConnect4() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to Play ?");
        alert.setContentText("Connect Four is a two-player connection game in which the players " +
                "first choose a color and then take turns dropping colored discs from the top into " +
                "a seven-column, six-row vertically suspended grid. The pieces fall straight down, " +
                "occupying the next available space within the column. The objective of the game is " +
                "to be the first to form a horizontal, vertical, or diagonal line of four of one's " +
                "own discs. Connect Four is a solved game. The first player can always win by playing " +
                "the right moves.");
        alert.show();
    }

 */
private void aboutConnect4() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("About Connect Four");
    alert.setHeaderText("How to Play ?");

    String content = "Connect Four is a two-player connection game in which the players " +
            "first choose a color and then take turns dropping colored discs from the top into " +
            "a seven-column, six-row vertically suspended grid. The pieces fall straight down, " +
            "occupying the next available space within the column. The objective of the game is " +
            "to be the first to form a horizontal, vertical, or diagonal line of four of one's " +
            "own discs. Connect Four is a solved game. The first player can always win by playing " +
            "the right moves."; // Take infromation as a string

    Text text = new Text(content);


    text.setFont(Font.font("Arial",  14)); // Set the desired font, weight, and size

// Rest of the code...

    text.setWrappingWidth(650); // Set the desired width for text wrapping

    alert.getDialogPane().setContent(text); // Swt content
    alert.show();
}

    private void aboutMe() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Me");
        alert.setHeaderText("Avi Raj");
        alert.setContentText("I am Avi Raj and want to be a Good Java Developer and always exploring about new things and technology");
        alert.show();
    }
    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

//    private void resetGame() {
//        //TODO
//    }

    public static void main(String[] args)
    {

        launch(args);
    }
}