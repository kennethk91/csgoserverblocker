package sample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

/**
 * Created by Kenneth on 06.11.2015.
 */
public class Httper {

    private final String USER_AGENT = "Mozilla/5.0";

    public Httper(){



    }

    public Iterator<String> sendGet() throws Exception {

        String url = "http://localhost/servers.json";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
       // System.out.println(response.toString());

        ObjectMapper mapper = new ObjectMapper();
        // use the ObjectMapper to read the json string and create a tree
        String json = response.toString();
        JsonNode node = mapper.readTree(json);

        Iterator<String> nodeIterator = node.fieldNames();
        while(nodeIterator.hasNext()){
            String current = nodeIterator.next();
            System.out.print( node.path(current) + ",");
        }

        System.out.println("");




        String[] ips = node.path("Australia").asText().split(",");

        System.out.println(ips[0]);

        return node.fieldNames();

    }
}
