import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServer66 {

    public static void main(String[] args) throws IOException {

        // Creates the server on port 6666
        HttpServer server = HttpServer.create(
                new InetSocketAddress(6666),
                0
        );

        // Define the route and what it will do
        server.createContext("/api/helloworld", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {

                // Response message
                String response = "Hello, World!\n";

                // Configure headers with status and message size
                httpExchange.sendResponseHeaders(200, response.getBytes().length);

                // Write text in the message
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();
            }
        });

        // Starts the server
        server.setExecutor(null);// Creates a default executor
        System.out.println("Server running on port 6666...");
        server.start();
    }
}