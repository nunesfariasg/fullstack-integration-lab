import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpServer66 {

    public static void main(String[] args) throws IOException {

        // Creates the server on port 6666
        HttpServer server = HttpServer.create(
                new InetSocketAddress(6666),
                0
        );


        // Route to GET requests
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

        // Route to POST requests
        server.createContext("/api/sand", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {

                // Checks if method sanded is POST
                if ("POST".equalsIgnoreCase(httpExchange.getRequestMethod())) {

                    // Reads body sanded for the client
                    InputStream inputStream = httpExchange.getRequestBody();
                    String bodyReceived = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                    System.out.println("Service received the data: " + bodyReceived);

                    // Create a confirmation response
                    String response = "Server processed the POST with success!";

                    // Sands headers with status and message size
                    httpExchange.sendResponseHeaders(200,response.getBytes().length);

                    // Sands the response message
                    OutputStream outputStream = httpExchange.getResponseBody();
                    outputStream.write(response.getBytes(StandardCharsets.UTF_8));
                    outputStream.close();

                }
                else {
                    // If it is not a POST request, returns a 405 error
                    httpExchange.sendResponseHeaders(405,-1);
                }
            }
        });

        // Starts the server
        server.setExecutor(null);// Creates a default executor
        System.out.println("Server running on port 6666...");
        server.start();
    }
}