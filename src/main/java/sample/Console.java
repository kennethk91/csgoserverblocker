package sample;

import javafx.scene.control.TextArea;

/**
 * Created by Kenneth on 08.11.2015.
 */
public class Console extends TextArea {

    public Console(){

        this.setEditable(false);
        this.setLayoutX(0);
        this.setLayoutY(460);
        this.setWrapText(true);

        this.appendText("Console \n");

    }
}
