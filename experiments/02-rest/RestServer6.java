import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class RestServer6 {
    public static void main(String[] args) throws IOException {

        // Create the server on port 8080
        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0
        );

        // Maps the endpoint to a handler
        server.createContext("/api/helloworld", new HelloWorldHandler());

        // Sets the default executor and starts the server
        server.setExecutor(null);
        server.start();
        System.out.println("Rest Server running on port 8080");
    }

    // Handler that processes HTTP requests
    static class HelloWorldHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            // Checks if the method is GET
            if ("GET".equals(httpExchange.getRequestMethod())) {

                // Response simulating JSON
                String jsonResponse = "{\"mensagem\": \"Hello, World!\"}";

                // Configures header
                httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                httpExchange.sendResponseHeaders(200, jsonResponse.getBytes().length);

                // Sands the response in the body
                OutputStream outputStream = httpExchange.getResponseBody();
                outputStream.write(jsonResponse.getBytes());
                outputStream.close();

            }
            else {

                // If another HTTP method is used
                httpExchange.sendResponseHeaders(405, -1);
            }
        }
    }
}