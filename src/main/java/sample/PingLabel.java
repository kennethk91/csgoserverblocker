package sample;

import javafx.scene.control.Label;

/**
 * Created by Kenneth on 11.11.2015.
 */
public class PingLabel extends Label {

    public PingLabel(String name, double x, double y){

        this.setText("10ms");
        this.setLayoutX(x);
        this.setLayoutY(y);


    }
}
