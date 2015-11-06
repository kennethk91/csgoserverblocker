package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        String[] locations = {"EU North","EU East","EU West","Middle East","US East","US West","US South-West","South-East Asia","South Africa","Australia","South America","India"};
        String[] ips = {"146.66.156.0/24,146.66.157.0/24,185.25.180.0/24,185.25.181.0/24","146.66.155.0/24,185.25.182.0/24","146.66.152.0/24,146.66.158.0/24,146.66.159.0/24","185.25.183.0/24","208.78.164.0/24,208.78.165.0/24,208.78.166.0/24","192.69.96.0/24,192.69.97.0/24","162.254.194.0/24","103.28.54.0/24,103.28.55.0/24,103.10.124.0/24","197.80.4.37/32,152.111.192.0/24,197.80.200.0/24,196.38.180.0/24,197.84.209.0/24","103.10.125.0/24","209.197.29.0/24,209.197.25.0/24,205.185.194.0/24","180.149.41.0/24,116.202.224.146/32"};
        double[] x = {410, 450, 360, 500, 200, 100, 100, 690, 450, 700, 230, 600};
        double[] y = {110, 150, 150, 200, 150, 150, 200, 280, 350, 350, 310, 200};
        System.out.println("Locations and IPs MATCH: " + (locations.length == ips.length));
        Httper online = new Httper();
        //online.sendGet();
        Terminator terminator = new Terminator();
        terminator.addFirewallRule("EU WEST", "block", "127.0.0.1");
            System.out.println("Windows Firewall is on: " +
                    (terminator.runCommand("netsh advfirewall show public state").indexOf("ON") != -1));





       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane root = new Pane();

        for(int i = 0; i < locations.length; i++){

            ServerButton btn = new ServerButton(terminator, locations[i], x[i], y[i]);
            root.getChildren().add(btn);
        }

      //  ServerButton btn = new ServerButton("EU WEST", 410, 110);
      //  root.getChildren().add(btn);

        Scene scene = new Scene(root, 900, 460);
        //scene.setUserAgentStylesheet("main/java/sample/main.css");
       // System.out.println(getClass().getClassLoader().getResource("main.css"));
       scene.getStylesheets().add("main.css");
       // scene.getStylesheets().add("src/main/java/sample/main.css");
       // String css = Main.class.getResource("/main.css").toExternalForm();
        primaryStage.setTitle("CS:GO Server Blocker v1.0");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
