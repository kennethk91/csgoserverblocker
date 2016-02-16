package sample;

/**
 * Created by Kenneth on 11.11.2015.
 */
public class ServerOnMap {

    double x;
    double y;
    ServerButton button;
    PingLabel label;

    public ServerOnMap(ServerButton button, PingLabel label, double x, double y){

        this.button = button;
        this.label = label;
        this.x = x;
        this.y = y;

    }
}
