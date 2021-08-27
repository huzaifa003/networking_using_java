package Inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    * InetAddress represents an IP address
    *
    * IP Address represents an address of a server or site
    *
    * IP Address is unqiue
    *
    * Scope of IP address is different
    * There are 3 types of Scopes:
    * -> Local Sublink which is connected locally in houses and not connected to internet
    * -> SubLocal which is local intranet
    * -> Global which is internet
    *
    * Two types of IP addresses are there : IPV4 & IPV6
 */
public class INET_Address {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress address = InetAddress.getByName("google.com"); //gets IP by name
        System.out.println("IP ADDRESS :  " + address);

        System.out.println("LOCAL ADDRESS? :  " + address.isAnyLocalAddress()); //tells if its local address

        System.out.println("HOST NAME : " + address.getHostName());
        System.out.println("HOST ADDRESS : " + address.getHostAddress()); //host address is also IPAddress without the HOST NAME

        System.out.println("LOOP BACK ADDRESS? : "+ address.isLoopbackAddress()); //A loopback address is a special IP address, 127.0. 0.1, reserved by InterNIC for use in testing network cards.
    }
}
