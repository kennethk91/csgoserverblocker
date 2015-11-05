package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        final Process p = Runtime.getRuntime().exec("netsh advfirewall show public state");


                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;
                String total = "";
                try {
                    while ((line = input.readLine()) != null)
                        total += line;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            System.out.println("Windows Firewall is on: " + (total.indexOf("ON") != -1));





       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane root = new Pane();


        ServerButton btn = new ServerButton("EU WEST", 410, 110);
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 900, 460);
        scene.getStylesheets().add
                (Main.class.getResource("main.css").toExternalForm());
        primaryStage.setTitle("CS:GO Server Blocker v1.0");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
