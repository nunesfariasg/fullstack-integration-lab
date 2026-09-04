import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient66 {
    public static void main(String[] args) {

        getRequest();
    }

    private static void getRequest() {

        try {

            // Creates the http client
            HttpClient client = HttpClient.newHttpClient();

            // Configure the request to the server address
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:6666/api/helloworld"))
                    .GET() // Define the method
                    .build();

            // Sends the request and receives the response from the server
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Displays the results in the console
            System.out.println("Server status code: " + response.statusCode());
            System.out.println("Response content: " + response.body());


        } catch (Exception exception) {
            System.err.println("Error connecting to server" + exception.getMessage());
        }
    }
}