package uri;

import java.net.URI;
import java.net.URISyntaxException;

/*
    * URI is a superset of both URL and URN,
    * URL contains the protocol
    * URN does not have it
    * To Create URI object we need to pass scheme(protocol) (link) (resources)
 */
public class Uri {
    public static void main(String[] args) throws URISyntaxException {

        //scheme is the protocol that we can change to ftp or MTP depending on us
        URI uri = new URI("https","en.wikipedia.org","/wiki/URI_normalization","Normalization_process");

        System.out.println("AUTHORITY : "+uri.getAuthority());
        System.out.println("QUERY : "+uri.getQuery());
        System.out.println("HOST :   " + uri.getHost());
        System.out.println("PATH :   " + uri.getPath());
        System.out.println("PORT : " + uri.getPort());


    }
}
