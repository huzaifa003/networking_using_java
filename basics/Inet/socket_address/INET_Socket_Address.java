package Inet.socket_address;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/*
    * Combination of IP address (INET ADDRESS) and a PORT is called Socket
    * Socket Address contains both IP Address and Port No
 */
public class INET_Socket_Address {
    public static void main(String[] args) throws UnknownHostException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(5000);
        //since we did not specify the IP address it will give out 0.0.0.0
        // (0.0.0.0 is a non-routable meta-address used to designate an invalid, unknown, or non-applicable target (a ‘no particular address’ place holder).
        printProperties(inetSocketAddress,"inetSocketAddress");

        InetSocketAddress inetSocketAddress1 = new InetSocketAddress(InetAddress.getByName("google.com"),4500);
        printProperties(inetSocketAddress1,"inetSocketAddress1");

        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost",4000); //localhost has loopback address of 127.0.0.1
        printProperties(inetSocketAddress2,"inetSocketAddress2");


    }

    public static void printProperties(InetSocketAddress address , String name)
    {
        System.out.println("---PROPERTIES OF " + name + "---");
        System.out.println("Address :  " + address.getAddress());
        System.out.println("Port :  " + address.getPort());
        System.out.println("HOSTNAME : " + address.getHostName());
        System.out.println("--------------------------------------");
    }
}
