package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;



public class Main extends Application {

    private Console console = new Console();
    private Terminator terminator = new Terminator();

    @Override
    public void start(Stage primaryStage){

        String json = getJSON();

        //System.out.println("json = " + json);

        //System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();

        TestO[] tester = new TestO[0];
        try {
            tester = mapper.readValue(json, TestO[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerButton[] buttons = new ServerButton[tester.length];

        Pane root = new Pane();

        int counter = 0;
        for(TestO obj : tester){
            System.out.println("obj.getName() = " + obj.getName());
            try {
                System.out.println("terminator.getPing(obj.getPing()) = " + terminator.getPing(obj.getPing()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ServerButton btn = obj.getServerButton(console, terminator, false);
            buttons[counter++] = btn;
            root.getChildren().add(btn);
        }

        root.getChildren().add(console);

        Scene scene = new Scene(root, 900, 700);
        scene.getStylesheets().add("main.css");
        primaryStage.setTitle("CS:GO Server Blocker v1.0");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        primaryStage.show();








        /*
        String[] locations = {"EU North","EU East","EU West","Middle East","US East","US West","US South-West","South-East Asia","South Africa","Australia","South America","India"};
        String[] ips = {"146.66.156.0/24,146.66.157.0/24,185.25.180.0/24,185.25.181.0/24","146.66.155.0/24,185.25.182.0/24","146.66.152.0/24,146.66.158.0/24,146.66.159.0/24","185.25.183.0/24","208.78.164.0/24,208.78.165.0/24,208.78.166.0/24","192.69.96.0/24,192.69.97.0/24","162.254.194.0/24","103.28.54.0/24,103.28.55.0/24,103.10.124.0/24","197.80.4.37/32,152.111.192.0/24,197.80.200.0/24,196.38.180.0/24,197.84.209.0/24","103.10.125.0/24","209.197.29.0/24,209.197.25.0/24,205.185.194.0/24","180.149.41.0/24,116.202.224.146/32"};
        double[] x = {410, 450, 360, 500, 200, 100, 100, 690, 450, 735, 230, 600};
        double[] y = {110, 150, 150, 200, 150, 150, 200, 280, 350, 350, 310, 200};

        boolean[] active = {true, false, true, false,true,false,true,false,true,false,true,false,true,false};

        System.out.println("Locations and IPs MATCH: " + (locations.length == ips.length));
        Httper online = new Httper();
        //online.sendGet();
        online.getLocalFile();
        Terminator terminator = new Terminator();
      //  terminator.addFirewallRule("EU WEST", "block", "127.0.0.1");
           // System.out.println("Windows Firewall is on: " + (terminator.runCommand("netsh advfirewall show public state").indexOf("ON") != -1));

        */





    }

    public String getJSON(){

        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("src/main/resources/test.json")));
        } catch (IOException e) {
            console.appendText(e + "\n");
        }
        URL data = null;
        try {
            data = new URL("http://pastebin.com/raw/k5shYUgT");
        } catch (MalformedURLException e) {
            console.appendText(e + "\n");
        }
        try {
            console.appendText("Looking for updates...");
            json = IOUtils.toString(data, "UTF-8");
            console.appendText("Succeed.\n");
        }catch(IOException e){
            console.appendText("Failed.\n");
        }

        return json;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
