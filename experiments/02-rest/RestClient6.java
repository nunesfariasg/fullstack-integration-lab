import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClient6 {
    public static void main(String[] args) {

        try {

            // Creates the http client
            HttpClient client = HttpClient.newHttpClient();

            // Constructs the request pointing to the server
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/helloworld"))
                    .GET()
                    .build();

            // Sends the request synchronously and receives the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Displays the results obtained
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Server response: " + response.body());

        } catch (Exception exception) {
            System.err.println("Error communicating with the server: " + exception.getMessage());
        }
    }
}
