package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by Kenneth on 05.11.2015.
 */
public class ServerButton extends Button {

    Terminator terminator;
    boolean isBlocked;
    Console console;
    String name;

    public ServerButton(Console console, Terminator terminator, boolean isBlocked, String name, double x, double y){

        this.console = console;
        this.terminator = terminator;
        this.isBlocked = isBlocked;
        this.name = name;
        this.setText(name);
        this.setLayoutX(x);
        this.setLayoutY(y);


        this.addEventHandler(ActionEvent.ACTION, event -> doSomething());

        if(isBlocked){

            this.getStylesheets().add("buttonE.css");

        }else{

            this.getStylesheets().add("button.css");

        }

    }


    public void doSomething(){

        isBlocked = !isBlocked;

        if(isBlocked){
            console.appendText("Blocked: " + this.name + "\n");
            this.getStylesheets().add("buttonE.css");
        }else{
            console.appendText("Allowed: " + this.name + "\n");
            this.getStylesheets().add("button.css");

        }
        toggleCSS();
    }


    public void toggleCSS(){
        if(isBlocked){
            this.getStylesheets().clear();
            this.getStylesheets().add("buttonE.css");
        }else{
            this.getStylesheets().clear();
            this.getStylesheets().add("button.css");
        }
    }



}






