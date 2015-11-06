package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kenneth on 05.11.2015.
 */
public class Terminator {



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

        return null;
    }


}
