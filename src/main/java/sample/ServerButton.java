package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by Kenneth on 05.11.2015.
 */
public class ServerButton extends Button {

    Terminator terminator;

    public ServerButton(Terminator terminator, String name, double x, double y){

        this.terminator = terminator;
        this.setText(name);
        this.setLayoutX(x);
        this.setLayoutY(y);

        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

    }
}
