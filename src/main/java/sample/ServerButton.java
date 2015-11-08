package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by Kenneth on 05.11.2015.
 */
public class ServerButton extends Button {

    Terminator terminator;
    Boolean exists;
    Console console;
    String name;

    public ServerButton(Console console, Terminator terminator, Boolean exists, String name, double x, double y){

        this.console = console;
        this.terminator = terminator;
        this.exists = exists;
        this.name = name;
        this.setText(name);
        this.setLayoutX(x);
        this.setLayoutY(y);


        this.addEventHandler(ActionEvent.ACTION, event -> doSomething());

        if(exists){

            this.getStylesheets().add("buttonE.css");

        }else{

            this.getStylesheets().add("button.css");

        }

    }

    public void doSomething(){
        console.appendText(this.name + "\n");


        toggleCSS();
    }

    public void toggleCSS(){




    }

}






