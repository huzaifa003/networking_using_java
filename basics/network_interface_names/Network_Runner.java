package network_interface_names;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/*
    * NetworkInterface class helps to connect to devices on a netowrk
    * they can be wired, have LAN, or by bluetooth
    * network is a connection that can be done using NIC
    *
    * NetworkInterface class reps an IP and helps to connect to different IPs
    *
 */

public class Network_Runner {
    public static void main(String[] args) {
        //---------------------NetworkInterface.getNetworkInterfaces()------------------\\
        /*
            * it is used to get the enumerations of all the networking devices connected to our pc
            * 
            * ENUMERATION IS ITERATOR NOT TO BE CONFUSED WITH ENUMs
         */


        try {
            Enumeration<NetworkInterface> connectedInterfaces  = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface component :
                    Collections.list(connectedInterfaces)) {
                System.out.println(component.getName() + "    " + component.getDisplayName()); //getName is port name and getDisplayName() is human readable name
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n\n");
        //---------------------NetworkInterface.getNetworkInterfaces()------------------\\

        try {
            System.out.println(NetworkInterface.getByName("eth3")); //displays by name NOT displayName()
        } catch (SocketException e) {
            e.printStackTrace();
        }

        //theres another method by initAddress will be discussed later

    }
}
