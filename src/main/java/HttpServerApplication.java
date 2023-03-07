import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class HttpServerApplication {

    public static void main (String[] args) throws Exception {

        if(args.length < 2) {
            System.out.println("Invalid input: no arguments provided");
        }

        try {
            Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            //throw NFE if a port number is not numerical
        }

        int port = Integer.valueOf(args[1]);

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("Server running on port " + port);
        server.createContext("/", new RandomStringHandler());
        server.start();
    }



}
