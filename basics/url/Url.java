package url;

import java.net.MalformedURLException;
import java.net.URL;

/*
    * URL is uniform resource locator
    * URL class is responsible for managing the URLs
    * A Uniform Resource Locator (URL) is a subset of the Uniform Resource Identifier (URI) that specifies where an identified resource is available and the mechanism for retrieving it
    * A URL defines how the resource can be obtained. It does not have to be a HTTP URL (http://), a URL can also start with ftp:// or smb://, specifying the protocol that's used to get the resource.
    *
    * A URI identifies a resource either by location, or a name, or both. A
    * URI has two specializations known as URL and URN.
    *
    * A Uniform Resource Name (URN) is a Uniform Resource Identifier (URI) that uses the URN scheme, and does not imply availability of the identified resource.
    *
    *
    * URL: mailto:John.Doe@example.com
    * URL: news:comp.infosystems.www.servers.unix
    * URL: telnet://192.0.2.16:80/
    * URN (not URL): urn:oasis:names:specification:docbook:dtd:xml:4.1.2
    *
    *
 */
public class Url {
    public static void main(String[] args) {

        String address =  "https://en.wikipedia.org/wiki/URL#Citations";

        URL url = null;
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (url != null) {
            printUrlProperties(url);
        }
    }

    private  static void  printUrlProperties(URL url)
    {
        System.out.println("HOST :   " + url.getHost());
        System.out.println("PATH :   " + url.getPath());
        System.out.println("REF :   " + url.getRef());
        System.out.println("AUTHORITY : " + url.getAuthority()); //Authority is host name + port no
        System.out.println("PORT : " + url.getPort()); //port will be -1 cause we have not connected to website yet
    }
}
