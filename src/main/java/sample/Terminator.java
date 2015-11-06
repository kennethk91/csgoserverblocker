package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kenneth on 05.11.2015.
 */
public class Terminator {

    public Terminator(){
        String[] arr = {"1","2","3"};
        System.out.println(buildIPString(arr));
    }

    /*
    Runs a command in shell and returns result
     */
    public String runCommand(String command) throws IOException {

        final Process p = Runtime.getRuntime().exec(command);

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        String total = "";

        while ((line = input.readLine()) != null)
                total += line;

        return total;


    }


    //netsh advfirewall firewall add rule name="IP Block" dir=in interface=any action=block remoteip=192.169.0.10/32

    public String addFirewallRule(String name, String action, String ip){

        String rule = String.format("netsh advfirewall firewall add rule name='%s' dir=in interface=any action=%s remoteip=%s", name, action, ip);
        //System.out.println(rule);
        //netsh advfirewall firewall delete rule name=""
        return null;
    }

    /**
     * Converts array of strings into String with , as delimiter
     * @param ips String array of IPs
     * @return String
     */
    public String buildIPString(String[] ips){
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < ips.length; i++) {
            if(i == ips.length - 1)
                strBuilder.append(ips[i]);
            else
                strBuilder.append(ips[i] + ",");
        }
        return strBuilder.toString();
    }




}
