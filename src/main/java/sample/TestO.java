package sample;


/**
 * Created by Kenneth on 26.02.2016.
 */
public class TestO{

    private String name;
    private String ips;
    private String ping;
    private int x;
    private int y;
    private boolean show;



    public TestO(String name, String ips, String ping, int x, int y, boolean show) {
        this.name = name;
        this.ips = ips;
        this.ping = ping;
        this.x = x;
        this.y = y;
        this.show = show;
    }

    public TestO(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPing() {
        return ping;
    }

    public void setPing(String ping) {
        this.ping = ping;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public ServerButton getServerButton(Console console, Terminator terminator, boolean isBlocked){
        return new ServerButton(console,terminator,isBlocked,name,x,y);
    }


}
