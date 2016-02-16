package sample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Console console = new Console();
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


       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane root = new Pane();

        for(int i = 0; i < locations.length; i++){

            ServerButton btn = new ServerButton(console, terminator, active[i], locations[i], x[i], y[i]);
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
        String content = new String(Files.readAllBytes(Paths.get("src/main/resources/test.json")));

        ObjectMapper mapper = new ObjectMapper();
        // use the ObjectMapper to read the json string and create a tree
        String json = content;
        JsonNode node = mapper.readTree(json);

        Iterator<String> nodeIterator = node.fieldNames();
        while(nodeIterator.hasNext()){
            String current = nodeIterator.next();
            System.out.println( node.path(current));
        }

        Terminator terminator = new Terminator();

        */













    }



    public static void main(String[] args) {
        launch(args);
    }
}
